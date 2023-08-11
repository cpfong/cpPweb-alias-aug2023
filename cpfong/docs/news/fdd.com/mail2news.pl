#!/usr/bin/perl


($program = $0) =~ s%.*/%%;

#( $version  ) = $] =~ /(\d+\.\d+).*\nPatch level/;
#die "$program: requires at least version 3 of perl\n"
#        if $version < 3;

# $inews = "/usr/bin/inews";
# $iopts = "-h -o \"mail2news gateway\"";
$inews = "/usr/bin/rnews";
$iopts = "-r localhost";
$postinghost = "localhost";

$inews = "cat";
$iopts = "";

if ($#ARGV < 0) {
    # $newsgroup = "test";
    # we'll expect the newsgroup line in the body
} elsif ($#ARGV == 0) {
    $newsgroup = $ARGV[0];
} else {
    die "usage: $program [newsgroup]\n";
}

# in case inews dumps core or something crazy
$SIG{'PIPE'} = "plumber";
sub plumber { die "$program: \"$inews\" died prematurely!\n"; }

open (INEWS, "| $inews $iopts") ||
    die "$program: can't run $inews\n";

# header munging loop
while (<STDIN>) {
   last if /^$/;

   # transform real from: line back to icky style
   s/^From:\s+(.*) <(.*)>/From: $2 ($1)/;

   s/Message-Id/Message-ID/;
 
   # transform from_ line to path header; also works locally
   s/^From\s+(\S+)@(\S+).*/Path: $2!$1/
     || s/^From\s+(\S+)[^@]*$/Path: $1\n/;

   print INEWS
#       if /^(Date|From|Subject|Path|Newsgroups|Organization|Message-ID):/i;
   if /^(Date|From|Subject|Path|Newsgroups|Message-ID):/i;
   $saw_subject |= ( $+ eq 'Subject' );

   $saw_msgid |= ( $+ eq 'Message-ID' );

#   $saw_newsgroup |= ( $+ eq 'Newsgroups' );
}

warn "$program: didn't expect newsgroup in both headers and ARGV\n"
    if $newsgroup && $saw_newsgroup;
 
die "$program: didn't get newsgroup from either headers or ARGV\n"
    unless $newsgroup || $saw_newsgroup;
     
$approved = $newsgroup;
$approved =~ s/\./'-'/eg;

($sec,$min,$hour,$mday,$mon,$year)=localtime(time);
$madeupid = "\<$year$mon$mday.$hour$min$sec.$$\@kepler.hedland.edu.au\>";

printf INEWS "Newsgroups: %s\n", $newsgroup if $newsgroup;
printf INEWS "Approved: %s\@kepler.hedland.edu.au\n", $approved;
print  INEWS "Subject: Untitled\n" unless $saw_subject;
printf INEWS "Message-ID: %s\n", $madeupid unless $saw_msgid;
printf INEWS "NNTP-Posting-Host: %s\n", $postinghost;
print  INEWS "Organisation: (mail2news gateway)\n";
print  INEWS "\n";
 
print INEWS while <STDIN>;   # gobble rest of message
    
close INEWS;
exit $?;

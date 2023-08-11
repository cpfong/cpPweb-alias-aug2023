#!/usr/bin/perl

$filename="./3-31.pl";
#$filename="./dir";

#die "file EXISTS\n" if -e $filename;
#print "file does not exist\n";

#die "file size is zero" if -z $filename;
#print "$filename size is NOT zero\n";

#print "$filename is a directory\n" if -d $filename;

#open CONFIG, "<3-3-reg-chap9.txt";
#warn "file expired\n" if -M CONFIG > 20;

#my @orig_files=qw /game.txt test.txt score.txt/;
#my @big_old_files;

#foreach my $f (@orig_files){
#	push @big_old_files, $f if -s $f > 20 and -A $f > 10;
#}

#print "@big_old_files\n";

print "$filename can be rw\n" if (-r $filename and -w _);
print "$filename can be rw\n" if (-r -w $filename); # not until version 5.10

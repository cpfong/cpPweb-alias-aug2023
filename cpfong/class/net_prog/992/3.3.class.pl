#!/usr/bin/perl

$_ = "He's out bowling with Barney tonight";
s/Barney/Fred/;
print;

print "\n";

s/with (\w+)/against $1's team/;
print;
print "\n";


$_ = "Chen is my best friend, and I will go out with Mr. Chen";
s/Chen/Chuang/g;
print;
print "\n";

$_="abc   def   g";
s/\s+/ /;
print "$_\n";

$_="abc   def   g";
s/\s+/ /g;
print "$_\n";


$_ = "	 abc";
s/^\s+//;
print "$_\n";

$_ = "	 abc bcd     ";
s/^\s+//; s/\s+$//;
print "$_\n";

$file_name = "/home/perl/s1506101/file.txt";
$file_name =~ s@^.*/@@;
print $file_name; print "\n";


$xxx = "Fred and Barney are good friends";
$xxx =~ s/(fred|barney)/\U$1/gi;
print $xxx, "\n";

$_ = "  this    is a test  ";
@a = split	;print "@a\n";
@b = split /\s+/;print "@b\n";


$_ = " this is a test";
print join '-', split;
print "\n";

my $text = "Fred dropped a 5 ton granite block on Mr. Slate";
my @word = ($text =~ /([a-z]+)/ig);
print "@word\n";


my $data = "Barney Rublle Fred Flintstone Wilma Flinstone";
my %last_name = ($data =~ /(\w+)\s+(\w+)/g);

while (($k, $v) = each %last_name){
	print $k, " -> ", $v, "\n";
}

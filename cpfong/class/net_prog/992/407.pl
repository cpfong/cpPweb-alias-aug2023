#!/usr/bin/perl

open(F, "<", "foo") or die "cannot open$!\n";
my @a= stat F;
print "@a\n";

my $perm = (stat F)[2];
print "permission = $perm\n";

print "after & 07777 will be ", ($perm & 07777), "\n";

my $oct = $perm & 07777;
my $x = sprintf "%o", $oct; 
print $x, "\n";

my $c1 =  20;
my $c2 = 020;

print "c1 = $c1 and c2 = $c2\n";
print "10 or 12 = ", (10|12), "\n";

my @glob = glob "*.pl";
my @diam = <*.pl>;

print "@glob\n";
print "@diam\n";

my @files = <FRED/*>; # glob operation
print "@files\n";

open FRED, "<", "FRED/file1";
while (<FRED>){
	print;
}

opendir DH, "FRED" or die "cannot open dir$!\n"; 
while ($_ = readdir DH){
       	 print ;
}


#!/usr/bin/perl

while (<>){
	chomp;
	my $avg=((split)[4]+(split)[5])/2;
	print $_, " $avg", "\n";
}

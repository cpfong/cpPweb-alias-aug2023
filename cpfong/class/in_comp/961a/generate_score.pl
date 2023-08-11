#!/usr/bin/perl

while (<>){
	chomp;
	@a = split /,/;
	print join " ", $a[0], $a[1], $a[2], "\n";
}

#!/usr/bin/perl

while (<>){
	chomp;
	@n=split /,/;
	$n[2] =~ s/(.*)\s+/$1/;
	print $n[0], " ", $n[1], " ", $n[2],"\n";
}
#01902506101陳詩旻 　五資五甲

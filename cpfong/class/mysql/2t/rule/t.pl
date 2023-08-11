#!/usr/bin/perl

@need=((0..2),5,(7..11));

while (<>){
	chomp;
	@f = split;
	foreach (@need){
		print @f[$_] ," ";
	}
	print "\n";
}

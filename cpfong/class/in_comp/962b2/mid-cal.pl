#!/usr/bin/perl

while (<>){
	chomp;
	($id, $sid, $n, @a) = (split /\s+/)[0..8];
	@t = @a;
	$sum = 0;
	print "$id $sid $n ";
	while (defined($tt = shift @t)){
		print "$tt ";
		$sum += $tt;
	}
	$ave = $sum / @a;
	print "$ave\n";
	
}
#29 962206235 ³¯«º¶® 70 85  0  0 10 20

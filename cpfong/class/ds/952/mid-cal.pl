#!/usr/bin/perl

while (<>){
	chomp;
	($id, $sid, $n, @a) = (split /\s+/)[0..7];
	@t = @a;
	$sum = 0;
	print "$id $sid $n ";
	while (defined(($t = shift @t))){
		print "$t ";
		$sum += $t;
	}
	$ave = $sum / @a;
	print "$ave\n";
	
}
#29 951136151 ³¯·q¿« 99 99 90 75 75

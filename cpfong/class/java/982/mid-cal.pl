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
#39 921506152 ³\¾_¬v 80 80 60  0  0

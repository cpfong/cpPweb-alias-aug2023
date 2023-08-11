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
#34 951206205 ªL·×²» 50  0 10 40  0 

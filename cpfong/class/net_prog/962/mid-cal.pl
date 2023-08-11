#!/usr/bin/perl

while (<>){
	chomp;
	($id, $sid, $n, @a) = (split /\s+/)[0..6];
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
#42 922506167 √π®K‚” 10 80  0 55

while (<>){
	@a=split;
	$avg = int(($a[3] + $a[4] + $a[5] + $a[6] + $a[7] + $a[8])/6);
	print "$a[0] $a[1] $a[2] $avg $a[3] $a[4] $a[5] $a[6] $a[7] $a[8]\n";
}
#id sid name h1 h2 m1 m2
#01 931506101 ³¯¼y«Û 70 70 10 0

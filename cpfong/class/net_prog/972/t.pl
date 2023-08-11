while (<>){
	@a=split;
	$avg = int(($a[3] + $a[4] + $a[5] + $a[6])/4);
	print "$a[0] $a[1] $a[2] $avg $a[3] $a[4] $a[5] $a[6]\n";
}

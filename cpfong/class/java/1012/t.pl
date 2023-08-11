while (<>){
	chomp;
	my ($a, $b, $c,$d,$e)=(split)[3,4,5,6,7];
	print $_, " ", (($a+$b+$c+$d+$e)/5), "\n";
}

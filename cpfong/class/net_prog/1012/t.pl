while (<>){
	chomp;
	my ($a, $b, $c)=(split)[3,4,5];
	print $_, " ", (($a+$b+$c)/3), "\n";
}

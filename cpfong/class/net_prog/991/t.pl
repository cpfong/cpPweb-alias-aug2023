while (<>){
	chomp;
	@a=split /\s+/;
	print $a[4], "\n";
}

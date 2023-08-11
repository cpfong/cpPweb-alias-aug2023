while (<>){
	chomp;
	@a=split;
	my $ave = ($a[3]+$a[4]+$a[5]+$a[6])/4;
	push @a, $ave;
	print join ',', @a;
	print "\n";
}
#01 981306101 曾喆雅 50 50 68 61

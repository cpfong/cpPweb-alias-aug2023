while (<>){
	chomp;
	my @a=split;
	my $r=join ',', @a;
	print "$r\n";
}

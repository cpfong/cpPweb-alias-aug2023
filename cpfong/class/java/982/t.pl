my $sum=0;
my $c=0;
while (<>){
	chomp;
	my $a=(split)[8];
	$sum += $a ;
	$c++;
}

print ($sum/$c);

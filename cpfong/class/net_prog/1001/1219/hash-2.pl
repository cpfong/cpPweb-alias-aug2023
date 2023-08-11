my @a;
my %h;

while (<>){
	chomp;
	@a=split;
	$h{$a[1]} = ($a[3] + $a[4] + $a[6]) / 3 ;
}

print $h{961506101}, "\n";

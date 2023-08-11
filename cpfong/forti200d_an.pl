my %s;
my %d;

while (<>){
	chomp;
	/src=(\d+\.\d+\.\d+\.\d+) /;
	$s{$1}++;
	/dst=(\d+\.\d+\.\d+\.\d+) /;
	$d{$1}++;
}

my @sorted;

#@sorted = sort { $s{$a} <=> $s{$b} } keys %s;
#print "source --- \n";
#foreach (@sorted){
#	print $_, "\t", $s{$_}, "\n";
#}

@sorted = sort { $d{$a} <=> $d{$b} } keys %d;
print "destination --- \n";
foreach (@sorted){
	print $_, "\t", $d{$_}, "\n";
}

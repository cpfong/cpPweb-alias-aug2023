my %h;
while (<>){
	chomp;
	my $id = (split)[1];
	my $d;
	$id =~ /\d+(\d$)/;
	if ($1 <= 1){
		$d = '2' . $1;
	}
	else {
		$d = '1' . $1;
	}
	$h{$id}= '03' . $d;
}

while ( my ($k,$v) = each %h ) {
	print $k, "\t", $v, "\n";
}

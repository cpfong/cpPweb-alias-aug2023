#!/usr/bin/perl

my %nn; # number-name  hash
my %ns; # number-score hash

while (<>){
	chomp;
	my $sum=0;
	($u1,$no,$n,@s)=split;
	$nn{$no}=$n;
	foreach (@s){
		$sum += $_;
	}
	my $ave= sprintf "%.1f", $sum / @s;
	$ns{$no}=$ave;
}

my @winners = sort { $ns{$b} <=> $ns{$a} } keys %ns;

foreach (@winners){
	print "$_ $nn{$_} $ns{$_}\n";
}


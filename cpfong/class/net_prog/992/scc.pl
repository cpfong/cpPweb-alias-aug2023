#!/usr/bin/perl

my %h; 

while (<>){
	chomp;
	my $t = sprintf "%.1f", ((split)[1]+(split)[2]+(split)[3])/3;
	$h{(split)[0]} = $t;
}

my @winners=sort { $h{$b} <=> $h{$a}; } keys %h;
foreach (@winners){
	print "$_:$h{$_} \n"; 
}

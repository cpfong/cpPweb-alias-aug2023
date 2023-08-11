#!/usr/bin/perl

sub max{
	my($max_so_far) = shift @_;

	foreach (@_){
		if ($_ > $max_so_far){
			$max_so_far=$_;
		}
	}
	$max_so_far;
}

$max = max 2,5,8,1,4,99,4;
print $max;


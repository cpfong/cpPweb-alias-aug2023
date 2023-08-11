#!/usr/bin/perl

sub list_from_fred_to_barney{
#	my ($fred, $barney)=@_;

	if ($fred < $barney){
		$fred..$barney
	}
	else {
		reverse $barney..$fred
	}
} 
$fred=9;
$barney=6;

@c = list_from_fred_to_barney;
print @c

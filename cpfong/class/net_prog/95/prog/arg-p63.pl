#!/usr/bin/perl

sub max {
	if ($_[0] > $_[1]){
		$_[0];
	}
	else {
		$_[1];
	}
}

$c = max(1,2); 
print $c;

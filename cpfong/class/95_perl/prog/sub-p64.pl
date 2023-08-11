#!/usr/bin/perl
sub max {
	my($m, $n)=@_;
	if ($m > $n) { $m } else { $n }
}

$c = max 3,7,9;
print $c

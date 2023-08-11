#!/usr/bin/perl
my %fc;

@c = map {10 * $_} -10 .. 10;

foreach (@c) {
	$f = 1.8 * $_ + 32;
	print $_ . "\t" . $f . "\n";
}

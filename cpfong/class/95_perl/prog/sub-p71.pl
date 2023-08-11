#!/usr/bin/perl

sub print {
	$a + $b;
}

$a = $b = 1;
$c = &print; 
print $c;

#!/usr/bin/perl

chomp($in = <STDIN>);

my @abc = qw /a b c/;

if ($in eq 'r') {
	foreach (@abc){
		print "$_ has read \n" if -r;
	}
}

if ($in eq 'w') {
	foreach (@abc){
		print "$_ has write\n" if -w;
	}
}

if ($in eq 'x') {
	foreach (@abc){
		print "$_ has execute\n" if -x;
		print if -x;
	}
}

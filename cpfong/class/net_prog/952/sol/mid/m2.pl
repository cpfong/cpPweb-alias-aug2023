#!/usr/bin/perl

print "input rwx\n";
chomp($in=<STDIN>);

my @abc=qw/a b c/;

if ($in eq 'r') { foreach (@abc) {print "$_ has read right\n" if -r;} }
if ($in eq 'w') { foreach (@abc) {print "$_ has writ right\n" if -w;} }
if ($in eq 'x') { foreach (@abc) {print "$_ has exec right\n" if -x;} }

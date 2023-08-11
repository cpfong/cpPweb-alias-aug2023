#!/usr/bin/perl

$target = shift @ARGV;

while (<>){
	chomp;
	($u, @useless) = split;
	if ($u =~ /^$target$/){
		print "$target 在線上\n";
		$hit = 1;
		last;
	}
}

print "目標 $target 不在線上\n" unless $hit;

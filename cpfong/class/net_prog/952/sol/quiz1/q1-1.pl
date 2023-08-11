#!/usr/bin/perl

print "輸入要查的帳號: "; chomp($in = <STDIN>);

open WHO, "<x"; 
$e = 0;

while (<WHO>){
	chomp;
	@n = split;
	if ($n[0] =~ /^$in$/){
		$e = 1;
		print "$in on line\n";
		last;
	}
}

print "$in 不在線上\n" if ($e == 0);

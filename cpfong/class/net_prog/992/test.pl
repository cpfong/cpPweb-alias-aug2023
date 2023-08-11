#!/usr/bin/perl

$_ = "barney\nfred xxx";

if (	m/
		barney
		.*
		fred
		/six){
	print "fred after barney\n";
}

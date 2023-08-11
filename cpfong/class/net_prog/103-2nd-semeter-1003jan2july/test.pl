#!/usr/bin/perl

$_ = "10";

if (/^-?\d+/){
  	print "number \n";
}


$_ = "barney \n fred";

if (m{ 
		barney
		.*
		fred
	}six
   )
{
  	print "fred is after barney\n";
}


my $xx = "Hello there, neighbor";
if ($xx =~ /\s(\w+),/){
	print $1, "\n";
	print $', "\n";
	print $`, "\n";
}

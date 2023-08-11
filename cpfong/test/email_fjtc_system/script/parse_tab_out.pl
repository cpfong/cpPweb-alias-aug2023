#!/usr/bin/perl
$filename  = '../txt/depid.txt.2' ;
open(file,$filename) ;
while( $name=<file> ) {
	chop $name ;
	@n = split /|/,$name ;

	$par1	= $n[0];
	$par2	= $n[1];
	$par3	= $n[2];

	print $par1,$par2,$par3,"\n";
}
print "\n" ;
close(file) ;

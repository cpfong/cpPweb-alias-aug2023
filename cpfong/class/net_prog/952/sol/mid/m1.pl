#!/usr/bin/perl

$tar = shift;
$hit = 0;
while (<>){
	chomp;
	if (/^$tar\b/){
		$hit=1;
		last;
	}
}
if ($hit) {
	print $tar . "\n";
}
else {
	print "¤£¦s¦b\n";
}
 

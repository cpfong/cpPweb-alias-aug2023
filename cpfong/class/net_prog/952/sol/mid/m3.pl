#!/usr/bin/perl

print "input src\n"; chomp($src=<STDIN>);
print "input dst\n"; chomp($dst=<STDIN>);

$r = index($src, $dst);
if ($r == -1){
	print "does not exists\n";
}
else {
	print $dst . " at ". $r . "\n";
}

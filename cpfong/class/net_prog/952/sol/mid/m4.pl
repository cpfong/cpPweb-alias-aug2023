#!/usr/bin/perl

print "input src\n"; chomp($src=<STDIN>);
print "input dst\n"; chomp($dst=<STDIN>);

if ($src =~ /$dst/){
	print "exist\n"
}
else {
	print "does not exist\n";
}

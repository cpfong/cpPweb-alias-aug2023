#!/usr/bin/perl

@a = 1..3;
$b = @a;

print $b;

foreach ( 1..@a){
	print; 
}

@xx = qw /I am a teacher/;

for (0..@xx-1){
	print $xx[$_];
}


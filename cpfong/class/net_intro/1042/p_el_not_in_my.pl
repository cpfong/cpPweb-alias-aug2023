#!/usr/bin/perl

open E, "<from_el_clean.txt";
open M, "<from_my_clean.txt";

my %m, %e;

while (<M>){
	chomp;
	my ($id,$name)=split ',';
	$m{$id}++;
}

while (<E>){
	chomp;
	my ($id,$name)=split ',';
	print "$id\n" unless exists($m{$id});
}

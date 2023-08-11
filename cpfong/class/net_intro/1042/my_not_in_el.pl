#!/usr/bin/perl

open E, "<from_el_clean.txt";
open M, "<from_my_clean.txt";

my %m, %e;

while (<E>){
	chomp;
	my ($id,$name)=split ',';
	$e{$id}++;
}

while (<M>){
	chomp;
	my ($id,$name)=split ',';
	print "$id\n" unless exists($e{$id});
}

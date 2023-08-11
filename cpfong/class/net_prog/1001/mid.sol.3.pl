#!/usr/bin/perl

foreach (1..50){
  my $ra = rand();
  $ra *= 101 + 100; # 0-100
  $ra = int($ra);
  if ($ra % 5 == 0){
		print $ra, "\n";
  }
}

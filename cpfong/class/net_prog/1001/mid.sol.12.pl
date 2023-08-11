#!/usr/bin/perl
foreach $i (1..5){
  foreach (1..6-$i){ # control times
	print (6-$i);
  }
  print "\n"; 
} 

print "--\n";

my $i=1;
while ($i < 6){
  foreach (1..$i){
	print $i;
  }
  print "\n"; 
  $i++;
}


$i=1;
while ($i < 6){
  $j=1;
  while ($j <= $i){
		print $i;
		$j++;	
  }
  print "\n"; 
  $i++;
}

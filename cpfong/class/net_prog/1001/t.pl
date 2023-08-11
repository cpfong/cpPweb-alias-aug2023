while (<>){
  chomp;
  s/\s+/,/g;
  print "$_\n";
}

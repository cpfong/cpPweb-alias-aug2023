my @a=();
$c=1;

foreach (@ARGV){
  $sum += $_;
  if ($_ % 2){
		push @a, $c;
  }
  $c++;
}

print "total = $sum\n";
print "odd = @a\n";

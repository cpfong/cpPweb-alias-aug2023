@a=(1,8,15,24,33,45,76,88,99);
$key=88;

$upper=8; $low=0;
while ($upper > $low){
	$mid=int(($low+$upper)/2);
	if ($key == $a[$mid]){
		print "bingo, the $key is at index $mid\n";
		last;
	}
	elsif ($key > $a[$mid]) { $low=$mid+1; }
	else { $upper=$mid-1; }
}

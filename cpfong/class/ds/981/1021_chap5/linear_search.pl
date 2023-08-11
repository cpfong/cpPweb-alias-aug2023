$index=0;
@a=(60,20,50,10,30,40);
$tar=50;

foreach (@a){
	if ($_ == $tar){
		print "bingo, and index is $index\n";
		last;
	}
	$index++;
}

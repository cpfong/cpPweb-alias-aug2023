@a=(a..z);
foreach (0..100){
	for (0..6){print $a[int(rand()*26)]; }
	print ",", int(rand()*40+20), "\n";
}

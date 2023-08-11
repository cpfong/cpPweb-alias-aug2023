$i=0;
while (<>){
	chomp;
	($u1, $acc, @a) = split;
	$acc =~ s/^90/m/;
	$acc =~ s/^91/n/;
	$acc =~ s/^92/o/;
	print "<br>" unless (++$i % 5);
	print "<a href=http://vnc.mis.fotech.edu.tw/~$acc/423-mid.html>$acc</a> -- ";
}

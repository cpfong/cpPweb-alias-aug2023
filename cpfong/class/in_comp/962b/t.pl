while (<>){
	next if /sid/;
	chomp;
	($id, $sid, $name, $home, $note[0], $quiz[0..2],$note[1..3],$quiz[3..4]) = split;

	print "@note ";
	$sum = 0; foreach (@quiz){ $sum += $_; }$qa = $sum / @quiz;
	$sum = 0; foreach (@note){ $sum += $_; }$na = $sum / @note;

	$qa = sprintf "%.2f", $qa;
	$na = sprintf "%.2f", $na;

	$ave = sprintf "%.2f", $qa * 0.6 + $na * 0.4;
	print "$id $sid $name $home $qa $na $ave\n";
}
#id sid       name    ho n0  q0  q1  q2m n1 n2 n3 q3 q4
#01 962206202 ¦À¬î»T  51 85  15  30  35  90 99 85 15 16

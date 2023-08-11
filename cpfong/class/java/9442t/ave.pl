#!/usr/bin/perl

while (<>){
        chomp;
        ($pre,$u,$score) = unpack ("a28 a1 a*", $_);
	($ak,$cd,$q1,$q2,$m,$q3,$q4,$h1,$fi) = split /\s+/, $score;

        print "$pre ";
	printf "%2d %2d %2d %2d %2d %2d %2d %2d %2d\n", $ak,$cd,$h1,$q1,$q2,$m,$q3,$q4,$fi;

	#debug
	#printf "%2d %2d %2d %2d %2d %2d %2d %2d\n", $ak,$cd,$q1,$q2,$m,$q3,$q4,$fi;
	#printf "%2.2f\n", $cd; 
}
#dx sid       name   class    ak cd q1 q2  m q3 q4 final
#01 931436103 陳宗亨 四資二甲 99 99 90 80 99 70
#123456789012345678901234567890123456789012345678901234567890123435

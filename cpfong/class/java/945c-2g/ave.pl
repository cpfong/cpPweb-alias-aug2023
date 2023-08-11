#!/usr/bin/perl

while (<>){
        chomp;
        ($pre,$u,$score) = unpack ("a28 a1 a*", $_);
	($cd,$q1,$q2,$ak,$h1,$m,$q3,$q4,$ak2,$h2,$fi) = split /\s+/, $score;

        print "$pre ";
	printf "%2d %2d %2d %2d %2d %2d %2d %2d %2d %2d %2d\n", $cd,$h1,$h2,$ak,$ak2,$q1,$q2,$q3,$q4,$m,$fi; 

	#debug
	#printf "%2d %2d %2d %2d %2d %2d %2d %2d %2d %2d %2d\n", $cd,$q1,$q2,$ak,$h1,$m,$q3,$q4,$ak2,$h2,$fi;
	#printf "%2.2f\n", $cd; 
}
#dx sid       name   class    cd q1 q2 ak h1  m q3 q4 ak h2 final
#01 931506101 陳慶彥 五資二甲 99 30 20 50 54  0  0  0 50
#123456789012345678901234567890123456789012345678901234567890123435

my $a2f = "a b c d e f"; 
my $g2l = "g h i j k l";
my $m2r = "m n o p q r";

my $in = <>;
chomp($in);

my $res = 
		($in =~ /$a2f/) ? '一' : 
		($in =~ /$g2l/) ? '二' : 
		($in =~ /$m2r/) ? '三' : 
		'四';

#!/usr/bin/perl

#print index("hello world", 'o', 5);

#chomp($in = <>);
#chomp($ta = <>);
#print "$ta is in the " , index($in, $ta), "  position of "  , $in;

my $mineral = substr("Fred J. Flintstone",8 , 5); print $mineral, "\n";
my $rock    = substr("Fred J. Flintstone",13, 1000); print $rock, "\n";
my $rock    = substr("Fred J. Flintstone",13); print $rock, "\n";

my $s = "Fred J. Flintstone";
my $xx = substr($s, 8, 5)		; print $xx, "\n";
$xx = substr($s, index($s, "Flint"), 5)	; print $xx, "\n"; 

my $long = "some very very long string";
my $right= substr($long, index($long, "l")); print $right, "\n";

my $timestamp = (stat("55.pl"))[8];
my @a = localtime $timestamp;
my $date_tag = sprintf "%4d/%02d/%02d %2d:%02d:%02d", $a[5]+1900,$a[4]+1,$a[3],$a[2],$a[1],$a[0];
print $date_tag, "\n";

my $xx = &big_money(12345678.9);
print $xx, "\n";

sub big_money{
	my $number = sprintf "%.2f", shift @_;
	1 while $number =~ s/^(-?\d+)(\d\d\d)/$1,$2/;
	$number =~ s/^(-?)/$1\$/; # 負號後數字前加入貨幣符號
	$number;
}


my @r = sort {$a <=> $b;} (9, 3, 25,0,10);
print "@r\n";

my @r = sort {$b <=> $a;} (9, 3, 25,0,10);
print "@r\n";


my %score = ("barney" => 195, "fred" => 205, "aaa" => 102, "bbb" => 300, "ccc" => 22);
my @winner= sort {$score{$b} <=> $score{$a}} keys %score;

foreach (@winner){
	print "$_:$score{$_}";
}

print "\n";

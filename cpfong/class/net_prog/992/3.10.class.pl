#!/usr/bin/perl

# greddy
$_ = "/usr/home/s1506101/hw1.doc";
print; print "\n";

s%.+/%%;
print; print "\n";

# NOT greddy
$_ = "/usr/home/s1506101/hw1.doc";
s%.+?/%%;
print; print "\n";

print "input month: "; chomp($m=<STDIN>);
if ($m == 2){
}
else {
	print "at least 30 days in this month\n";
}


unless ($m == 2){
	print "at least 30 days in this month\n";
}

print "sunny today? (y/n)"; chomp(my $s=<STDIN>);
unless ($s eq "y"){
	print "I will bring an unbrella\n";
}

$c=$sum=0;
while ($c <= 10){
	$sum += $c;
	$c++;
}
print "total = $sum\n";

$c=$sum=0;
until ($c > 10){
	$sum += $c;
	$c++;
}
print "total = $sum\n";

print "sunny today? (y/n)"; chomp($s=<STDIN>);
print "i will bring umbrella\n" if ($s eq "n");


{
	my $n=1;
	print "n = $n\n";
}
print "n = $n\n";


my @people=qw{ fred barney fred wilma };
my %count;
$count{$_}++ foreach @people;
print "$k $v\n" while (($k,$v)= each %count);


foreach (1..10){
	last if ($_ == 8);
	print "$_\n";
}


while(<>){
	foreach (split){
		next if /\W/;
		$valid++;
		$count{$_}++;
	}
}

print "total = $valid\n";
foreach $w (sort keys %count){
	print "$w show up $count{$w} times\n";
}

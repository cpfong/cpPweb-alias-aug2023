#!/usr/bin/perl

print "開始值為: "; chomp($start=<STDIN>);
print "結束值為: "; chomp($end=<STDIN>);

sub level{
	my $tot=1; 
	my ($s, $e)=@_;my $now=$s;
	
	while ($now <= $e){
		$tot *= $now;
		$now++;
	}
	$tot;
}

$res = level $start,$end;
print " $start to $end 結果為 $res \n";

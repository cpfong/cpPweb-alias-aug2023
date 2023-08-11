#!/usr/bin/perl

#@who_lines = `who`;
#$foreach (@who_lines)

foreach (`who`){
	my ($user, $tty, $date) = /(\S+)\s+(\S+)\s+(.*)/;
	$ttys{$user} .= "$tty at $date\n"; 
}

while (my ($k, $v) = each %ttys){
	print "$k --> $v\n";
}


open DATE, "date|" or die "cannot open date pipe $!";
while (<DATE>){
	print;
}

open W, "who|";
while (<W>){
	print;
}

#open M, "| mail -s test111 cp" or die "cannot open mail pipe$!";
#my @now=`now`; print M "now is @now";

my @odd_numbers = grep { $_ % 2 } 1..10;
print "@odd_numbers\n";


my @data = (4.75, 1.5, 2, 1234, 6.9456, 12345678.9, 29.95);
my @formatted_data;

#foreach (@data){
#	push @formatted_data, &big_money($_);  
#}
@formatted_data = map { &big_money($_) } @data;

print "@formatted_data\n";


sub big_money{
        my $number = sprintf "%.2f", shift @_;
        1 while $number =~ s/^(-?\d+)(\d\d\d)/$1,$2/;
        $number =~ s/^(-?)/$1\$/; # 負號後數字前加入貨幣符號
        $number;
}


$_ = "1 2 3";
#my @a = split;
#print $a[2];

my @b=(split)[0,2];
print "@b\n";

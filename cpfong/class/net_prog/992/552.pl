#!/usr/bin/perl

my $s = system "date";
print $s, "\n";

my $s = system "ls $HOME"; print "\n"; # error becasue it "explain" $HOME
my $s = system 'ls $HOME'; print "\n"; # ok
my $s = system "ls \$HOME";print "\n"; # ok too

my $now=`date`;
print "$now\n";

my @functions = qw/ int rand sleep length hex eof exit sqrt umask /;
my %abount;

foreach (@functions){
	$about{$_} = `perldoc -t -f $_`;
}

foreach (keys %about){
	print "$_ $about{$_}\n";
}

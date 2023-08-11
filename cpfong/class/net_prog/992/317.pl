#!/usr/bin/perl

# last p163
#while (<STDIN>){
#	if (/__END__/){
#		last;
#	} elsif(/fred/){
#		print;
#	}
#}

# next p164
#while (<>){
#	foreach (split){
#		$total++;
#		next if /\W/;
#		$valid++;
#		$count{$_}++;	
#	}
#}

#print "total words $total\n";
#print "valid words $valid\n";

#while (($k, $v) = each %count){
#	print "$k : $v\n";
#}

# redo p165
#my @words = qw / fred barney pebbles dino wilma betty /;
#my $errors=0;

#foreach (@words){
#	print "pls input '$_': ";
#	chomp (my $try=<>);
#	if ($try ne $_){
#		print "sorry, wrong typing \n\n";
#		$errors++;
#		redo;
#	}
#} 
#print "end of testing , you make $errors typing err\n";

# p167
#print "input a number: ";
#chomp($width=<>);	

#my $size=
#	($width < 10) ? " 小" :
#	($width < 20) ? " 中" :
#	($width < 50) ? " 大" :
#	" 超大"; #default

#print "size = $size\n";

#%dessert = ('ice cream' => 1, 'cake' => 'abc');
#if ($dessert{'cake'} && $dessert{'ice cream'}){
#	print "very good\n";
#}
#elsif ($dessert{'cake'} || $dessert{'ice cream'}){
#	print "it is ok\n";
#}
#else{
#	print "I am sad\n";
#}

#my $last_name = $last_name{$someone} || '(No last name)';

#open F, "<xxx.dat" or die "cannot open $!";

#ex 1

my $tar=int(1+rand 30); 
while (chomp(my $in=<>)){
	last if ($in == $tar || $in eq "quit" || $in eq "exit" || $in=~/^\s+$/);
	my $r = ($in < $tar) ? "Too low" : "Too hig";
	print $r, "\n";
}

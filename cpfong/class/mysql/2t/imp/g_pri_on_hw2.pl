#!/usr/local/bin/perl

#### global variable ####
$db  = 'ttb_hw1';
@pri = qw / Select Insert Update Delete Create Drop Index Alter /;

while (<>){
	chomp;
	push @acc, $_;
}

print "create database if not exists $db;\n";
print  "use $db;\n";

foreach my $a (@acc){
	my $lp;
	foreach my $p (@pri){
		$lp .= "$p,";		
	}
	# get rid of the last ,
	$lp = substr($lp,0,-1);
	print "grant $lp on $db.$a to $a\@localhost;\n";
}

print "flush privileges\n";

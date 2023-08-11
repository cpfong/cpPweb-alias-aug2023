#!/usr/bin/perl

# obj: create ZONE.fotech.signed  for dnssec

my $zone = 'xyz.fotech.edu.tw';
my $db   = '/etc/namedb/master/db.xyz.fotech';
my @pair = qw /key private/;
my $zsk  = 'zsk';
my $ksk  = 'ksk';
my %kfile;

die "cannot find db file" unless (-e $db);

gen_key($zsk);
gen_key($ksk);

print "cat *.key >> $db\n";# insert key into db
print "dnssec-signzone -o $zone -k $kfile{$ksk} $db $kfile{$zsk}\n";
# end main

# rename  key and private according zsk, ksk
sub create_pair{
	my $key = shift @_;
	my @p =  qw /key private/;
	my ($f, $base, $act);

	chomp($f = `ls K$zone*.key`);
	$f =~ /(\+\d+\+\d+)\.key/;
	$base = 'K' . $zone . '.' . $1;

	#rename it
	foreach my $p (@pair){
		$act = "mv $base.$p $base.$key.$p\n";
		system $act;
		#save filename
		if ($p eq 'key'){
			$kfile{$key} = $base . '.' . $key . '.' . $p;
		}
	}
}

sub gen_key{
	my $k = shift @_;

	my $cmd = ($k eq $zsk) ? 
	"dnssec-keygen        -a RSASHA1 -b 1024 -n ZONE $zone" :
	"dnssec-keygen -f KSK -a RSASHA1 -b 2048 -n ZONE $zone"	;
	system $cmd;
	&create_pair($k);
}

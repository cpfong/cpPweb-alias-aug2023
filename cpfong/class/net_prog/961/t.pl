%h = qw /www.hinet.net 61.219.38.89
        vnc.mis.fotech.edu.tw 163.15.205.213
        www.yahoo.com.tw 202.43.195.13/;

print "input \n";
chomp ($in = <STDIN>);
if (exists $h{$in}){
        print "exists " . $h{$in} . "\n";
}
else {
        print "not exists\n";
}

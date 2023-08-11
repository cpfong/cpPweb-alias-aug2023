#!/usr/bin/perl

%do = qw !	center.fjtc.edu.tw	163.15.196.1
		dns.fjtc.edu.tw		163.15.196.2
		ftp.fjtc.edu.tw		163.15.196.3
		cpfong.fjtc.edu.tw	163.15.196.110 !;

%ip = reverse %do;

print "輸入主機名: "; chomp($domain=<STDIN>) ;
print "輸入ip位址: "; chomp($ipaddr=<STDIN>) ;

print "主機為 $domain 其位址為 $do{$domain} \n";
print "ip  為 $ipaddr 其主機為 $ip{$ipaddr} \n";


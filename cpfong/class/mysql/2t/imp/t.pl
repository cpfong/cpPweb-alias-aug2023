#!/usr/bin/perl

print "use tta_quiz;\n";
print "drop table if exists cpfong_1;\n";
print "drop table if exists cpfong_2;\n";

print "create table cpfong_1(nu tinyint, i char(9) primary key not null, na char(6));\n";
print "create table cpfong_2(i char(9) references test_cpfong1(i), s1 tinyint, m tinyint, s2 tinyint, s3 tinyint, s4 tinyint);\n";

while (<>){
	chomp;
	($num,$id,$name,$s1,$m,$s2,$s3,$s4)=split;
	print "insert into cpfong_1 values($num,'$id','$name');\n";
	print "insert into cpfong_2 values('$id',$s1,$m,$s2,$s3,$s4);\n";
}
#01	932136101	ªL©s¼z	77	21	78	99	65

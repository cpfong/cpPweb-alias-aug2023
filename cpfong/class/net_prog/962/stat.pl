#!/usr/bin/perl

$filename = "t.t";

my ($dev, $ino, $mode, $nlink, $uid, $gid, $rdev,
$size, $atime, $mtime, $ctime, $blksize, $blocks) = stat($filename);

warn "everyone can wirte\n" if $mode & 0002;
my $classical_mode = 0777 & $mode;
my $ss = sprintf "%lo", $classical_mode;
print $ss;

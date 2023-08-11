#!/bin/sh

while read line; do
 set -- $line
 id=$1
 ip=$2

 printf "%s\n" "scp -P 22 cpfong@$id:~/foo ."
 printf "%s\n" "cat foo >> res"
done

#!/bin/sh

act(){
 gr=$1
 p=$2 

 set -- $gr
 for i; do 
   g=1$p$i
   ip="$(cat /home/cpfong/.ssh/config | grep $g -A1 | tail -n1 | cut -d' ' -f2)"

   printf "%s\n" "mosh --ssh=\"ssh -p $p$i\" cpfong@$ip"
 done
}

# main
gr=`seq -w 1 20` && p=81 && act "$gr" $p
gr=`seq -w 1 21` && p=82 && act "$gr" $p

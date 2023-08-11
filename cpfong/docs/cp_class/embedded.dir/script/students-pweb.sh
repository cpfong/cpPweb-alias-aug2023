#!/bin/sh

act(){
 gr=$1
 p=$2 

 set -- $gr

 for i; do 
   g=1$p$i
   ip="$(cat /home/cpfong/.ssh/config | grep $g -A1 | tail -n1 | cut -d' ' -f2)"
   u1="$(cat /home/cpfong/.ssh/config | grep $g -A4 | tail -n1 | cut -c 2-12 | cut -d' ' -f1)"
   u2="$(cat /home/cpfong/.ssh/config | grep $g -A4 | tail -n1 | cut -c 2-12 | cut -d' ' -f2)"

   n1="$(cat /home/cpfong/.ssh/config | grep $g -A5 | tail -n1 | cut -c 2-12 | cut -d' ' -f1)"
   n2="$(cat /home/cpfong/.ssh/config | grep $g -A5 | tail -n1 | cut -c 2-12 | cut -d' ' -f2)"

   printf "<a href=http://%s/>$g</a> --" "$ip"
   printf "<a href=http://%s/~%s>%s</a> --" "$ip" "$u1" "$n1"
   printf "<a href=http://%s/~%s>%s</a> <br>\n" "$ip" "$u2" "$n2"
 done
}

# main
gr=`seq -w 1 20` && p=81 && act "$gr" $p
gr=`seq -w 1 21` && p=82 && act "$gr" $p

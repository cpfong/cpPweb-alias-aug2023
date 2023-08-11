#!/bin/sh

prompt(){
 # group_id
 i=$1

 printf "%s\n" "expect -exact 'cpfong@$i~ % '"
 return 1
}

login(){
 i=$1
 echo "spawn ssh $i"
}

logout(){
 printf "%s\n" "send -- \"logout\""
}

act(){
 u=$1
 v=$2

 printf "%s\n" "send -- \"ls ~$u/.tmux.conf >>foo; ls ~$v/.tmux.conf  >>foo \r\""
} #end act

# main

while read line; do

 set -- $line
 gid=$1
 u1=$4
 u2=$5

 login ${gid}

 prompt ${gid}
 act $u1 $u2

 prompt ${gid}
 logout

done
# 1    2             3  4     5
#18101 47.98.108.145 22 s3121 s3140

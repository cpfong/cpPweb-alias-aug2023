#!/bin/sh

src='./BigFile'
dst='myfile'
buck='ifong'
sMD5=$(openssl md5 -binary $src | base64)
size='30M'
fp='fileparts'

str=$(aws s3api create-multipart-upload --bucket $buck --key $dst --metadata md5=$sMD5)
set -- $str
upID=$3

split -d -b $size $src #x00 x01 x02 ...
r=$(ls x??)
set -- $r

i=1
for f ; do
  cksum=$(openssl md5 -binary $f | base64)
  eTag=$(aws s3api upload-part --bucket $buck --key $dst --part-number $i --body $f --upload-id  $upID --content-md5 $cksum)
  tar=$i$i$i$i$i # note: fake fileparts file has to be do it before hand
  tar='"'$tar'"'

  cat $fp | sed "s/$tar/$eTag/" > x
  mv x $fp
  i=$((i+1))
done

aws s3api complete-multipart-upload --multipart-upload file://$fp --bucket $buck --key $dst --upload-id $upID

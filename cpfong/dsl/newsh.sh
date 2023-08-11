#!/bin/sh

range="1 2 3 4 5 6"
HEAD="http://cle.linux.org.tw/fonts/FireFly/bitmaps/bdf/fireflyR1"
TAIL=".bdf"

for i in $range
do
file=$HEAD$i$TAIL
wget $file
done

for file in ./*.bdf
do
_nfile="$(echo ${file} | tr '.bdf' '.pcf')"
cat $file | bdftopcf -t > $_nfile
gzip $_nfile
done

mv *.gz /usr/X11R6/lib/X11/fonts/misc/
cd /usr/X11R6/lib/X11/fonts/misc/
mkfontdir .
xset fp rehash

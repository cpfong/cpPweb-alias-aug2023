#!/bin/sh

wget http://myweb.ncku.edu.tw/~n9897112/os/fireflyR11to16.pcf.tgz
tar xfvz fireflyR11to16.pcf.tgz
mv *.gz /usr/X11R6/lib/X11/fonts/misc/
cd /usr/X11R6/lib/X11/fonts/misc/
mkfontdir .
xset fp rehash

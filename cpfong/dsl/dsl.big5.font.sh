#!/bin/sh
# note: you have to be ROOT 
# either from ibiblio or cle
#
#wget http://www.ibiblio.org/pub/packages/ccic/software/fonts/big5/bdf/uwb5-16m.bdf.gz
#gzip -cd uwb5-16m.bdf.gz | bdftopcf -t >  uwb5-16m.pcf
#gzip uwb5-16m.pcf 
#mv uwb5-16m.pcf.gz /usr/X11R6/lib/X11/fonts/misc/
#
#wget http://cle.linux.org.tw/fonts/twmoefont/bdf/normal/ming16.bdf.gz
wget http://ftp.kh.edu.tw/Linux/CLE/fonts/twmoefont/bdf/normal/ming16.bdf.gz
gzip -cd  ming16.bdf.gz | bdftopcf -t >  ming16.pcf
gzip ming16.pcf
mv ming16.pcf.gz /usr/X11R6/lib/X11/fonts/misc/

cd /usr/X11R6/lib/X11/fonts/misc/
mkfontdir .
xset fp rehash

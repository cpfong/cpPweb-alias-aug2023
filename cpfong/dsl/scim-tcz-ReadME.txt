1. install a clean tinycore usb system
2. basic tcz installed (Xvesa Xprogs flwm ...)
3. xterm

CFLAGS="-march=i486 -mtune=i686 -Os -pipe"
CXXFLAGS="-march=i486 -mtune=i686 -Os -pipe"
LDFLAGS="-Wl,-O1"

fetch http://www.scim-im.org/  scim-1.4.11.tar.gz
NOTE: version 4.12 4.13 does NOT compile!

for testing....
---
tar xfvz scim-1.4.11.tar.gz
mv scim-1.4.11 scim-1.4.11.src
cd scim-1.4.11.src

tce-load -wi compiletc perl5 intltool
./configure --prefix=/usr/local

NOTE!! prefix is not absolute path of SERVER/usr/local
but related installing (next few lines) make DESTDIR=/tmp/scim
ie absolute path --> /tmp/scim/usr/local

make -j3
---
#touch /tmp/mark (no need!)

mkdir /home/tc/scim-1.4.11
make DESTDIR=/home/tc/scim-1.4.11 install
cd /home/tc/scim-1.4.11/usr/local/bin to TEST

@urxvt
/home/tc/scim-1.4.11/usr/local/bin/scim --> bring scim-panel UP

tc@box:~/scim-1.4.11/usr/local/bin$ ps aux |grep scim
 2741 tc       /usr/lib/scim-1.0/scim-launcher -d -c simple -e all -f socket --no-stay
 2745 tc       /usr/lib/scim-1.0/scim-helper-manager
 2746 tc       /usr/lib/scim-1.0/scim-panel-gtk --display :0.0 -c socket -d --no-stay

scim-1.4.9
tc@box:/mnt/sdb1/tmp/TCscim$ ls /usr/lib/scim-1.0/
1.4.0/                scim-helper-manager   scim-panel-gtk
scim-helper-launcher  scim-launcher


-- end of testing

real
---
make DESTDIR=/tmp/scim install
cd /tmp
tce-load -wi squashfs-tools-4.x
mksquashfs scim scim-1.4.11.tcz

tc@box:/tmp$ cd /tmp/scim
tc@box:/tmp/scim$ find usr -not -type d > scim-1.4.11.tcz.list
tc@box:/tmp/scim$ rm -fr usr

cp scim-1.4.11.tcz.list /mnt/sdb1/tce/optional
cp scim-1.4.11.tcz /mnt/sdb1/tce/optional
now app can load scim

tables 
----
fetch http://www.scim-im.org/  scim-tables-0.5.10.tar.gz
tar xfvz
cd scimxxxxx
./configure --prefix=/usr/local
make -j3
make DESTDIR=/tmp/scim-tables install
cd /tmp
mksquashfs scim-tables scim-tables-0.5.10.tcz
cd /tmp/scim-tables
find usr -not -type d > scim-tables-0.5.10.tcz.list
rm -fr usr

--
make a working version: urxvt-scim-chewing
new-version-scim + suzuke-chewing 
suzuke-scim + new-version-changjei

urxvt FAQ
--
http://pod.tst.eu/http://cvs.schmorp.de/rxvt-unicode/doc/rxvt.7.pod#Isn_t_rxvt_unicode_supposed_to_be_sm

# set a new font set
printf '\33]50;%s\007' 9x15,xft:Kochi" Mincho"

# change the locale and tell rxvt-unicode about it
export LC_CTYPE=ja_JP.EUC-JP; printf "\33]701;$LC_CTYPE\007"

# set window title
printf '\33]2;%s\007' "new window title"

----
Q: after done with chewing, add cangjei in
A:
1. install scim-tables-0.5.10.tcz (how to create this tcz? look up)
apps --> load locally --> load scim-tables-0.5.10

2. 
0.5.10  --> /usr/local/lib /usr/local/share
chewing --> /usr/lib /usr/share

tc@box:~$ ls /tmp/tcloop/ | grep scim
tc@box:~$ ls /usr/local/share/chewing/
tc@box:~$ ls /usr/lib/scim-1.0/1.4.0/IMEngine
tc@box:~$ ls /usr/share/scim/

tc@box:~$ scim-setup 
only Chewing now

--
@FreeBSD
[cpfong@mail ~] ls /usr/local/lib/scim-1.0/1.4.0/IMEngine
[cpfong@mail ~] ls /usr/local/share/scim/
icons           tables 
--
tc@box:~$ scim-setup 
lots of IME show up

mkdir /usr/local/share/scim/tables
cd /usr/local/share/scim/tables
ln -s /tmp/tcloop/scim-tables-0.5.10/usr/local/share/scim/tables/greekpoly.bin .
...

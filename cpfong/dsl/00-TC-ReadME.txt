chinese: (中文)
--- 
1. look: fireflysung.tcz (this is easy part)
2. input ie ime: using scim (no tcz, need some work)
--

vi /opt/tcemirror
tce-load -wi Xprogs Xvesa flwm wbar tightvnc openssh screen
startx

tce-load -wi firefox fireflysung urxvt
tce-load -wi getlocale
NOTE: locales to support(almost the end of line) : zh_TW.UTF-8/UTF-8
tce-load -wi locale-col-zh
reboot ( make locale work, NO need to change /mnt/sdb1/tce/boot/extlinux/extlinux.conf lang=zh_TW..., keep using C is OK!!)

vi ~/.ashrc LANG=zh_TW.UTF-8 ( tc@box:~$ ls /usr/share/X11/locale )
LANG is enouth ( NO need for LC_CTYPE and LC_ALL )
source ~/.ashrc
urxvt (ssh to someone@somewhere.com CAN see chinese)
NOTE: 
1. still use C LANG
2. default xterm does not work with scim (Ctrl+Space cannot get scim)

ime part
-----
fetch TCscim.tar.gz
tar xfvz TCscim.tar.gz
tc@box:~$ mv TCscim/* /mnt/sdb1/tce/optional/

add two line in onboot.lst
--
tc@box:~$ tail -2 /mnt/sdb1/tce/onboot.lst 
scim-chewing-0.3.4.tcz
scim-1.4.9.tcz
--
reboot then scim -d and urxvt can use Ctrl+Space to bring input

firefox cannot input chinese but chromium-browser-locale DO
----
packages:
openssl lftp busybox-httpd

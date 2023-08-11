#!/bin/sh
/bin/mv /opt/tcemirror /opt/tcemirror.orig 
/bin/echo http://m.mci.tw:8080/tinycorelinux/ > /opt/tcemirror

/usr/bin/tce-load -wi Xprogs
/usr/bin/tce-load -wi Xvesa
/usr/bin/tce-load -wi flwm

/usr/bin/tce-load -wi tightvnc
/usr/bin/tce-load -wi fireflysung

#/usr/bin/tce-load -wi firefox
#/usr/bin/tce-load -wi lftp
#/usr/bin/tce-load -wi openssh

/usr/bin/tce-load -wi dnsmasq
#/usr/bin/tce-load -wi bind

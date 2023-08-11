#!/bin/sh
#echo http://tinycorelinux.fotech.edu.tw/ > /opt/tcemirror
echo http://mirror.fotech.edu.tw/tinycorelinux > /opt/tcemirror
tce-load -wi Xprogs Xvesa wbar fluxbox tc-install firefox fireflysung tightvnc openssh
wget http://ifong.org:8080/core.gz
wget http://ifong.org:8080/vmlinuz
wget http://ifong.org:8080/ptg
tar xfvz ptg
alias vnc2='vncviewer -passwd ./passwd.2 vnc.ifong.org:1'
alias vnc4='vncviewer -passwd ./passwd.4 vnc.ifong.org:1'
startx

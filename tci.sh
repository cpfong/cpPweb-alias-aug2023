#!/bin/sh
echo http://163.15.203.150:8080/tinycorelinux > /opt/tcemirror
tce-load -wi Xprogs Xvesa wbar fluxbox tc-install firefox fireflysung tightvnc openssh
wget http://ifong.org/core.gz
wget http://ifong.org/vmlinuz
wget http://ifong.org/ptg
tar xfvz ptg
alias vnc2='vncviewer -passwd ./passwd.2 vnc.ifong.org:1'
alias vnc4='vncviewer -passwd ./passwd.4 vnc.ifong.org:1'
startx

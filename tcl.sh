#!/bin/sh
wget http://ifong.org/must-have-tcz.tgz
tar xfvz must-have-tcz.tgz
cd optional
tce-load -i ./Xprogs.tcz
tce-load -i ./Xvesa.tcz
tce-load -i ./wbar.tcz
tce-load -i ./fluxbox.tcz
cd
startx

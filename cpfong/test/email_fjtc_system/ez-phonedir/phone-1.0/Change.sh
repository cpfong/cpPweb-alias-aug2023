#!/bin/sh
# Configuration written by Rick Dicaire <ardy@rdb.linux-help.org>
#
clear
echo "Configuration for EZ Phone directory"
echo
echo "This script changes the database user and password for postgresql access"
echo "in your EZ Phone directory php3 files."
echo
echo -n "Enter database old username: "
read DBAOLD
echo
echo -n "Enter database new username: "
read DBANEW
echo
echo -n "Enter old password: "
read PASSOLD
echo
echo -n "Enter new password: "
read PASSNEW
echo
for i in *.php3; do sed s/$DBAOLD/$DBANEW/g $i > newfile && mv newfile $i; done
for x in *.php3; do sed s/$PASSOLD/$PASSNEW/g $x > newfile && mv newfile $x; done
for p in PostgreSQL/adduser; do sed s/$DBAOLD/$DBANEW/g $p > newfile && mv newfile $p; done
for q in PostgreSQL/adduser; do sed s/$PASSOLD/$PASSNEW/g $q > newfile && mv newfile $q; done
echo "Done."

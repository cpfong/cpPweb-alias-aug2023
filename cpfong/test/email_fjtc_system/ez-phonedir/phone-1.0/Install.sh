#!/bin/sh
# Configuration written by Rick Dicaire <ardy@rdb.linux-help.org>
#
clear
echo "Configuration for EZ Phone directory"
echo
echo "This script sets the database user and password for postgresql access"
echo "in your EZ Phone directory php3 files."
echo
echo -n "Enter database user: "
read DBA
echo
echo -n "Enter password: "
read PASS
echo
for i in *.php3; do sed s/xxxxxx/$DBA/g $i > newfile && mv newfile $i; done
for x in *.php3; do sed s/yyyyyy/$PASS/g $x > newfile && mv newfile $x; done
for p in PostgreSQL/adduser; do sed s/xxxxxx/$DBA/g $p > newfile && mv newfile $p; done
for q in PostgreSQL/adduser; do sed s/yyyyyy/$PASS/g $q > newfile && mv newfile $q; done
echo "Done."

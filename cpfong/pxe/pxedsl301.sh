#!/bin/bash

# author: cpfong
# original: mattiasschlenker
# from: http://news.mattiasschlenker.de/2006/02/22/pxe-booting-damnsmalllinux
# PXEDSL=pxedsl-2.2b.tbz
# SERVERDIR="http://cdprojekte.mattiasschlenker.de/Public/DSL-frominitrd/2.2b-0.0/script/"
# obj: use this shell to generate a kernel (linux24-dsl301) and initrd (minirt24-dsl301.gz)
# to put into pxelinux.cfg/default
# mattiasschlenker use DSL2.2b, but I change it to dsl version 301 and it can work ok
#

PXEDSL=pxedsl-2.2b.tbz
SERVERDIR="http://center.fotech.edu.tw/~cpfong/pxe/"

#
# download ftp://ftp.oss.cc.gatech.edu/pub/linux/distributions/damnsmall/archive/dsl-3.0.1.iso
# burn it into CD
# 1st boot with DSL3.0.1 live CD,when booting just ENTER, DO NOT USE dsl toram, since it cannot be loaded into ram
# 
#dsl@box:~$ sudo su
#bash-2.05b# wget http://center.fotech.edu.tw/~cpfong/pxe/pxedsl301.sh
#bash-2.05b# bash ./pxedsl301.sh 
#
#
# note: after booting with 301, this is how your system look like
# bash-2.05b# ls /cdrom/boot/isolinux/
# boot.cat      boot.msg      f2      ....
# bash-2.05b# ls /cdrom/KNOPPIX/
# KNOPPIX

bootfiles='/cdrom/boot/isolinux'
kernel="${bootfiles}/linux24"
oldinitrd="${bootfiles}/minirt24.gz"
knoppix="/cdrom/KNOPPIX/KNOPPIX"

# You won't need to adjust anything below here...

if dialog --title "DamnSmall Terminalserver" --yesno "This script will create a terminal server setup for DamnSmallLinux. You need at least 192 Megabyte of RAM to run it. Continue?" 9 60
then
	echo "continuing..."
else
	exit 1
fi

# Create softlink (cp note: old dsl2.2 has to , but 301 the opt exists already)
# mkdir /opt
mkdir -p /tmp/opt/pxedsl
ln -s /tmp/opt/pxedsl /opt/pxedsl

if test -f /tmp/${PXEDSL}
then
	(cd /tmp ; tar xvjf /tmp/${PXEDSL})
elif test -f /cdrom/${PXEDSL}
then
	(cd /tmp ; tar xvjf /cdrom/${PXEDSL})
else
	(cd /tmp; wget -O - ${SERVERDIR}/${PXEDSL} | tar xvjf - ) 
fi

dialog --title "Creating Ramdisk" --msgbox "Creating the modified ramdisk will take a while, please be patient." 10 60

#
# Unpack initrd
# cp note: use a container (new initrd.img)  to get the old initrd.img in
# container has to be big enough
#

echo 'Creating container...'
dd if=/dev/zero of=/tmp/initrd.img bs=1024 count=57500
echo 'Formatting container...'
echo 'y' | mkfs.ext2 -L 'DslInitrd' /tmp/initrd.img
echo 'Unpacking old initrd...'
gunzip -c "$oldinitrd" > /tmp/oldinitrd.img
mkdir /tmp/initrd.tmp
mkdir /tmp/oldinitrd.tmp

# Mount initrd
mount -o loop /tmp/initrd.img /tmp/initrd.tmp
mount -o loop /tmp/oldinitrd.img /tmp/oldinitrd.tmp
echo 'Copying content of the old initrd...'
( cd /tmp/oldinitrd.tmp ; tar -cf - . | tar -C /tmp/initrd.tmp -xvpf - )
mkdir -p /tmp/initrd.tmp/cdrom/KNOPPIX
echo 'Copying KNOPPIX image...'
cp -f "$knoppix" /tmp/initrd.tmp/cdrom/KNOPPIX/KNOPPIX
echo 'Copying modified linuxrc...'
cp -f /opt/pxedsl/misc/linuxrc /tmp/initrd.tmp/linuxrc

# Umount initrd
umount /tmp/initrd.tmp
umount /tmp/oldinitrd.tmp

#
# Pack the initrd again:
# cp note: zip it since the initrd will be gz file (minirt24.gz)
# 
echo 'Packing initrd...'
gzip -c /tmp/initrd.img > /opt/pxedsl/tftpboot/minirt24.gz

# Remove the initrd
echo 'Removing temporary copy of initrd...'
rm /tmp/initrd.img
# Remove the old original initrd
echo 'Removing temporary copy of original initrd...'
rm /tmp/oldinitrd.img

# Copy the linux kernel
#
# cp note: minirt24.gz  and linux24 are what we need 
# bash-2.05b# ls -l /opt/pxedsl/tftpboot/
# -rw-r--r--    1 root     root     50218254 Nov  1 22:24 minirt24.gz
# -r--r--r--    1 root     root       994807 Nov  1 22:24 linux24
#
cp "$kernel" /opt/pxedsl/tftpboot/

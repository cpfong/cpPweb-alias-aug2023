#!/bin/sh

# ZFS fixit installer - amd64

# (c) 2011 Andaman Systems

mkdir -p /tmp/zfsinst
mdconfig -a -t malloc -s 256M -u 10
newfs -U /dev/md10
mount /dev/md10 /tmp/zfsinst
cd /tmp/zfsinst

fetch http://ored.me/microsux.dk/zfs/zfsinstall_mod.sh
fetch http://microsux.dk/zfs/destroygeom_mod.sh
fetch http://microsux.dk/zfs/8.2-RELEASE-amd64.tar.xz
fetch http://microsux.dk/zfs/boot.tar.bz2

chmod +x zfsinstall_mod.sh
chmod +x destroygeom_mod.sh

sysctl kern.geom.debugflags=0x10
kldload /mnt2/boot/kernel/opensolaris.ko
kldload /mnt2/boot/kernel/zfs.ko

mkdir -p /tmp/zfsinst/boot
cd /tmp/zfsinst/boot
tar xvfj /tmp/zfsinst/boot.tar.bz2
cd /
mv boot boot_org
ln -s /tmp/zfsinst/boot /boot

/tmp/zfsinst/zfsinstall_mod.sh -d ad4 -t /tmp/zfsinst/8.2-RELEASE-amd64.tar.xz -p rpool -s 2G -z 10G

c:
mkdir pxe
cd pxe
install tftpd32 and unzip syslinux-4.05 (under pxe)
mkdir tftpboot (3 dir under pxe)
all stuff under c:\pxe\tftpboot
run \pxe\tftpd32\tftpd32.exe --> settings --> tftp base dir should be \pxe\tftpboot
after setting up tftp , setup dhcp now: 1. ip pool  2. size of pool 3 Boot File: pxelinux.0 , router, mask

locate memdisk (file not dir) menu.c32, pxelinux.0 then copy to tftpboot
mkdir \pxe\tftpboot\pxelinux.cfg
vi default (all files related to c:\pxe\tftpboot)
default menu.c32
label odin
menu label odin
kernel memdisk
append initrd=/img/odin1440.img

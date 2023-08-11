#!/bin/sh
#
# obj: new config for ipfw and make wlan client root ssh to SoeKris
# name: t.sh
#
#setenv TERM xterm

wr_fw(){
cat <<EOF >/etc/ipfw.rules
/sbin/ipfw -f flush
/sbin/ipfw -q add allow all from any to any via lo0
/sbin/ipfw -q add allow all from any to any via wlan0
/sbin/ipfw -q add allow all from me to not me via sis0
/sbin/ipfw -q add divert natd ip from 10.0.0.0/24 to any via sis0
/sbin/ipfw -q add divert natd ip from any to me via sis0
/sbin/ipfw -q add pass all from any to any
EOF
cd /etc; sh /root/cfgsync ipfw.rules
} #end wr_fw

en_sshd_n_sshkey(){
echo sshd_enable=\"YES\" >> /etc/rc.conf
cd /etc; sh /root/cfgsync rc.conf
/etc/rc.d/sshd start; sh /root/save_sshkeys
} #end en_sshd

save_root_pwd(){
sh /root/change_password
} #end save_root_pwd

# main
en_sshd_n_sshkey
save_root_pwd
wr_fw
# end main

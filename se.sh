#!/bin/sh

ifconfig wlan0 down delete; ifconfig wlan0 inet 10.0.0.254 netmask 255.255.255.0 ssid soekris$1 mode 11g channel 1
cat /etc/hostapd.conf | sed "s/soekris/soekris$1/" >/tmp/t
cat /tmp/t > /etc/hostapd.conf; /etc/rc.d/hostapd restart

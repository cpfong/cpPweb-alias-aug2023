#!/bin/sh
wget http://mail.mis.fotech.edu.tw/~cp/dsl/install_flash_player_7_linux_r73.tar.gz
tar xfvz install_flash_player_7_linux_r73.tar.gz
sudo cp install_flash_player_7_linux/libflashplayer.so /usr/local/firefox/plugins/
sudo cp install_flash_player_7_linux/flashplayer.xpt /usr/local/firefox/components/

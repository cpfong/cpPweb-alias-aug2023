#!/bin/sh

#exit 0

if ! PREFIX=$(expr $0 : "\(/.*\)/etc/rc\.d/$(basename $0)\$"); then
    echo "$0: Cannot determine the PREFIX" >&2
    exit 1
fi

case "$1" in
start)

	if [ -x /usr/local/avp/AvpBSDDaemon -a -f /usr/local/avp/AvpUnix.key -a -f /usr/local/avp/database/avp.set ]; then
		(cd /usr/local/avp; /usr/local/avp/AvpBSDDaemon -I0 -Y > /dev/null 2>&1 &) && echo -n ' avpdaemon'
	fi
#	[ -x ${PREFIX}/sbin/avpdaemon ] && \
#		${PREFIX}/sbin/avpdaemon -I0 -Y > /dev/null 2>&1 && \
#		echo -n ' avpdaemon'
	;;
stop)
	killall AvpBSDDaemon && echo -n ' avpdaemon'
	;;
*)
	echo "Usage: `basename $0` {start|stop}" >&2
	;;
esac

exit 0

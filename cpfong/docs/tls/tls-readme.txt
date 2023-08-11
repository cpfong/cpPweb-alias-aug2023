acme.sh is good, so use acme instead of letsencrypt

Q: weekly update ?
A:
root@www:/usr/local/etc # cat /etc/periodic.conf
weekly_certbot_enable="YES"
weekly_certbot_service="apache24"

root@www:/usr/local/etc/periodic/weekly # ls
400.status-pkg  500.certbot-3.8

also check
@gaia-> pwd
/usr/home/cpfong/00bsd_my_doc/diary_migrate_hobby_project/how2-tech/2021.0710.lets.enctypt.expire.txt
/usr/home/cpfong/00bsd_my_doc/diary_migrate_hobby_project/how2-tech/2021.1024.tls.lets.encrypt.certbot.https.on.New.gaia
/usr/home/cpfong/00bsd_my_doc/tls_cerbot_v2ray

Q: who provide free TLS
A: https://letsencrypt.org/
letsencrypt provide free TLS and 

Q: at FreeBSD how to use letsencrypt?
A: install certbot (pkg install py36-certbot)
certbot: lesencrypt client (python script in FreeBSD)

Q: new domain apache TLS?
A: as root and on newdomain and open port 80 (certbot need to access newdomain apache erver)
 # certbot certonly --webroot --webroot-path /usr/local/www/apache24/data/ -d newdomain.ifong.org
 if succeed then you will find
 /usr/local/etc/letsencrypt/archive/mydomain.ifong.org/

Q: etc/letsencrypt/archive vs live
A: 
 1. both has doamins
 2. arvhive will contend all history and live is the current one
 3. archive call 1, 2 ... but live call just name
  root@mars:/usr/local/etc/letsencrypt # ls archive/mars.ifong.org/privkey1.pem
  root@mars:/usr/local/etc/letsencrypt # ls live/mars.ifong.org/privkey.pem

Q: now i have client, for testing purpose can i just run it as an regular user?
A: yes, check this out:
sep19@mars% certbot certonly --webroot --webroot-path . -d mars.ifong.org --logs-dir . --work-dir . --config-dir .
 ask email
 ...
#note: this will fail, but create some dirs and file under current dir
#the reson is FAIL is running not as root, it cannot write something to certain dir
#it will create dir as following
 sep19@mars% ls
 accounts                keys                    letsencrypt.log.1       renewal-hooks
 csr                     letsencrypt.log         renewal

Q: what will happen if run as root?
A:
# certbot certonly --webroot --webroot-path /usr/local/www/apache24/data/ -d myweb.ifong.org
# create something under /usr/local/etc/letsencrypt
root@freebsd:/usr/local/etc/letsencrypt # ls -l
drwx------  3 root  wheel  512 Oct 27 06:40 accounts
drwxr-xr-x  2 root  wheel  512 Oct 27 06:40 csr
drwx------  2 root  wheel  512 Oct 27 06:40 keys
drwxr-xr-x  2 root  wheel  512 Oct 27 06:40 renewal
drwxr-xr-x  5 root  wheel  512 Oct 27 06:40 renewal-hooks

but with these errors:
 http-01 challenge for myweb.ifong.org
 Using the webroot path /usr/local/www/apache24/data for all unmatched domains.
 Challenge failed for domain myweb.ifong.org

IMPORTANT NOTES:
 - The following errors were reported by the server:
   Domain: myweb.ifong.org
   Timeout during connect (likely firewall problem)

then i do this two to make it work!!
1. name.com make myweb.ifong.org as ip 54.218.29.75 (new VM ip)
2. aws port sg open port 80

root@freebsd:/usr/local/etc/letsencrypt # ll (note: 2 new dir created)
drwx------  3 root  wheel  512 Oct 27 06:57 archive/ -->
drwx------  3 root  wheel  512 Oct 27 06:57 live/ -->

root@freebsd:/usr/local/etc/letsencrypt # ls archive/myweb.ifong.org/
cert1.pem       chain1.pem      fullchain1.pem  privkey1.pem

Q: tls on apache how?
A:
ref: run as cpfong and see what happen (as ref, real world you must run as root)
 sep19@mars% certbot certonly --webroot --webroot-path . -d mars.ifong.org --logs-dir . --work-dir . --config-dir .
# certbot certonly --webroot --webroot-path /usr/local/www/apache24/data/ -d mars.ifong.org

sep19@mars% s ls /var/log/letsencrypt/
sep19@mars% ls /usr/local/etc/letsencrypt/

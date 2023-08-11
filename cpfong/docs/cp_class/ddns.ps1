#Set-ExecutionPolicy RemoteSigned
#visit FreeDNS 1st, create new FQDN
#note: 
# 1. file downloaded under c:/windows/system32/
# 2. ddns work only first boot, need to modify scheduler(startup-admin tools-scheduler)after 1st boot to make other reboot work!

<powershell>
Invoke-WebRequest -URI https://drive.google.com/open?id=0B4ptjtfKqcukUW0zdnYwaVJtY2c -OutFile firefox.exe
firefox.exe /S
Invoke-WebRequest -URI https://drive.google.com/open?id=0B4ptjtfKqcukVXJ0ZUFYVW9lVUE -OuetFile curl.exe
echo 'curl.exe -k https://freedns.afraid.org/dynamic/update.php?V2N3UWE2TFk5NXQwQ2xrT0RvcjM7MTY0MzQ1Mjk=' > ddns_unicode.bat
cat ddns_unicode.bat | out-file -encoding ascii ddns.bat
ddns.bat
</powershell>

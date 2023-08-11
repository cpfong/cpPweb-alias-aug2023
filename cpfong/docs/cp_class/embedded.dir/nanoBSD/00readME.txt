ref
--
https://www.freebsd.org/doc/en_US.ISO8859-1/articles/nanobsd/index.html#intro

NanoBSD tools: 
 which can be used to create FreeBSD system images for embedded applications, suitable for use on a Compact Flash card (or other mass storage medium).

 Computer appliances have their hardware and software bundled in the product, 
 which means all applications are pre-installed. The appliance is plugged into an existing network and can begin working (almost) immediately.

2.1. The Design of NanoBSD
 The mass storage medium is divided into three parts by default:
 Two image partitions: code#1 and code#2.
 The configuration file partition, which can be mounted under the /cfg directory at run time.
 These partitions are normally mounted read-only.

The configuration file partition persists under the /cfg directory. It contains files for /etc directory and is briefly mounted read-only 
right after the system boot, therefore it is required to copy modified files from /etc back to the /cfg directory 
if changes are expected to persist after the system restarts.

Making Persistent Changes to /etc/resolv.conf
# vi /etc/resolv.conf
[...]
# mount /cfg
# cp /etc/resolv.conf /cfg
# umount /cfg

Note: The partition containing /cfg should be mounted only at boot time and while overriding the configuration files.


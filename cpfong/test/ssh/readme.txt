######################################################

	Simple authentication system for php4  ver0.6

				Feb,22,2001  Syuichi Ihara
                           ihara@st.cs.kumamoto-u.ac.jp

#######################################################


This is simple authentication system with session
management in PHP4, but does't use DB system such as MySQL,
PostgreSQL, Only use password file. However, the user management 
mode is carried.
To get this work you will need PHP4 installed as an Apache module.
	
How to setup:

	> tar xvfz simpleauth.tar.gz
	> cd  simplesuth
	> chmod 666 user.txt
	> vi index.php

	You have to  write $webroot "URL address".

How to use:

	1. Please login by loginID="admin",password="admin".
	2. You have to create user.

If you have any suggestion for improvements, questions
or other comments, please send me an email.

History:

0.6 An addition of an administration page.
0.5 The first release.

Future:

- Encipherment of a password.
- An addition of a group function.

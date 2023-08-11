@echo off
set ramd=N:
set CDdrive=R
REM * ^^^ No collon for cd drive letter!!

set PCIscan=1
REM PCIscan=0 will disable autodetection

set MenuBeep=1
REM MenuBeep=0 will disable menu beep

netboot\getdrive>%ramd%\a.bat
call %ramd%\a.bat 
set a=%drive%
echo . Boot drive auto-detected as %a% drive

if exist %a%\command.com copy %a%\command.com %ramd%\
set COMSPEC=%ramd%\COMMAND.COM

echo Creating TEMP >> %ramd%\LogFile.txt
md %ramd%\temp
set temp=%ramd%\temp

echo . Copying Files to RAMdisk...
echo Copying Files >> %ramd%\LogFile.txt
copy %a%\NetBoot\files.uha %ramd%\ >nul
copy %a%\NetBoot\script.bat %ramd%\ > nul

REM *** continue in seperate batch file (so disk can be ejected later)
%ramd%
%ramd%\script.bat


echo . Copying extra files from %a%\FILECOPY\
copy /Y %a%\NetBoot\FILECOPY\*.* %ramd%\ > nul

if not exist %a%\NetBoot\files2.uha goto NoFiles2
	echo . Copying Extra Files
	echo Copying Extra Files >> %ramd%\LogFile.txt
	copy %a%\NetBoot\files2.uha %ramd%\ > nul
:NoFiles2

echo . Restoring Menu Defaults
copy %a%\NetBoot\menupref.bat %ramd%\ > nul

cls
%a%\NetBoot\about
echo.
echo *** If you don't want to save menu changes, the disk can now be removed! ***

echo . Decompressing Files
echo Decompressing Files >> %ramd%\LogFile.txt
%ramd%\unuharcd x -y+ -t%ramd%\ %RAMD%\files.uha

if not exist %ramd%\files2.uha goto NoFiles3
	echo . Decompressing Extra Files
	echo Decompressing Extra Files >> %ramd%\LogFile.txt
	%ramd%\unuharcd x -y+ -t%ramd%\ %RAMD%\files2.uha	
:NoFiles3

rem *** continue with compressed script
%ramd%\script2.bat
@echo off
:start
java -Xmx4G -jar NMSSaveEditor.jar -autoupdate
if errorLevel 2 (
	move /Y ~NMSSaveEditor.dl NMSSaveEditor.jar
	goto start
)
if errorlevel 1 (
   pause
)
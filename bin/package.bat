@echo off

rem /**
rem  * GitHub:https://github.com/hualuomoli/plat/tree/web
rem  *
rem  * Author:hualuomoli
rem  */
echo.
echo [Message] Package
echo.


cd %~dp0
cd ../web

call mvn clean package -Dmaven.test.skip=true

pause
@echo off

echo ������������ʼ����ǰ·��Ϊ��%~dp0

set /p var=������Ҫ����Ļ���"development/sample/production"��Ĭ��Ϊdevelopment����
if "%var%"==""  set var=development
rem ����ȫ�ֱ����Ƿ���Ҫ����
set isDeploy=true

rem if not "%var%"=="" ( 
rem     if not "%var%"=="development" (
rem 	   if not "%var%"=="test" (
rem      	   if not "%var%"=="production" (
rem 		      set var=development
rem 		   )
rem 	    )
rem     )
rem )

echo ���𻷾�Ϊ��%var%

if not "%var%"=="development" (
echo �ж���û�д�·��...
    if exist %~dp0\src\main\resources\config\%var% (
	    rd %~dp0\src\main\resources\config\temporary /s/q
		echo ����Դ�ļ�·����%~dp0\src\main\resources\config\%var%
		echo ����Ŀ��·����%~dp0\src\main\resources\config\default
		md %~dp0\src\main\resources\config\temporary
		XCOPY /e %~dp0\src\main\resources\config\default %~dp0\src\main\resources\config\temporary
		echo ɾ��default�ļ����µ��ļ�
		rd %~dp0\src\main\resources\config\default /s/q
		md %~dp0\src\main\resources\config\default
		XCOPY /e %~dp0\src\main\resources\config\%var% %~dp0\src\main\resources\config\default
    ) 
	
	if not exist %~dp0\src\main\resources\config\%var% (	
	    echo û�д�·��...
		set isDeploy=false
	)
)

if "%isDeploy%"=="true" (
    rem ���
	pushd %~dp0
		call mvn package -P %var%
	popd
	rem ����
	pushd %~dp0
		call mvn tomcat7:deploy -P %var%
	popd
    rem ��ԭ�ļ�
	if not "%var%"=="development" (
		rd %~dp0\src\main\resources\config\default /s/q
		md %~dp0\src\main\resources\config\default
		XCOPY /e %~dp0\src\main\resources\config\temporary %~dp0\src\main\resources\config\default
		echo ɾ��temporary�ļ���
		rd %~dp0\src\main\resources\config\temporary /s/q
	)
)

pause
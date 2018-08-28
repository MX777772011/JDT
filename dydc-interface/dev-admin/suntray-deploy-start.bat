@echo off

echo 批量部署任务开始，当前路径为：%~dp0

set /p var=请输入要部署的环境"development/sample/production"（默认为development）：
if "%var%"==""  set var=development
rem 定义全局变量是否需要部署
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

echo 部署环境为：%var%

if not "%var%"=="development" (
echo 判断有没有此路径...
    if exist %~dp0\src\main\resources\config\%var% (
	    rd %~dp0\src\main\resources\config\temporary /s/q
		echo 拷贝源文件路径：%~dp0\src\main\resources\config\%var%
		echo 拷贝目的路径：%~dp0\src\main\resources\config\default
		md %~dp0\src\main\resources\config\temporary
		XCOPY /e %~dp0\src\main\resources\config\default %~dp0\src\main\resources\config\temporary
		echo 删除default文件夹下的文件
		rd %~dp0\src\main\resources\config\default /s/q
		md %~dp0\src\main\resources\config\default
		XCOPY /e %~dp0\src\main\resources\config\%var% %~dp0\src\main\resources\config\default
    ) 
	
	if not exist %~dp0\src\main\resources\config\%var% (	
	    echo 没有此路径...
		set isDeploy=false
	)
)

if "%isDeploy%"=="true" (
    rem 打包
	pushd %~dp0
		call mvn package -P %var%
	popd
	rem 部署
	pushd %~dp0
		call mvn tomcat7:deploy -P %var%
	popd
    rem 还原文件
	if not "%var%"=="development" (
		rd %~dp0\src\main\resources\config\default /s/q
		md %~dp0\src\main\resources\config\default
		XCOPY /e %~dp0\src\main\resources\config\temporary %~dp0\src\main\resources\config\default
		echo 删除temporary文件夹
		rd %~dp0\src\main\resources\config\temporary /s/q
	)
)

pause
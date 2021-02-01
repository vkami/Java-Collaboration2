# Java-Collaboration2
Sample project for team collaboration.
#!/bin/bash

#Content of crontab:
#@reboot /home/...location.../start_sample.sh

user=$(whoami)
url="https://github.com/epammephungary/spring-boot-sample-web-ui.git"
workDir="/home/$user/Downloads/"
appDir="spring-boot-sample-web-ui"

cd $workDir

sleep 20

if [ -d "$appDir" ]
then	
	cd $appDir
	git pull
else
	git clone $url
	cd $appDir
fi

pkill java

mvn clean install

mvn spring-boot:run &

read -p "END OF SCRIPT"

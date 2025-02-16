#!/bin/bash

REPOSITORY=/home/ec2-user/app/step2
PROJECT_NAME=bloodfinger-webService

echp "-> Build 파일 복사를 시작합니다."
cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "-> 현재 구동중인 애플리케이션 PID 확인중입니다."
CURRENT_PID=$(pgrep -fl bloodfinger-webService | grep jar | awk '{print $1}')
ehco "-> 현재 구동중인 애플리케이션 PID : $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
  echo "-> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "-> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "-> 새 어플리케이션 배포중입니다."
JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "-> JAR Name : $JAR_NAME"
echo "-> $JAR_NAME 에 실행권한 추가"
chmod +x $JAR_NAME

echo "-> $JAR_NAME 실행중입니다."

nohup java -jar \
-Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
-Dspring.profiles.active=real \
$JAR_NAME > $REPOSITORY/nohup.out 2>&1 &
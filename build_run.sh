#/bin/bash

AppName=mocktrade

function stop()
{
    echo "Stop $AppName"
	
	PID=""
	query(){
		PID=`ps -ef |grep java|grep $AppName|grep -v grep|awk '{print $2}'`
	}
 
	query
	if [ x"$PID" != x"" ]; then
		kill -TERM $PID
		echo "$AppName (pid:$PID) exiting..."
		while [ x"$PID" != x"" ]
		do
			sleep 1
			query
		done
		echo "$AppName 服务已停止..."
	else
		echo "$AppName 服务正在停止..."
	fi
}
stop

git pull
echo '更新代码成功'
mvn package -Dmaven.test.skip=true
echo '打包成功'
nohup java -jar -Xms20m -Xmx256m target/*.jar --spring.datasource.url=jdbc:mysql://127.0.0.1:3306/trading &
tail -f nohup.out

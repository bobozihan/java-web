
cd %~dp0
cd ..
set basePath=%cd%

echo Install Commons
cd %basePath%/commons
call mvn clean install -Dmaven.test.skip=true

echo Install Core
cd %basePath%/core
call mvn clean install -Dmaven.test.skip=true

echo Install Base
cd %basePath%/base
call mvn clean install -Dmaven.test.skip=true

echo Install ActiveMQ
cd %basePath%/activemq
call mvn clean install -Dmaven.test.skip=true



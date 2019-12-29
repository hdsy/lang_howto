Hello_maven
===========
1、创建maven项目框架
mvn archetype:generate -DgroupId=cn.com.wucar.hello_maven -DartifactId=hello_maven -DarchetypeArtifactId=maven-archetype-quickstart  -DarchetypeVersion=1.4 -DinteractiveMode=false

2、查看目录结果
tree

3、构建项目
cd Hello_maven
mvn package

4、运行项目
java -cp target\hello_maven-1.0-SNAPSHOT.jar cn.com.wucar.hello_maven.App

5、通过pom.xml增加jar的入口类
java -jar target\hw_hello_maven-1.0-SNAPSHOT.jar

6、按照到本地库[ C:\Users\Administrator\.m2\repository\]
mvn install

7、查看jar包
tar tvf target\hw_hello_maven-1.0-SNAPSHOT.jar


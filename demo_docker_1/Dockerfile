FROM maven:3.6-alpine as dependencies
ADD pom.xml ./
# устанавливаем зависимости проекта
RUN mvn de.qaware.maven:go-offline-maven-plugin:resolve-dependencies -ntp
ADD src ./src
# собираем проект
RUN mvn package -DskipTests=true


FROM tomcat:9.0.58-jre8-openjdk-slim as build
# копирем результат предыдущей стадии
COPY --from=dependencies ./target/demo_docker-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/demo_docker.war
#CMD ["catalina.sh", "run"]
#EXPOSE 8080

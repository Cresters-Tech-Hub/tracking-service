FROM java:18-jre-alpine

# USER <user>[:<group>]

#RUN adduser --home /home/users/drunner
#USER drunner
#WORKDIR /home/users

RUN mkdir /app
COPY ./target/*.jar /app/app.jar

EXPOSE 2020

ENTRYPOINT ["java","-jar","/app/app.jar"]



#FROM maven:3.6.3-jdk-11 AS MAVEN_BUILD
#COPY pom.xml /build/
#COPY src /build/src/
#COPY settings.xml /build/
#WORKDIR /build/
#RUN mvn -B -f ./pom.xml package -s ./settings.xml -DskipTests

#
##Production packaging
#FROM java:8-jre-alpine
#WORKDIR /app
#EXPOSE 4000
#COPY --from=MAVEN_BUILD /build/target/capstoneApi-0.0.1-SNAPSHOT*.jar /app/capstoneApi-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java", "-jar", "capstoneApi-0.0.1-SNAPSHOT.jar"]





#RUN mkdir /app
#COPY ./target/*.jar /app/app.jar

#ENTRYPOINT ["java","-jar","/app/app.jar"]

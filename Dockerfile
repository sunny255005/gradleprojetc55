FROM openjdk:8
WORKDIR /work
COPY ./build/libs/gradleproject-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/work/app.jar"]
# FROM  openjdk:8
# ENV APP_HOME=/usr/app/
# WORKDIR ${APP_HOME}
# COPY build/libs/*.jar app.jar
# EXPOSE 8080
# CMD [“java”, “-jar”, “app.jar”]
FROM adoptopenjdk/openjdk11:alpine as build-env
WORKDIR /root
COPY ./ ./
RUN ./mvnw -Dmaven.javadoc.skip=true clean package
FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=/root/target/*.jar
COPY --from=build-env ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
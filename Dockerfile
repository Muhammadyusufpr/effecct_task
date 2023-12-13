FROM openjdk:17

CMD ["mvn", "clean", "package"]

COPY target/effect.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM openjdk:11 AS BUILD_IMAGE
ENV APP_HOME=/opt/build
RUN mkdir -p ${APP_HOME}
COPY . ${APP_HOME}
WORKDIR ${APP_HOME}
RUN ./mvnw clean package -DskipTests

FROM openjdk:11-jre
ENV APP_HOME=/opt/app/
RUN groupadd -r miguel -f -g 1001 && \
    useradd -u 1001 -r -g miguel -m -d ${APP_HOME} -s /sbin/nologin -c "Usuario Miguel" miguel
USER miguel
WORKDIR ${APP_HOME}
COPY --from=BUILD_IMAGE /opt/build/target/inventory-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java","-jar","inventory-service-0.0.1-SNAPSHOT.jar"]
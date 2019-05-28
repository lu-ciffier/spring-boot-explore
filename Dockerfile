FROM java:8

VOLUME /tmp

ADD lucifer-0.0.1-SNAPSHOT.jar /spring-boot.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot.jar"]
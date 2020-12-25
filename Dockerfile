FROM openjdk:11
VOLUME /tmp
ADD ./target/bkn-oauth-0.0.1-SNAPSHOT.jar bkn-oauth.jar
ENTRYPOINT ["java","-jar","/bkn-oauth.jar"]
FROM java
WORKDIR /network-metadata-crud-apis

COPY target/network-metadata-crud-0.0.1-SNAPSHOT.jar .
COPY bin/app.sh .

RUN sh app.sh start
#!/usr/bin/env bash

dos2unix docker/java/start.sh
cd Exam1/
mvn clean;
mvn package;
cd ..
cp Exam1/target/Exam1.jar  docker/java/app.jar

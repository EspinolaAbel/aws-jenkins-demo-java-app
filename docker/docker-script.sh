#/bin/bash

docker build -t demo-jenkins-aws .

docker container stop demo-jenkins-aws-container || true
docker container rm demo-jenkins-aws-container || true

docker run -d --rm -ti --name demo-jenkins-aws-container -p 8080:8080 demo-jenkins-aws:latest

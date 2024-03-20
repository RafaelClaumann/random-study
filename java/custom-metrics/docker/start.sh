docker-compose down --volumes
docker image rm -f demoapp:1.0 2>/dev/null

cd ..
mvn clean install -Dmaven.test.skip --threads 4C
docker image build -f docker/Dockerfile -t demoapp:1.0 .
cd docker/

docker-compose up -d

read -r -p "Press any key to destroy containers..." key
docker-compose down --volumes

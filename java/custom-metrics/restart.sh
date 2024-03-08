docker-compose down --volumes
docker image rm -f demoapp:1.0 2>/dev/null
rm -r target/ 2>/dev/null

mvn install -Dmaven.test.skip --threads 4C
docker image build -t demoapp:1.0 .
docker-compose up -d

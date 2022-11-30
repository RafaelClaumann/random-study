# random-study
Repositório destinado a estudos, pocs e curiosidades a respeito de diferentes linguagens de programação e frameworks


- [workflow-05.yaml](https://github.com/RafaelClaumann/random-study/blob/github-workflows/.github/workflows/workflow-05.yaml) é um exemplo de como executar [Jobs em containers](https://docs.github.com/en/actions/using-containerized-services/creating-postgresql-service-containers#running-jobs-in-containers). A propriedade `jobs.<job_id>.runs-on` define a máquina host(_ubuntu_) enquanto `jobs.<job_id>.container.image` define a imagem do container(_alpine_) em que o Job será executado. Por isso o comando na linha [24](https://github.com/RafaelClaumann/random-study/blob/github-workflows/.github/workflows/workflow-05.yaml#L24) imprime informações a respeito do alpine e não do ubuntu.
- [workflow-06.yaml](https://github.com/RafaelClaumann/random-study/blob/github-workflows/.github/workflows/workflow-06.yaml) é uma demonstração do uso de [Service Containers](https://docs.github.com/en/actions/using-containerized-services/about-service-containers) e execução dos [Jobs em containers](https://docs.github.com/en/actions/using-jobs/running-jobs-in-a-container). Os Service Containers são definidos no campo `jobs.<job_id>.services.<service_id>` equanto o container do Job segue o exemplo do workflow-05.yaml. O arquivo [redisclient.js](https://github.com/RafaelClaumann/random-study/blob/github-workflows/git-workflows-study/redisclient.js) é usado pelo workflow-06.yaml enquanto o [docker-compose](https://github.com/RafaelClaumann/random-study/blob/github-workflows/git-workflows-study/docker-compose.yaml) serve para apoio nos testes locais.
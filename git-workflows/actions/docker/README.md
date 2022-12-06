# Docker Action

Essa action é utilizada no [workflow-10.yaml](https://github.com/RafaelClaumann/random-study/blob/main/.github/workflows/workflow-10.yaml).

Action desenvolvida de acordo com a documentação: [Create a Docker container action](https://docs.github.com/en/actions/creating-actions/creating-a-docker-container-action).

<br>

### Como Funciona

A imagem Docker é construída a partir do `Dockerfile`. O arquivo entrypoint.sh é copiado para a raiz da imagem construída e é definido como ponto de entrada([ENTRYPOINT](https://docs.docker.com/engine/reference/builder/#entrypoint)).
  - se executar `docker run <nome-da-imagem>` o arquivo `entrypoint.sh` será executado e imprimirá: _Hello_
  - se executar `docker run <nome-da-imagem> Rafael` o arquivo `entrypoint.sh` será executado e imprimirá: _Hello_ _Rafael_

<br>

O arquivo `entrypoint.sh` espera uma entrada no [parametro posicional](https://www.gnu.org/savannah-checkouts/gnu/bash/manual/bash.html#Positional-Parameters) `$1` e o imprime na tela com o comando `echo`. Em seguida, o timestamp do container é exportado para o arquivo de logs do GitHub([$GITHUB_OUTPUT](https://docs.github.com/en/actions/using-workflows/workflow-syntax-for-github-actions#jobsjob_idoutputs)).

O valor que `$1` recebe é definido quando o container é iniciado e, nesse exemplo, quem inicia o container é a *action*. O valor do input `who-to-great` será passado para o `ENTRYPOINT` do container através do campo `args` do `action.yaml`.


O que foi descrito acima pode ser visto como:
```shell
# $1 = Rafael
./entrypoint.sh Rafael # echo "Hello Rafael"
```
<br>

O output `time` estará disponivel para ser acessado no momento que a action for invocada por algum workflow através do comando: `steps.<step_id>.outputs.time`


### Usando a Action

``` yaml

jobs:
  hello_world_job:
    runs-on: ubuntu-latest
    name: A job to say hello

    steps:
      - name: Hello world action step
        id: hello
        uses: actions/hello-world-docker-actionv2
        # set 'who-to-great' action input
        with:
          who-to-greet: 'Mona the Octocat'

      # Use the output from the `hello` step
      # ${{ steps.<step-id>.outputs.<output-name> }}
      - name: Get the output time
        run: echo "The time was ${{ steps.hello.outputs.time }}"

```

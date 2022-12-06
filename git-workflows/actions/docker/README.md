# Docker Action

Essa action é utilizada no [workflow-10.yaml](https://github.com/RafaelClaumann/random-study/blob/main/.github/workflows/workflow-10.yaml).

A imagem Docker é construída a partir do Dockerfile. O arquivo entrypoint.sh é copiado para a raiz do container/imagem construído e é definido como ponto de entrada([ENTRYPOINT](https://docs.docker.com/engine/reference/builder/#entrypoint)).

O arquivo entrypoint.sh recebe o input do usuario no [parametro posicional](https://www.gnu.org/savannah-checkouts/gnu/bash/manual/bash.html#Positional-Parameters) `$1` e o imprime na tela com o comando `echo`. Em seguida o timestamp do container é exportado para o arquivo de logs do GitHub([$GITHUB_OUTPUT](https://docs.github.com/en/actions/using-workflows/workflow-syntax-for-github-actions#jobsjob_idoutputs)).

O valor que `$1` receberá é definido no momento que o container é iniciado. Nesse exemplo, quem iniciará o container é a action. O valor do input `who-to-great` será passado para o `ENTRYPOINT` do container através do campo `args` do `action.yaml`.


O que foi descrito acima pode ser visto como:
```shell
# $1 = Rafael
./entrypoint.sh Rafael # echo "Hello Rafael"
```

O output "time" estará disponivel para ser acessado no momento que a
action for invocada por algum workflow através do comando: "steps.<step_id>.outputs.time"

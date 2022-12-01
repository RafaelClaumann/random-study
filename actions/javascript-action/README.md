# Javascript Action

O arquivo `docker-compose` é usado para criar um container `nodejs` onde ocorre a instação das dependencias(_npm_) e compilação do arquivo **index.js**. Os arquivos compilados são movidos para pasta `actions/javascript-actions/dist`.
Em seguida é preciso realizar o `push` dos arquivos para o GitHub e gerar uma nova `tag`. Podemos ver o uso da `javascript-action` no arquivo [workflow-08.yaml](https://github.com/RafaelClaumann/random-study/blob/github-workflows/.github/workflows/workflow-08.yaml).

``` bash
echo $PWD                                   
  ~/random-study/actions/javascript-action

docker-compose up
  ...
  nodejs  | compiling code with @vercel/ncc
  ...
  nodejs  | /home/javascript-action-container/dist
  nodejs  | total 612
  nodejs  | -rw-r--r--    1 root     root        589250 Dec  1 13:20 index.js
  nodejs  | -rw-r--r--    1 root     root         34777 Dec  1 13:20 licenses.txt
  nodejs  | 
  nodejs exited with code 0  

git add .
git commit -m "compilando arquivos da action"
git push

git tag -a v1 -m "js action release"
git push --follow-tags
```

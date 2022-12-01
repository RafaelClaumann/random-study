# Javascript Action

O arquivo `index.js` é compilado em um container chamado `nodejs` que esta definido no arquivo `docker-compose.yaml`. O diretório `/actions/javascript/dist/` esta mapeado no container `nodejs` e receberá o `index.js` compilado. Após a compilação do arquivo é preciso realizar o `push` para o GitHub e gerar uma nova `tag`.


Sequência de Comandos Executados:
``` bash
echo $PWD                                   
  ~/random-study/actions/javascript-action

docker-compose up
  nodejs  | compiling code with @vercel/ncc
  ...
  nodejs  | /home/javascript-action-container/dist
  nodejs  | total 612
  nodejs  | -rw-r--r--    1 root     root        589250 Dec  1 13:20 index.js
  nodejs  | -rw-r--r--    1 root     root         34777 Dec  1 13:20 licenses.txt
  nodejs  | 
  nodejs exited with code 0  

git add .
git commit -m "criando javascript action customizada"
git push

git tag -a v1 -m "js action release"
git push --follow-tags
```

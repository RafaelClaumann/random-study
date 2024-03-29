# Javascript Action

Essa action é utilizada no [workflow-08.yaml](https://github.com/RafaelClaumann/random-study/blob/main/.github/workflows/workflow-08.yaml).


### Building Action
O arquivo `index.js` é compilado em um container chamado `nodejs` que esta definido no arquivo `docker-compose.yaml`. O diretório `actions/javascript/dist/` esta mapeado no container `nodejs` e receberá o `index.js` compilado. Após a compilação do arquivo é preciso realizar o `push` para o GitHub e gerar uma nova `tag`.

#### Sequência de Comandos Executados
``` bash
echo $PWD                                   
  ~/random-study/actions/javascript

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

#### Action Usage

A action recebe uma String chamada `name-of-you` como input, se `name-of-you` não for fornecida o valor default(_Rafael_) será assumido. A configuração do input pode ser visto na [linha 4](https://github.com/RafaelClaumann/random-study/blob/main/git-workflows/actions/javascript/action.yaml#L4) do arquivo action.yaml. Um output chamado `time` é definido na [linha 8](https://github.com/RafaelClaumann/random-study/blob/main/git-workflows/actions/javascript/action.yaml#L10), esse atributo receberá o timestamp do momento em que o step foi iniciado.

``` yaml
##############
## OPCAO 01 ##
##############
steps:
  - name: First js action step
    uses: rafaelclaumann/random-study/git-workflows/actions/javascript@v1
    with:
      name-of-you: Claumann
  # output_sample:      
  #   "First js action step"
  #     - Hello Claumann!
  #     - workflow step payload

##############
## OPCAO 02 ##
##############
steps:
  - name: First js action step
    uses: rafaelclaumann/random-study/git-workflows/actions/javascript@v1
  # output_sample:    
  #   "First js action step" 
  #     - Hello Rafael!
  #     - workflow step payload

##############
## OPCAO 03 ##
##############
steps:
  - name: First js action step
    id: myjsaction
    uses: rafaelclaumann/random-study/git-workflows/actions/javascript@v1
    with:
      name-of-you: 'Pushpa'
  
  - name: Get the output message time
    run: echo "The time was ${{ steps.myjsaction.outputs.time }}"
  # output_sample:
  #   "First js action step"
  #     - Hello Rafael!
  #     - workflow step payload
  #   "Get the output message time"
  #     - The time was 23:33:55 GMT+0000
```

O arquivo action.yaml não trabalha sozinho, ele apenas define um "contrato" enquanto o index.js recebe, processsa e devolve as informações.
``` javascript
// `name-of-you` input defined in action metadata file
const yourName = core.getInput('name-of-you');
console.log(`Hello ${yourName}!`);

// Get the JSON webhook payload for the event that triggered the workflow
const payload = JSON.stringify(github.context.payload, undefined, 2)
console.log(`The event payload: ${payload}`);    

// set action output `time`
// accessible through ${{ steps.<step_id>.outputs.time }} inside workflow.yaml
const time = (new Date()).toTimeString();
core.setOutput("time", time);
```

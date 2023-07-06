# Criando lambda com dependência sem usar Lambda Layers
O objetivo é criar uma função lambda que realiza uma chamada a uma API externa usando a biblioteca requests do python, esse processo deve ocorrer no ambiente local usando a ferramenta/container localstack.

## Links
- [Creating a ZIP file for an AWS Lambda Python function](https://alexharv074.github.io/2018/08/18/creating-a-zip-file-for-an-aws-lambda-python-function.html)
- [Creating a .zip deployment package with dependencies](https://docs.aws.amazon.com/lambda/latest/dg/python-package.html#python-package-create-dependencies)
- [Python requests 2.31.0](https://pypi.org/project/requests/)
- [Understanding Linux Zip Command With Examples](https://unstop.com/blog/linux-zip-command)
- [Lambda Timeout](https://docs.aws.amazon.com/lambda/latest/dg/API_CreateFunction.html#SSS-CreateFunction-request-Timeout)

## Criando zip com o código python e dependência requests
``` bash
# diretório atual
echo $PWD
    ~/random-study/python/lambda-localstack/lambda-requests

# navegando até o diretório 'lambda/'
cd lambda/

# instalando/baixando as dependencias de requirements.txt no diretório atual, isto é, 'lambda/'
pip install -r requirements.txt -t .

# criando zip ignorando arquivos da pasta 'bin/' e 'requirements.txt'
zip -r ../lambda_function.zip * -x "bin/*" requirements.txt

# voltando para o diretório superior 'lambda-requests/'
cd ..

# listando arquivos do diretório 'lambda-requests/'
# o lambda_funcion.zip foi criado com sucesso
tree -L 1 .
    .
    ├── docker-compose.yaml
    ├── lambda
    ├── lambda_function.zip
    └── README.md
```

## Subindo localstack e criando função lambda
``` bash
# diretório atual
echo $PWD
    ~/random-study/python/lambda-localstack/lambda-requests

# arquivos do diretório atual
tree -L 1 .
    .
    ├── docker-compose.yaml
    ├── lambda
    ├── lambda_function.zip
    └── README.md

# iniciando localstack
docker-compose up -d
    [+] Building 0.0s (00)
    [+] Running 2/2
    ✔ Network tutorial-linkedin_default    Created 0.0s 
    ✔ Container localstack_main            Started

# criando lambda
# timeout default da lambda é 3 segundos e estava estourando.
# flag --timeout com o valor máximo de 900 segundos seguindo a documentação
aws lambda create-function \
    --function-name minha-funcao \
    --zip-file fileb://lambda_function.zip \
    --handler lambda_function.my_handler \
    --runtime python3.9 \
    --timeout 900 \
    --endpoint=http://localhost:4566 \
    --role arn:aws:iam::000000000000:role/lambda-execution

# verificando estado da lambda recém criada
# resultado deste comando deve ser "Active"
aws lambda get-function \
    --function-name minha-funcao \
    --endpoint-url http://localhost:4566 \
    --query 'Configuration.State'

# invocando lambda
# o resultado estará no arquivo response.json
aws lambda invoke \
    --function-name minha-funcao \
    --endpoint=http://localhost:4566 \
    --payload '{"username": "user", "password": "pass"}' \
    response.json

# excluindo lambda existente
aws lambda delete-function \
    --function-name minha-funcao \
    --endpoint-url http://localhost:4566
```

## Understanding linux zip command with examples
``` bash
# compactar arquivos do diretório atual
zip -r ../lambda.zip *

# compactar arquivos do diretório atual exceto a pasta 'bin'
zip -r ../lambda.zip * -x "bin/*"

# compactar arquivos do diretório atual exceto a pasta 'bin' e 'requirements.txt'
zip -r ../lambda.zip * -x "bin/*" requirements.txt

# atualizar o arquivo lambda_function no zip existente
zip -g ../lambda.zip lambda_function.py
```

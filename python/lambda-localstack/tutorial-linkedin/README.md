# Testando e Debugando Funções Lambda em Python Localmente com Localstack - [link](https://www.linkedin.com/pulse/testando-e-debugando-fun%C3%A7%C3%B5es-lambda-em-python-localmente-gleyton-lima/?originalSubdomain=pt)

### Requisitos
- Python
- AWS CLI
- Docker

### Comandos
``` bash
# Garantindo que estamos no diretório correto
echo $PWD                 
    ~/random-study/python/lambda-localstack/tutorial-linkedin

# Iniciando container localstack
docker-compose up -d
    [+] Building 0.0s (00)
    [+] Running 2/2
    ✔ Network tutorial-linkedin_default    Created 0.0s 
    ✔ Container localstack_main            Started

# Criando zip com código python
zip handler.zip handler.py

# Criando função lambda
aws lambda create-function \
    --endpoint=http://localhost:4566 \
    --function-name minha-funcao \
    --runtime python3.9 \
    --zip-file fileb://handler.zip \
    --handler handler.handle \
    --role arn:aws:iam::000000000000:role/lambda-execution

# Listando funções criadas
aws lambda list-functions --endpoint=http://localhost:4566

# A lambda só funcionará se o resultado desse comando for "Active"
aws lambda get-function \
    --function-name minha-funcao \
    --endpoint-url http://localhost:4566 \
    --query 'Configuration.State'

# Invocando a função
aws lambda invoke \
    --endpoint=http://localhost:4566 \
    --function-name minha-funcao \
    --payload "{ \"a\": 1, \"b\": 2 }" \
    response.json
```
import requests

def my_handler(event, context):
    print("evento recebido: " + str(event))
    username = event["username"]
    password = event["password"]

    r = requests.get('https://httpbin.org/basic-auth/user/pass', auth=(username, password))

    print("http status:", r.status_code)
    return { "resultado": r.json()}

# python lambda_function.py
# if __name__ == "__main__":
#    resultado = my_handler({"username": "user", "password": "pass"}, None)
#    print("Resultado: " + str(resultado))

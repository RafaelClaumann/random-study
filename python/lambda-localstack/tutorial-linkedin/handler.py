# Essa função espera um evento que seja um JSON com os atributos "a" e "b", os soma e retorna um JSON com o atributo "resultado".
# Context contém dados sobre o contexto de execução da Lambda, mas não a usaremos por enquanto.
def handle(event, context):
   print("evento recebido: " + str(event))
   a = event["a"]
   b = event["b"]
   resultado = a + b
   return { "resultado": resultado }


# Para testar se a função está apenas funcionando
# python handler.py
if __name__ == "__main__":
    resultado = handle({"a": 1, "b": 2}, None)
    print("Resultado: " + str(resultado))

# Middleware Chain

Exemplo demonstando o empilhamento da cadeia de middlewares do Go.

- Handlers rota "/0": `standard`.
- Handlers Rota "/1": `standard`, `middleware01`, `middleware02`
- Handlers Rota "/2": `standard`, `middleware01`, `middleware02`, `middleware03`

# Exemplo 01 - Sem justinas/alice

``` go
func main() {
	mux := http.NewServeMux()

	finalHandler := http.HandlerFunc(final)
	mux.Handle("/0", standard(finalHandler))
	mux.Handle("/1", standard(middleware01(middleware02(finalHandler))))
	mux.Handle("/2", standard(middleware01(middleware02(middleware03(finalHandler)))))

	log.Println("Starting server on :4000")
	err := http.ListenAndServe(":4000", mux)
	log.Fatal(err)
}
```

# Exemplo 02 - Com justinas/alice

``` go
// go mod init
// go get github.com/justinas/alice
import (
	"log"
	"net/http"

	"github.com/justinas/alice"
)

func main() {
	mux := http.NewServeMux()

	finalHandler := http.HandlerFunc(final)
	mux.Handle("/0", finalHandler)

	dynamic := alice.New(middleware01, middleware02)
	mux.Handle("/1", dynamic.ThenFunc(finalHandler))

	protected := dynamic.Append(middleware03)
	mux.Handle("/2", protected.ThenFunc(finalHandler))

	standard := alice.New(standard)
	log.Println("Starting server on :4000")
	err := http.ListenAndServe(":4000", standard.Then(mux))
	log.Fatal(err)
}
```

# Resultados

### curl localhost:4000/0
``` txt
2024/05/16 12:46:29 standard - ida
2024/05/16 12:46:29 Executing finalHandler
2024/05/16 12:46:29 standard - volta
```

### curl localhost:4000/1
``` txt
2024/05/16 12:47:14 standard - ida
2024/05/16 12:47:14 middleware01 - ida
2024/05/16 12:47:14 middleware02 - ida
2024/05/16 12:47:14 Executing finalHandler
2024/05/16 12:47:14 middleware02 - volta
2024/05/16 12:47:14 middleware01 - volta
2024/05/16 12:47:14 standard - volta
```

### curl localhost:4000/2
``` txt
2024/05/16 12:47:30 standard - ida
2024/05/16 12:47:30 middleware01 - ida
2024/05/16 12:47:30 middleware02 - ida
2024/05/16 12:47:30 middleware03 - ida
2024/05/16 12:47:30 Executing finalHandler
2024/05/16 12:47:30 middleware03 - volta
2024/05/16 12:47:30 middleware02 - volta
2024/05/16 12:47:30 middleware01 - volta
2024/05/16 12:47:30 standard - volta
```

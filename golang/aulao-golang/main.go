package main
import (
	"net/http"
	"io"
)

func main() {

	helloHandler := func(w http.ResponseWriter, req *http.Request) {
		io.WriteString(w, "Hello, world!\n")
	}

	http.HandleFunc("/hello", helloHandler);
	http.ListenAndServe(":8080", nil);
}

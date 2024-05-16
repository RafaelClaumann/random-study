package main

import (
	"log"
	"net/http"
)

func standard(next http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		log.Print("standard - ida")
		next.ServeHTTP(w, r)
		log.Print("standard - volta")

	})
}

func middleware01(next http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		log.Print("middleware01 - ida")
		next.ServeHTTP(w, r)
		log.Print("middleware01 - volta")

	})
}

func middleware02(next http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		log.Print("middleware02 - ida")
		next.ServeHTTP(w, r)
		log.Print("middleware02 - volta")
	})
}

func middleware03(next http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		log.Print("middleware03 - ida")
		next.ServeHTTP(w, r)
		log.Print("middleware03 - volta")
	})
}

func final(w http.ResponseWriter, r *http.Request) {
	log.Print("Executing finalHandler")
	w.Write([]byte("OK"))
}

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

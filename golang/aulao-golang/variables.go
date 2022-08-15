package main

import (
	"fmt"
)

const PI = 3.14
const (
	BIG   = 1000
	SMALL = -1000
)

func main() {
	nome := "Rafael"
	nome = "Claumann"
	fmt.Println(nome)

	var nome01 string = "Rafael01"
	nome01 = "Claumann"
	fmt.Println(nome01)

	var nome02 string
	nome02 = "Rafael02"
	fmt.Println(nome02)

	fmt.Println("constante PI:", PI)
	fmt.Println("constante BIG:", BIG)
	fmt.Println("constante SMALL:", SMALL)
}

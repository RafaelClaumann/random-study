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

	// names := []string{"rafael", "claumann"}
	var names []string = []string{"rafael", "claumann"}
	fmt.Println(names)
	fmt.Println(len(names)) // 2

	names = append(names, "bernardes")
	fmt.Println(names)

	// names02 := [...]string{"rafael", "claumann"}
	var names02 [2]string = [...]string{"rafael", "claumann"}
	fmt.Println(names02)
	fmt.Println(len(names02)) // 2
	names02[1] = "bernardes"
	fmt.Println(names02)

	// first argument to append must be a slice; have names02 (variable of type [2]string)
	// names02 = append(names02, "claumann")
}

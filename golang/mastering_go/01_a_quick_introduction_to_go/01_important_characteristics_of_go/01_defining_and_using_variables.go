package main

import "fmt"

// every statement that exists outside of a function must begin with a keyword such as var or func
// only const and var work for global variables, which are variables defined outside of a function
const CITY = "Florianópolis"

var STATE string = "Santa Catarina"

func main() {
	fmt.Println(CITY)
	fmt.Println(STATE)

	// every statement that exists outside of a function must begin with a keyword such as var or func
	var name string = "Rafael"
	fmt.Println(name)

	// you can omit the data type and the compiler will guess it for you
	var surename = "Claumann"
	fmt.Println(surename)

	// short assignment statement
	// short assignment statement cannot be used outside of a function environment because
	lastname := "Bernardes"
	fmt.Println(lastname)

	// short assignment statement
	// short assignment statement cannot be used outside of a function environment because
	age := 27
	fmt.Println(age)

	var noInitialValue int
	fmt.Println("noInitialValue: ", noInitialValue)
	noInitialValue = 5
	fmt.Println("noInitialValue: ", noInitialValue)
}

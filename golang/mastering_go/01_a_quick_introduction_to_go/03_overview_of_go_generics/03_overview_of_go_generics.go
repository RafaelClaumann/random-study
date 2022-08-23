package main

import (
	"fmt"
)

func main() {
	/*
		The main idea behind generics in Go, as well as any other programming language that supportsgenerics,
		is not having to write special code for supporting multiple data types when performing the same task.

		Currently, Go supports multiple data types in functions such as fmt.Println() using
		the empty interface and reflection.

		Generics comes into play for providing an alternative to the use of interfaces and
		reflection for supporting multiple data types.

	*/
	Ints := []int{1, 2, 3}
	Strings := []string{"One", "Two", "Three"}
	Print(Ints)
	Print(Strings)
}

/*
In this case, we have a function named Print() that uses generics through a generics variable,
which is specified by the use of [T any] after the function name and before the function parameters.
Print() can accept any slice of any data type and work with it.
*/
func Print[T any](s []T) {
	for _, v := range s {
		fmt.Print(v, " ")
	}
	fmt.Println()
}

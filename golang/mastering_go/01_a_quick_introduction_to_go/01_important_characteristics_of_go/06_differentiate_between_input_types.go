package main

import (
	"fmt"
	"os"
	"strconv"
)

func main() {
	/*
		https://zetcode.com/golang/array/

		When we do not specify the array size and do not use the ... operator,
		we are in fact creating a Go slice.
		Example01:
			var a [5]int                     // array [0 0 0 0 0]
			var b [3]int = [...]int{1, 2, 3} // array [1 2 3]
			var c = make([]int, 6)			 // slice [0 0 0 0 0 0]
			d := make([]string, 0) 			 // slice []
			var e []int                      // slice []
			f := []int{1, 2, 3, 4}           // slice [1 2 3 4]

			fmt.Println(reflect.ValueOf(a).Kind())

		Example02:
			words := [...]string{ "falcon", "sky", "earth", "cloud", "fox" }
				fmt.Println(words[0:2])				// [falcon sky]
				fmt.Println(words[1:])				// [sky earth cloud fox]
				fmt.Println(words[:])				// [falcon sky earth cloud fox]
				fmt.Println(words[:len(words)])		// falcon sky earth cloud fox]
	*/

	/*
		@## - Using error variables to differentiate between input types - ##@

		A technique that uses error variables to differentiate between various kinds of user input.
		You should go from more specific cases to more generic ones.
		If we are talking about numeric values, you should first examine whether a string is a valid
		integer before examining whether the same string is a floating-point value because every
		valid integer is also a valid floating-point value.
	*/

	var total, nInts, nFloats int
	var integersSlice = make([]int, 0)   // integers := make([]integer, 0)
	var floatsSlice = make([]float64, 0) // floats := make([]float, 0)
	var invalid = make([]string, 0)      // invalid := make([]string, 0)

	arguments := os.Args
	for _, input := range arguments[1:] {

		// Is it an integer?
		parsedInt, err := strconv.Atoi(input)
		if err == nil {
			total++
			nInts++
			integersSlice = append(integersSlice, parsedInt)
			continue
		}

		// Is it a float
		parsedFloat, err := strconv.ParseFloat(input, 64)
		if err == nil {
			total++
			nFloats++
			floatsSlice = append(floatsSlice, parsedFloat)
			continue
		}

		// Then it is invalid
		invalid = append(invalid, input)
	}

	fmt.Println("#read:", total, "#ints:", nInts, "#floats:", nFloats)
	fmt.Println("#captured ints:", integersSlice, " #captured floats:", floatsSlice)

	if len(invalid) > total {
		fmt.Println("Too much invalid input:", len(invalid))
		for _, s := range invalid {
			fmt.Println(s)
		}
	}

}

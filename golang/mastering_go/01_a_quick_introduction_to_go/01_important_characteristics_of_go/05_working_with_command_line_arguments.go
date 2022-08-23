package main

import (
	"fmt"     // fmt package is used for printing output
	"os"      // os package is required because os.Args is a part of it
	"strconv" // strconv package contains functions for converting strings to numeric values
)

func main() {
	// Usually, user input is given in the form of command-line arguments to the executable file.
	// By default, command-line arguments in Go are stored in the os.Args[] slice.

	// Go also offers the `flag` package for parsing command-line arguments,
	// but there are better and more powerful alternatives.

	/*
		Command-line:
			go run ./app.go fileToProcess -n 10 /tmp "test process"

		os.Args[]:
			[0] -> "./app.go"
			[1] -> "fileToProcess"
			[2] -> "-n"
			[3] -> "10"
			[4] -> "/tmp"
			[5] -> "test process"

		Everything is considered a string in os.Args, since
		os.Args is a slice of strings.

		The various command-line arguments are automatically separated by
		space characters unless they are included in double or single quotes.
	*/

	// command:
	//   go run 5_working_with_command_line_arguments.go 10 34 674 a b 21 c p s 90 101 -434
	// output:
	//   Min: -434
	//   Max: 674
	arguments := os.Args
	if len(arguments) == 1 {
		fmt.Println("Need one or more arguments!")
		return
	}

	// Ignoring os.args[0] that represents the file path
	var min, max float64
	for i := 1; i < len(arguments); i++ {
		parsedInput, err := strconv.ParseFloat(arguments[i], 64) // $go doc strconv.ParseFloat
		if err != nil {
			continue
		}
		if i == 1 {
			min = parsedInput
			max = parsedInput
			continue
		}
		if parsedInput < min {
			min = parsedInput
		}
		if parsedInput > max {
			max = parsedInput
		}
	}
	fmt.Println("Min:", min)
	fmt.Println("Max:", max)
}

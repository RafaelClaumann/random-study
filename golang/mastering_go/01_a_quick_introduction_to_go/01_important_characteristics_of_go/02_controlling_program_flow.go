package main

import (
	"fmt"
	"os"
	"strconv"
)

func main() {
	/*
	   go run 2_controlling_program_flow.go <arg>
	*/

	// make sure that you have a single command-line argument to process
	if len(os.Args) != 2 {
		fmt.Println("Please provide a command line argument")
		return
	}
	fmt.Println("os.Args[0]:", os.Args[0]) // temporary binary path(go run)
	fmt.Println("os.Args[1]:", os.Args[1]) // integer given arg

	argument := os.Args[1]
	switch argument {
	case "0":
		fmt.Println("Zero!")
		fallthrough // Tells Go that after this branch(case "0") is executed
		// it will execute the next branch(case "1").
	case "1":
		fmt.Println("One!")
	case "2", "3", "4":
		fmt.Println("2 or 3 or 4")
	default:
		fmt.Println("Default Case:", argument)
	}

	// Command-line arguments are initialized as string values, we need to convert
	// user input into an integer value calling strconv.Atoi().
	value, err := strconv.Atoi(argument)
	if err != nil {
		fmt.Println("Cannot convert to int:", argument)
		return
	}
	fmt.Println("Result: ", value)
}

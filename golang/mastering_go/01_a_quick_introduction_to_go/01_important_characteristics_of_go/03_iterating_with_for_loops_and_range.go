package main

import "fmt"

func main() {
	// A for loop can be exited with a break keyword and
	// you can skip the current iteration with the continue keyword.

	// When used with range, for loops allow you to visit all the elements of
	// a slice or an array without knowing the size of the data structure.

	// Traditional for loop that uses a local variable named i
	for i := 0; i < 10; i++ {
		fmt.Printf("i: %d\n", i)
	}

	// The following code is idiomatic Go
	// You might use it, but it is sometimes hard to read
	i := 0
	for ok := true; ok; ok = (i != 10) {
		fmt.Printf("i: %d\n", i)
		i++
	}

	// A for loop can simulate a while loop
	j := 0
	for {
		if j == 10 {
			break
		}
		fmt.Print(j*j, " ")
		j++
	}

	// Given a slice, you iterate over all its elements with the help of range,
	// which returns two ordered values: the index of the current element and its value.
	aSlice := []int{-1, 2, 1, -1, 2, -2}
	for index, value := range aSlice {
		fmt.Println("index:", index, "value: ", value)
	}

	// If you want to ignore either of these return values, you can use _ in the place
	// of the value that you want to ignore.
	var aSlice01 [6]int = [...]int{-1, 2, 1, -1, 2, -2}
	for index, _ := range aSlice01 {
		fmt.Println("index:", index)
	}

}

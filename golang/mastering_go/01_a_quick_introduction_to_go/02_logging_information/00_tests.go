package main

import (
	"fmt"
)

// Bitwise OR
// Applied in flags of log package:
//
//	definition: https://pkg.go.dev/log#pkg-constants
//	usage in `constructor`: https://pkg.go.dev/log#New
//	example in: 04_printing_line_numbers_in_log_entries
const (
	red   = 1 << iota // 1 = 2^0 = (binary: 001)
	green             // 2 = 2^1 = (binary: 010)
	blue              // 4 = 2^2 = (binary: 100)
)

const (
	yellow = red | green        // 3 (binary: 011)
	purple = red | blue         // 5 (binary: 101)
	white  = red | green | blue // 7 (binary: 111)
)

func main() {
	fmt.Println("red:", red)     // 1 = 001
	fmt.Println("green:", green) // 2 = 010
	fmt.Println("blue:", blue)   // 4 = 100

	fmt.Println("yellow:", yellow) // 3 = red | green 			= 001 | 010 		=> 011
	fmt.Println("purple:", purple) // 5 = red | blue 			= 001 | 100 		=> 101
	fmt.Println("white:", white)   // 7 = red | green | blue	= 001 | 010 | 100	=> 111
}

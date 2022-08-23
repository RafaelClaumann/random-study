package main

import (
	"fmt"
	"os"
	"path/filepath"
	"strconv"
)

func main() {
	var floatString string = "4.54"

	var parsedFloat float64
	var err error
	parsedFloat, err = strconv.ParseFloat(floatString, 64)

	fmt.Println("error:", err)
	fmt.Println("parsedFloat:", parsedFloat)

	// https://pkg.go.dev/path/filepath#SplitList
	// https://pkg.go.dev/path/filepath#Join
	fmt.Printf("PathListSeparator: %q\n", os.PathListSeparator) // 58 unicode, ou seja, :

	path := "/a/b/c:/usr/bin:usr/bin/jdk:/var/lib/snapd/snap/bin:/usr/local/go/bin"
	splitedList := filepath.SplitList(path)
	fmt.Println("On Unix(Splited):", splitedList) // [/a/b/c /usr/bin usr/bin/jdk /var/lib/snapd/snap/bin /usr/local/go/bin]

	dir := "/user/local/bin"
	file := "java"
	joinedStrings := filepath.Join(dir, file)
	fmt.Println("On Unix(Joined):", joinedStrings) // /user/local/bin/java

}

// Bitwise or
// Applied in flags of log package:
//		definition: https://pkg.go.dev/log#pkg-constants
//		usage in `constructor`: https://pkg.go.dev/log#New
// 		example in: 04_printing_line_numbers_in_log_entries
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

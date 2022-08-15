package main

import (
	"fmt"
)

func main() {
	var resultado int = soma(5, 4)
	fmt.Printf("resultado00: %v\n", resultado)

	resultado01 := soma01(5, 4)
	fmt.Printf("resultado01: %v\n", resultado01)

	soma02(5, 4)

	var x, y = soma03(5, 4)
	fmt.Printf("resultado03: %v\t %v\n", x, y)

	var a, b = soma04(5, 4)
	fmt.Printf("resultado04: %v\t %v\n", a, b)

}

func soma(a int, b int) int {
	return a + b
}

func soma01(a, b int) (rslt int) {
	rslt = a + b
	return
}

func soma02(a, b int) {
	fmt.Printf("soma02: %v\n", a+b)
}

func soma03(a, b int) (int, error) {
	if a > b {
		return a + b, nil
	}
	return b, fmt.Errorf("erro")
}

func soma04(a, b int) (rtrn int, err error) {
	if a > b {
		rtrn, err = a, nil
		return
	}
	rtrn, err = b, fmt.Errorf("erro")
	return
}

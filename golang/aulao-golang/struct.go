package main

import (
	"fmt"
)

type Car struct {
	model string
	year  int32
}

func main() {
	var carro Car = Car{"fusca", 1973}
	changeYearPointer(&carro, 1974)
	fmt.Printf("resultado: %v\n", carro) // {fusca 1974)

	var carro02 Car = Car{"fusca", 1994}
	changeYearCopy(carro02, 1995)
	fmt.Printf("resultado: %v\n", carro02) // {fusca 1994}
}

func changeYearPointer(car *Car, yearParam int32) {
	car.year = yearParam
}

func changeYearCopy(car Car, yearParam int32) {
	car.year = yearParam
}

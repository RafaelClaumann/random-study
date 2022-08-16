package main

import (
	"fmt"
)

type Car struct {
	model string
	year  int32
}

func (car *Car) changeYear(year int32) {
	car.year = year
}

func main() {
	var carro Car = Car{"fusca", 1973}
	changeYearPointer(&carro, 1974)
	fmt.Printf("resultado: %v\n", carro) // {fusca 1974)

	carro.changeYear(1978)
	fmt.Printf("resultado: %v\n", carro) // {fusca 1978)

	var carro02 Car = Car{"fusca", 1994}
	changeYearCopy(carro02, 1995)
	fmt.Printf("resultado: %v\n", carro02) // {fusca 1994}

	var carro03 *Car = newCar("brasilia", 1992)
	fmt.Printf("resultado: %v\n", carro03) // {brasilia 1992}
}

func newCar(model string, year int32) *Car {
	var car Car = Car{model: model, year: year}
	return &car
}

func changeYearPointer(car *Car, yearParam int32) {
	car.year = yearParam
}

func changeYearCopy(car Car, yearParam int32) {
	car.year = yearParam
}

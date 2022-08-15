package main

import (
	"fmt"
	"reflect"
)

type Car struct {
	name  string
	model string
}

func main() {
	carro := Car{"fusca", "1500"}
	fmt.Println("Veiculo Original: ")
	fmt.Println("\t carro00 type: ", reflect.TypeOf(carro)) // main.Car
	fmt.Printf("\t carro00: { address: %p\t name: %v\t model: %v\t } \n", &carro, carro.name, carro.model)

	println()

	/*
		O endereço de carro02(&carro02) é diferente do endereço de carro(&carro).
		0 endereço armazenado em carro02 é o endereço do carro(&carro).
		Então (&carro02 != &carro) mas (carro02 == &carro).
		obs:  o compilador não deixa comparar &carro02 != &carro...
			  cannot compare &carro02 != &carro (mismatched types **Car and *Car)

		A atribuição (carro02 := &carro) é equivalente a (var carro02 *Car = &carro)

		* = create a pointer to a memory address
		& = get variable memory address
		carro02: { fusca, 1300 }
	*/
	fmt.Println("Primeira Alteração(ponteiros): ")
	var carro02 *Car = &carro
	carro.model = "1300"
	fmt.Println("\t carro02 type: ", reflect.TypeOf(carro02)) // *main.Car
	fmt.Printf("\t carro02: { address: %p\t name: %v\t model: %v\t } \n", &carro02, carro02.name, carro02.model)

	/*
		Alterações em `carro02` refletem em `carro` e vice-versa
		carro: { fusca, 1200 }
	*/
	fmt.Println("Segunda Alteração(ponteiros): ")
	carro02.model = "1200"
	fmt.Printf("\t carro00: { address: %p\t name: %v\t model: %v\t } \n", &carro, carro.name, carro.model)

	println()

	/*
		carro03 é uma cópia de `carro`
		carro = {fusca, 1200}

		Mudanças feitas em `carro` após a atribuição `carro03 := carro`
		não são refletidas em carro03.
	*/
	fmt.Println("Primeira Alteração(cópia): ")
	carro03 := carro
	carro.model = "1800"
	fmt.Println("\t carro03 type: ", reflect.TypeOf(carro03)) // main.Car
	fmt.Printf("\t carro03: { address: %p\t name: %v\t model: %v\t } \n", &carro03, carro03.name, carro03.model)

	fmt.Println("Carro00 Após Alteração da Cópia(carro03): ")
	carro03.model = "2054"
	fmt.Printf("\t carro00: { address: %p\t name: %v\t model: %v\t } \n", &carro03, carro03.name, carro03.model)
}

package main

import (
	models_alias "exporting/any_name" // alias "<go.mod_name>/<file_folder>"
	"fmt"
)

func main() {
	// implicit assignment to unexported field age in models.User literal
	// u := models.User{"rafael", 28}

	// createUser not exported by package models
	//u := models.createUser("rafael", 28)

	var user *models_alias.User = models_alias.NewUser("Rafael", 27)
	fmt.Println(user)
}

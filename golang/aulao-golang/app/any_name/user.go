package models

type User struct {
	Name string // exported, acessible in all packages
	age  int32  // unexported, acessibile within models package
}

// acessing unexported function `createUser`
func NewUser(name string, age int32) *User {
	var user User = createUser(name, age)
	return &user
}

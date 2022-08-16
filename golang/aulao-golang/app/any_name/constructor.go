package models

// acessing unexported field `age`
func createUser(name string, age int32) User {
	return User{name, age}
}

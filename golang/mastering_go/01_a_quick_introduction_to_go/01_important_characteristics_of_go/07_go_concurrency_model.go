package main

import (
	"fmt"
	"time"
)

func main() {
	/*
		A `goroutine` is the smallest executable Go entity. In order to create a new goroutine,
		you have to use the go keyword followed by a predefined function or an anonymous function.

		A `channel` in Go is a mechanism that, among other things, allows goroutines to
		communicate and exchange data.

		Although it is easy to create goroutines, there are other difficulties when dealing with
		concurrent programming including:
			- goroutine synchronization
			- sharing data between goroutine

		The main() runs as a goroutine and you do not want main() to finish before the other goroutines
		of the program because when main() exits, the entire program along with any goroutines that
		have not finished yet will terminate.
	*/

	/*
		Resultado esperado se fosse síncrono:
			0, 1, 2, 3, 4, 5
			1, 2, 3, 4, 5
			2, 3, 4, 5
			3, 4, 5
			4, 5

		Exemplo de resultado obtido:
			4, 5
			0, 1, 2, 3, 4, 5
			1, 2, 3, 4, 5
			2, 3, 4, 5
			3, 4, 5

		This happens because goroutines are initialized in random order and start running in random order.
		The Go scheduler is responsible for the execution of goroutines just like the OS scheduler is
		responsible for the execution of the OS threads.
		Chapter 7 presents the solution to that randomness issue with the use of a sync.WaitGroup variable.
	*/
	// Create 4 goroutines and prints some values on the screen using the myPrint() function
	// Go keyword is used for creating goroutines
	// Synchronizes goroutines using time.Sleep() calls (this is not the right way to synchronize goroutines).
	for i := 0; i < 5; i++ {
		go myPrint(i, 5)
	}
	time.Sleep(time.Second)
}

func myPrint(start, finish int) {
	for i := start; i <= finish; i++ {
		fmt.Print(i, " ")
	}
	fmt.Println()
	time.Sleep(100 * time.Microsecond)
}

package main

import (
	"log"
	"os"
)

func main() {
	/*
		log.Fatal() function is used when something erroneous has happened and you just want to exit
		your program as soon as possible after reporting that bad situation.
		The call to log.Fatal() terminates a Go program at the point where log.Fatal()
		was called after printing an error message.
		log.Fatal() calls log.Print() and then os.Exit(1), which is an immediate way
		of terminating the current program.

		There are situations where a program is about to fail for good and you want to have as much information
		about the failure as possible—log.Panic() implies that something really unexpected and unknown, such as
		not being able to find a file that was previously accessed or not having enough disk space, has happened.
		log.Panic() includes additional low-level information that, hopefully, will help you to resolve
		difficult situations that happened in your Go code.
		log.Panic() is equivalent to a call to log.Print() followed by a call to panic().
		panic() is a built-in function that stops the execution of the current function and begins panicking.

		go run 02_logging_bad_situations.go hello
		  2022/08/23 09:08:39 Fatal: Hello World!
		  exit status 1

		go run ./02_logging_bad_situations.go
		  2022/08/23 09:09:11 Panic: Hello World!
		  panic: Panic: Hello World!

		  goroutine 1 [running]:
		  log.Panic({0xc000104f60?, 0x0?, 0x0?})
				/usr/local/go/src/log/log.go:388 +0x65
		  main.main()
		    ~/mastering_go/1_a_quick_introduction_to_go/2_logging_information/02_logging_bad_situations.go:42 +0x85
		  exit status 2

	*/
	if len(os.Args) != 1 {
		log.Fatal("Fatal: Hello World!")
	}
	log.Panic("Panic: Hello World!")
}

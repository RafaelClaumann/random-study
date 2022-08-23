package main

import (
	"fmt"
	"log"
	"os"
	"path"
)

func main() {
	/*
		How to print the filename as well as the line number in the source file where the statement that
		wrote a log entry is located.
		The log.Lshortfile flag adds the filename as well as the line number of the Go statement that
		printed the log entry in the log entry itself. If you use log.Llongfile instead of log.Lshortfile,
		then you get the full path of the Go source file.

		https://pkg.go.dev/log#Ldate
			Ldate		// the date in the local time zone: 2009/01/23
			Lshortfile  // final file name element and line number: d.go:23. overrides Llongfile

		https://pkg.go.dev/log#SetFlags
			SetFlags sets the output flags for the standard logger. The flag bits are Ldate, Ltime, and so on.

		https://stackoverflow.com/a/35988536/15308818
	*/
	logDir := "/home/rafaelcb/Documentos/Projetos/random-study/golang/mastering_go/1_a_quick_introduction_to_go/2_logging_information"
	LOGFILE := path.Join(logDir, "04_mGo.log")
	//LOGFILE := path.Join(os.TempDir(), "04_mGo.log")

	file, err := os.OpenFile(LOGFILE, os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		fmt.Println(err)
		return
	}

	defer file.Close()
	LstdFlags := log.Ldate | log.Lshortfile // Ldate: 1 Lshortfile: 16
	iLog := log.New(file, "LNum ", LstdFlags)

	iLog.Println("Mastering Go, 3rd edition!")
	// LNum 2022/08/23 04_printing_line_numbers_in_log_entries.go:32: Mastering Go, 3rd edition!

	iLog.SetFlags(log.Lshortfile | log.LstdFlags)
	iLog.Println("Another log entry!")
	// LNum 2022/08/23 09:46:22 04_printing_line_numbers_in_log_entries.go:36: Another log entry!
	// pq passou a imprimir date + time ?
}

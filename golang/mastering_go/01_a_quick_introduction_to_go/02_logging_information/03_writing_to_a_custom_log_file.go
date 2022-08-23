package main

import (
	"fmt"
	"log"
	"os"
	"path"
)

func main() {
	/*
		The `defer` keyword tells Go to execute the statement just before the current function returns.
		This means that f.Close() is going to be executed just before main() returns.

		https://pkg.go.dev/os#OpenFile
			OpenFile is the generalized open call; most users will use Open or Create instead.
			It opens the named file with specified flag (O_RDONLY etc.).

		https://pkg.go.dev/os#TempDir
			TempDir returns the default directory to use for temporary files.
			On Unix systems, it returns $TMPDIR if non-empty, else /tmp.

		https://pkg.go.dev/log#New
			func New(out io.Writer, prefix string, flag int) *Logger
			New creates a new Logger. The out variable sets the destination to
			which log data will be written. The prefix appears at the beginning of
			each generated log line, or after the log header if the Lmsgprefix flag is provided.
			The flag argument defines the logging properties.
	*/

	logDir := "/home/rafaelcb/Documentos/Projetos/random-study/golang/mastering_go/1_a_quick_introduction_to_go/2_logging_information"
	LOGFILE := path.Join(logDir, "03_mGo.log")
	// LOGFILE := path.Join(os.TempDir(), "03_mGo.log")

	// The call to os.OpenFile() creates the log file for writing,
	// if it does not already exist, or opens it for writing
	// by appending new data at the end of it (os.O_APPEND)
	file, err := os.OpenFile(LOGFILE, os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		fmt.Println(err)
		return
	}

	defer file.Close()
	iLog := log.New(file, "iLog ", log.LstdFlags)
	iLog.Println("Hello there!")
	iLog.Println("Mastering Go 3rd edition!")
}

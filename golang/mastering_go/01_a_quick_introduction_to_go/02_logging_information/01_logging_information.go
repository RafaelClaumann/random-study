package main

import (
	"log"
	"log/syslog"
)

func main() {
	/*
		The log package of the standard Go library does not support working with logging levels.
		The log package sends log messages to standard error.
		By default log writes to standard error, the use of log.SetOutput() modifies that behavior.

		Writing to the main system log file is as easy as calling syslog.New() with the syslog.LOG_SYSLOG option.
		After that you need to tell your Go program that all logging information goes to the new logger—this is
		implemented with a call to the log.SetOutput() function.

		https://pkg.go.dev/log/syslog
		https://pkg.go.dev/log/syslog#New
		https://pkg.go.dev/log/syslog#Writer
		https://pkg.go.dev/log/syslog#Priority

		23/08/2022 08:55	systemLog.go	2022/08/23 08:55:09 Everything is fine!
	*/
	sysLog, err := syslog.New(syslog.LOG_SYSLOG, "systemLog.go")
	if err != nil {
		log.Println(err)
		return
	} else {
		log.SetOutput(sysLog)
		log.Print("Everything is fine!")
	}
}

package main

import (
	"fmt"
	"os"
	"path/filepath"
)

func main() {
	/*
		The first part is about reading the input argument, which is the name of the
		executable file that the utility will be searching for.

		The second part is about reading the PATH environment variable, splitting it,
		and iterating over the directories of the PATH variable.

		The third part is about looking for the desired binary file in these directories
		and determining whether it can be found or not, whether it is a regular file,
		and whether it is an executable file.

		If the desired executable file is found, the program terminates with the help of the return
		statement. Otherwise, it will terminate after the for loop ends and the main() function exits.

		https://pkg.go.dev/path/filepath#SplitList
		https://pkg.go.dev/path/filepath#Join
		https://pkg.go.dev/os#Stat
		https://pkg.go.dev/io/fs#FileInfo
		https://pkg.go.dev/io/fs#FileMode.IsRegular

		Linux File Permissions
			https://i.pinimg.com/originals/bd/07/23/bd0723cd16662381057722ea89a21edd.jpg
			https://pbs.twimg.com/media/FULaVQoUEAE4Unj.jpg:large

			Exemplo file permissions:
				- rwx r-x r-x

			Transformando em colunas para facilitar:
				-  					-> tipo de arquivo
				rwx	- bin: 111 		-> permissoes do owner(read, write, exec)
				r-x	- bin: 101		-> permissoes do grupo(read, exec)
				r-x	- bin: 101		-> permissoes de outros usuarios(read, exec)
	*/
	arguments := os.Args
	if len(arguments) == 1 {
		fmt.Println("Please provide an argument!")
		return
	}
	file := arguments[1]
	path := os.Getenv("PATH")
	pathSplit := filepath.SplitList(path) // splits a list of paths joined by the OS-specific ListSeparator.

	for _, directory := range pathSplit {
		fullPath := filepath.Join(directory, file)

		// Does it exist?
		fileInfo, err := os.Stat(fullPath)
		if err == nil {
			fmt.Println("#fileName:", fileInfo.Name(), "#filePath:", fullPath, "#fileMode:", fileInfo.Mode())
			mode := fileInfo.Mode()
			// Is it a regular file?
			if mode.IsRegular() {
				// Is it executable?
				// example_mode = -rwxr-xr-x = 0 111 101 101 = 755 = executable
				// example_mode&0111 = and bit-by-bit with first four bits, the first bit(0) is FileType.
				if mode&0111 != 0 {
					fmt.Println(fullPath)
					return
				}
			}
		}
	}
}

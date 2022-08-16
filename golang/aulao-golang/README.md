### Aulao Go Lang

[Go Lang: Desenvolvimento de APIs do zero](https://www.youtube.com/watch?v=645lRcyIXLc)

---

Primeira linha sempre deve informar o nome do "pacote", precisa ser o nome do diretório? [stackoverflow](https://stackoverflow.com/questions/38563990/what-is-the-purpose-of-the-package-declaration)

``` bash
# executa o código
go run ./main.go

# gera o binário
go build ./main.go
```

---

[documentacao golang](https://go.dev/doc/)

[documentacao pacote net/http](https://pkg.go.dev/net/http)

golang permite criar um webserver nativo usando bibliotecas(`net/http`) nativas da linguagem.

---

[documentacao fmt](https://pkg.go.dev/fmt)

[Learn Go Variables — A Visual Guide](https://blog.learngoprogramming.com/learn-go-lang-variables-visual-tutorial-and-ebook-9a061d29babe)

``` go
// declaracao curta
nome := "Rafael" 

// declaracao longa
var nome01 string = "Rafael01"

// declaracao bizarra
var nome02 string
nome02 = "Rafael02"
```

O compilador do go não deixa compilar um código com váriaveis declaras e não utilizadas.

### Valores Default
- boolean   - false
- floats    - 0.0
- integers  - 0
- string    - ""

---

[o que é error?](https://www.educative.io/answers/what-is-type-error-in-golang)

---
struct e ponteiros golang(1786cb7450e5abd5370c9b551fd1bbc35397e904)

[Como descobrir o tipo do objeto em golang?](https://stackoverflow.com/questions/20170275/how-to-find-the-type-of-an-object-in-go)

[O que são `&` e `*`?](https://stackoverflow.com/questions/38172661/what-is-the-meaning-of-and)

[How pointer & and * and ** works in Golang?](https://www.golangprograms.com/how-pointer-and-and-works-in-golang.html)

[Go by Example: Structs](https://gobyexample.com/structs)
 
---
structs, imports e modules golang(169c7c02f4e60df4766ebbf40636f2bf286d6b0c)

[Golang imports tutorial: how to import Golang local package | Golang tutorial](https://www.youtube.com/watch?v=Nv8J_Ruc280)

[Exported vs. Unexported Fields (Private vs Public)](https://riptutorial.com/go/example/1255/exported-vs--unexported-fields--private-vs-public-)

[Go struct - ZetCode](https://zetcode.com/golang/struct/)

Se o atributo da `struct` não iniciar com letra maiuscula ele não será exportado, o mesmo acontece paras as `funcs`. Sendo assim, `structs` e `funcs` que iniciam com letra minuscula são visiveis apenas no próprio `package`.

--- 

(Arrays golang)[https://linuxhint.com/initialize-array-golang/]

(Go by Example: Arrays)[https://gobyexample.com/arrays]

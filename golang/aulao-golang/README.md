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

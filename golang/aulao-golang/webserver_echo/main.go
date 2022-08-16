package main

import (
	"fmt"
	"log"
	"net/http"

	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"
)

type Car struct {
	Model string `json:"car_model"`
	Year  int16  `json:"car_year"`
}

var cars []Car = []Car{
	Car{Model: "fusca", Year: 1973},
	Car{Model: "SP2", Year: 1970},
}

func main() {
	e := echo.New()
	e.Use(middleware.LoggerWithConfig(middleware.LoggerConfig{
		Format: "time=${time_rfc3339}, method=${method}, uri=${uri}, status=${status}, error=${error}\n",
	}))

	e.GET("/", listCars)
	e.GET("/", getCar)             // QueryParameter - localhost:8080/?model=fusca
	e.GET("/:model", getCarByName) // PathVariable  - localhost:8080/fusca
	e.POST("/", createCar)

	log.Fatal(e.Start(":8080"))
}

func listCars(c echo.Context) error {
	return c.JSON(http.StatusOK, cars)
}

func createCar(c echo.Context) error {
	var car *Car = new(Car)
	var err error = c.Bind(car)
	if err != nil {
		fmt.Println(err)
		return err
	}
	cars = append(cars, *car)
	return c.JSON(http.StatusCreated, car)
}

func getCar(c echo.Context) error {
	var model_param string = c.QueryParam("model")
	var car Car = Car{model_param, 1970}
	return c.JSON(http.StatusOK, car)
}

func getCarByName(c echo.Context) error {
	model_param := c.Param("model")
	var car Car = Car{model_param, 1972}
	return c.JSON(http.StatusOK, car)
}

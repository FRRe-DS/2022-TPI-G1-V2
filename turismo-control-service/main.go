package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"math/rand"
	"net/http"
	"time"

	"github.com/gorilla/mux"

	_ "github.com/dimiro1/banner/autoload"
)

// operacion representa una operación de turismo
type operacion struct {
	ID            int       `json:"id"`
	CUIT          int64     `json:"cuit"`
	FechaCreacion time.Time `json:"fecha_creacion"`
	FechaInicio   time.Time `json:"fecha_incio"`
	FechaFin      time.Time `json:"fecha_fin"`
	Precio        float64   `json:"precio"`
	Aprobada      bool      `json:"aprobada"`
}

type allOperaciones []operacion

var operaciones = allOperaciones{}

func enableCors(w *http.ResponseWriter) {
	(*w).Header().Set("Access-Control-Allow-Origin", "*")
}

type operacion_request struct {
	CUIT        int64     `json:"cuit"`
	FechaInicio time.Time `json:"fecha_incio"`
	FechaFin    time.Time `json:"fecha_fin"`
	Precio      float64   `json:"precio"`
}

func createOperacion(w http.ResponseWriter, r *http.Request) {
	accept := r.Header.Get("accept")
	if "application/json" != accept {
		log.Print("Accept no válido: ", accept)
		w.WriteHeader(http.StatusNotAcceptable)
		return
	}

	contentType := r.Header.Get("content-type")
	if "application/json" != contentType {
		log.Print("Content-type no válido: ", contentType)
		w.WriteHeader(http.StatusUnsupportedMediaType)
		return
	}

	var operacionReq operacion_request
	reqBody, err := ioutil.ReadAll(r.Body)
	if err != nil {
		fmt.Fprintf(w, "Por favor ingrese bien los datos de la operación")
	}

	var randFloat32 = rand.Float32()
	var functiona bool = (randFloat32 > 0.3)

	if functiona {
		json.Unmarshal(reqBody, &operacionReq)

		log.Print("Creando Operacion: ", operacionReq)
		enableCors(&w)

		randFloat32 = rand.Float32()
		var approbado bool = (randFloat32 > 0.5)

		var newOperacion = operacion{
			ID:            len(operaciones),
			CUIT:          operacionReq.CUIT,
			FechaCreacion: time.Now(),
			FechaInicio:   operacionReq.FechaInicio,
			FechaFin:      operacionReq.FechaFin,
			Precio:        operacionReq.Precio,
			Aprobada:      approbado,
		}

		operaciones = append(operaciones, newOperacion)
		w.Header().Set("Content-Type", "application/json")
		w.WriteHeader(http.StatusCreated)

		json.NewEncoder(w).Encode(newOperacion)
	} else {
		w.WriteHeader(http.StatusInternalServerError)
	}

}

func main() {
	log.Print("Starting Turismo Control RESTful API!")
	router := mux.NewRouter().StrictSlash(true)

	router.HandleFunc("/operacion", createOperacion).Methods("POST")
	log.Fatal(http.ListenAndServe(":8080", router))
}

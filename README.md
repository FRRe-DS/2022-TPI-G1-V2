### 2022-TPI-G1<a name="index"></a>

# Indice
0. [Iniciemos](#iniciemos)
1. [Introduccion](#introduccion)
2. [Descripcion de problematica](#escenario)
3. [Arquitectura del proyecto](#arquitectura_del_proyecto)
4. [Modelo de negocio](#modelo_de_negocio) 
5. [Herramientas Utilizadas](#herramientas_utilizadas)
6. [APIs](#apis)
7. [Configuracion de enrutamiento](#configuracion_de_enrutamiento)
8. [Conclusion](#conclusion)
9. [Despedida](#despedida)

## Iniciemos :boom:<a name="iniciemos"></a>

Las siguientes instrucciones te permitiran tener una copia del proyecto funcionando en tu maquina local. En la seccion de **despliegue** tendrás
las instrucciones para desplegar instalar el proyecto. 

### Pre-Requisitos :technologist:

Aqui presentamos que cosas necesitas para correr la aplicacion. 
```
- MYSQL 8.0
- Java 11 o mayor.
- Maven 4.0.0
- Postman  
```

## Despliegue :computer:

- 1 Primero debemos crear la base de datos en mysql, la base de datos debe llamarse "tpidacsdb"
- 2 Segundo paso debemos ejecutar los servicios. Todos con el comando mvn spring:boot run. Se debe ejecutar en este orden:
-    1. Eureka server
-    2. Levantar cualquier servidor excepto admin-package-service (Este debe ejecutarse ultimo)
-    3. Luego levantar Gateway server
- 3 Ahora podemos utilizar las apis con postman, en el repositorio te dejamos los archivos para probar la API

## Autores :star_struck:

- Fernández Ian - *Desarrollador, Tester, Documentación* - :alien:[ianklebold](https://github.com/ianklebold)
- Rios Lucas - *Data Engineer, Cloud Engineer, Documentacion* - 😎[xlmriosx](https://github.com/xlmriosx)

## Introduccion<a name="introduccion"></a>

Este proyecto consiste en una aplicacion compuesta por APIs con realizadas en Java con el framework Spring, siguiendo una arquitectura de microservicios con disponibilidad multiplataforma para cualquier cliente con acceso a un navegador, se usaran Kubernets para correr los procesos y Docker como creador de imagenes, tendra una base de datos centralizada en la nube para todas las APIs, con LoadBalancer de Google y Eureka desde las APIs para cubrir la carga en las instancias.
Mostraremos la arquitectura para la aplicación elegida, los diagramas de entidad relación y las herramientas de desarrollo elegida.

## Escenario<a name="escenario"></a>

En vísperas al mundial de Qatar 2022 la empresa Fantastic Tour (FANTUR S.A.) ha solicitado
a los alumnos de la materia Desarrollo de Aplicaciones Cliente-Servidor el desarrollo de un
sistema para la venta y administración de paquetes turísticos.

El sistema debe permitir a los clientes registrar en forma electrónica, realizar consultas
de paquetes, reservar paquetes y abobar los mismo por diferentes medios (tarjetas de crédito
o otros sistemas de pago on-line) y enviar publicidad (via e-mail) a sus clientes.

La mayoría de los paquetes turísticos que la empresa comercializa están compuesto por pasajes
aéreos o en micro, estadía en hoteles, seguros médicos COVID-19 y entradas a espectáculos. La
aplicación debe contemplar el armado y cotización de estos paquetes turísticos por parte de
los administradores de la empresa, pudiendo establecerse cuales paquetes están disponibles o
hasta que fecha pueden adquirirse.

Debido a las imposiciones impuestas por los organismos de control que rigen la actividad del sector,
las agencias de turismos (incluida FANTUR) deben solicitar permisos al organismo de contralor antes de
confirmar a las operaciones a sus clientes. Este tipo de solicitudes deber ser realizar en forma on-line
y por medio de un web-service que el organismo provee.

---
#### Informacion del servicio

Este servicio no fue desarrollado por los alumnos de la cátedra Desarrollo de Aplicaciones 
Cliente-Servidor, por lo cual la tasa de error del mismo es aleatoria y deberá ser tenida en cuenta a la hora de utilizarlo.

---


*Contar con una aplicación para teléfonos móviles donde los usuarios puedan consultar u operar sería una*
*muy buena ventaja competitiva para esta empresa.*

--->[Index](#index)

## Consideraciones

Consideramos que para cada paquete creado por algún administrador en el sistema este deberá crearse las entidades las cuales componen dicho paquete que son, residencia y las habitaciones a las cuales hospedarán los clientes, la cobertura médica y los servicios que propone, los partidos del mundial y las entradas, por último el medio de viaje y los pasajes. 

## APIs identificadas<a name="apis_identificadas"></a>

SignUp and Security: Permite registrarse con un nombre de usuario/email y una constraseña que luego de ser introducida
es encriptada para mantener la confidencialidad. 

- Servicio de partidos de fútbol
- Servicio de cobertura médica
- Servicio de viajes
- Servicio de alojamiento
- Servicio de administración de paquetes
- Servicio de paquetes para el cliente
- Servicio de mail
- Servicio de formas de pago
- Servicio de sing up and login
- Servicio de seguridad

--->[Index](#index)

## Arquitectura del proyecto<a name="arquitectura_del_proyecto"></a> 

En este caso y viendo los nuevos paradigmas de la industria hemos optado utilizar una arquitectura de microservicios con una base de datos centralizada, desarrollado con la tecnología de Java en Spring boot. 
El servicio web seguirá una arquitectura de API REST a partir de microservicios. 
El producto sera puesto en un container y se administraran los servicios en Kubernetes los cuales podras ser accedidos mediante protocolo HTTPS esto permitiria que los clientes puedan consumir los servicios de la empresa desde cualquier dispositivo con acceso a internet.

La utilización de microservicios nos propone poder centrarnos en pequeñas aplicaciones, pequeños módulos o servicios que va componer mi aplicación completa. De tal manera que optamos por la realización de estos servicios: 

- Package Admin Service: Este servicio está realizado con el fin de brindar la posibilidad de crear paquetes, para esto es necesario tener en ejecución los demás servicios y consultarlos para añadirlos al paquete.

- Package Client Service: Permite obtener los paquetes creados por el Admin y ser adquiridos por el cliente.

- Payment Service: Permite en funcion del paquete seleccionado poder pagarlo.

- Health Service: Este servicio está realizado con el fin de permitir crear y consultar los servicios de cobertura médica para los paquetes. 

- Match Service: Este servicio está realizado con el fin de brindar la posibilidad de crear cada partido y cargar entradas. A su vez también se puede listar los partidos y consultar uno en particular. El administrador lo debe crear cuando quiere crear un paquete.

- Travel Service: Este servicio está realizado con el fin de brindar la posibilidad de crear viajes y sus pasajes. Los viajes pueden ser de vuelo o por otro medio. Estos luego pueden ser consultados para poder añadirlos a un paquete de viaje.

- Lodging Service: Este servicio está realizado con el fin de brindar la posibilidad de crear alojamientos y también las habitaciones. Estos luego podrán ser consultados y añadidos a cualquier paquete.

- User Login Service: Permite a un usuario con un rol determinado poder acceder a los servicios del negocio.

- Mail Service: Permite enviar al usuario emails con promociones y ofertas.

El servicio de administración de paquetes es el servicio utilizado por la adminitracion de pagina web, la misma se va a servir de otros servicios (Partidos de futbol, cobertura medica, viajes y alojamiento) las cuales tambien son utilizadas por los administradores del servicio web. EL servicio de mail será utilizado para notificar al cliente de distintos eventos y promociones de viajes pero la misma no repercute en nada con respecto al servicio de paquetes de administración de paquetes. El servicio de paquetes para el cliente, será el servicio que utilizará el cliente, donde podrá consultar y comprar los paquetes que necesite. El servicio de paquetes para el cliente se servirá del servicio de pago.

Como podemos ver, pensar en esta arquitectura nos lleva a poder individualizar cada módulo, haciéndolos trabajar de forma individual y separada, interactuando solo en algunas ocasiones. 

![image](https://user-images.githubusercontent.com/78567418/170382165-d67a1a76-d1eb-4a90-94dd-ca647357e204.png)

El API Gateway es la puerta de entrada, la cual se sirve del servicio de Login y Seguridad para permitir autenticar al usuario y conseguir el rol que este cumple dentro del sistema. De acuerdo al rol que cumple tendrá distintos permisos, lo cual le permitirá o no acceder a distintos servicios como por ejemplo, el ROL de administrador podrá acceder a todos los servicios, pero el cliente solo podrá acceder a los del paquete destinados al usuario. Una persona que no se encuentra autenticada podrá acceder al servicio de registro o SingUp y también al servicio de Login. 

--->[Index](#index)

## Modelo de negocio<a name="modelo_de_negocio"></a>

### Externo<a name="modelo_de_negocio_externo"></a> 

![image](https://user-images.githubusercontent.com/78567418/170507731-8ad96322-1df8-404c-a7a9-c69c6a378167.png)

--->[Index](#index)

### Modelo Físico

![8](https://user-images.githubusercontent.com/56406481/178039735-bcc47328-893a-46c1-880d-a4a16242f816.png)


--->[Index](#index)

## Herramientas utilizadas<a name="herramientas_utilizadas"/>

| Nombre | Utilidad | Version |
| :--- | :--- | :--- |
| ![Visual Studio Code](https://img.shields.io/badge/Visual_Studio_Code-007ACC?style=for-the-badge&logo=Visual-Studio-Code&logoColor=white) | `IDE` | |
| ![Java](https://img.shields.io/badge/Java-FF7800?style=for-the-badge&logo=Java&logoColor=white) | `Lenguaje de programacion` | `Version 11` |
| ![Spring - V 2.0.7](https://img.shields.io/badge/-Spring-green?style=for-the-badge&logo=Spring&logoColor=white) | `Framework` | `Version 2.0.7` |
| ![MySQL - V 8.0](https://img.shields.io/badge/-MySQL-007ACC?style=for-the-badge&logo=mysql&logoColor=white) | `Motor de base de datos` | `Version 8.0` |
| ![DBeaver](https://img.shields.io/badge/DBeaver-0D597F?style=for-the-badge&logo=behance&logoColor=white) | `Gestor de motores de bases detos` |  |
| ![GCP](https://img.shields.io/badge/GCP-4285F4?style=for-the-badge&logo=googlecloud&logoColor=white) | `Entorno cloud` |  |
| ![Maven](https://img.shields.io/badge/maven-000000?style=for-the-badge&logo=apachemaven&logoColor=white) | `Gestor de proyectos` |  |
| ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white) | `Sistema de control de versiones` |  |
| ![GitHub](https://img.shields.io/badge/-GitHub-181717?style=for-the-badge&logo=github) | `Plataforma de control de versiones` |  |


### Tecnologías de desarrollo<a name="tecnologias_de_desarrollo"/>

| Nombre |
| :--- |
| `Lombok` |
| `Spring JPA` |
| `Spring cloud` |
| `Eureka server y client` |
| `Gateway cloud` | 

--->[Index](#index)

## APIs<a name="apis"></a> 

1. [User Login Services API](#user_login_services_api)
2. [Package Admin Services API](#packages_admin_services_api)
3. [Package Client Services API](#packages_client_services_api)
4. [Payment Service API](#payment_service_api)
5. [Health Services API](#health_services_api)
6. [Match Services API](#match_services_api)
7. [Lodging Services API](#lodigin_services_api)
8. [Travel Services API](#travel_services_api)

--->[Index](#index)

---

### User Login Services API<a name="user_login_services_api"></a>

1. [Descripcion](#descripcion_user_login_services_api)
2. [Modelo Fisico](#modelo_fisico_user_login_services_api)
3. [Requests](#requests_user_login_services_api)

#### Descripcion<a name="descripcion_user_login_services_api"></a>

#### Modelo Fisico<a name="modelo_fisico_user_login_services_api"></a>

![image](https://user-images.githubusercontent.com/78567418/170410565-58cb716f-8929-40e0-aa25-93c69fe97efe.png)

#### Requests<a name="requests_user_login_services_api"></a>

--->[Index APIs](#apis)

---

### Package Admin Services API<a name="packages_admin_services_api"></a>

1. [Descripcion](#descripcion_packages_admin_services_api)
3. [Modelo Fisico](#modelo_fisico_packages_admin_services_api)
4. [Requests](#requests_packages_admin_services_api)

#### Descripcion<a name="descripcion_packages_admin_services_api"></a>

Este servicio está realizado con el fin de brindar la posibilidad de crear paquetes, para esto es necesario tener en ejecución los demás servicios y consultarlos para añadirlos al paquete.

#### Modelo Fisico<a name="modelo_fisico_packages_admin_services_api"></a>

![image](https://user-images.githubusercontent.com/78567418/170410823-8627f731-cebe-4bf7-a8bd-070a769df477.png)

#### Requests<a name="requests_packages_admin_services_api"></a>

Endpoint : `api/v1/admin/package`

##### Methods

###### POST

- Descripcion: CREATE PACKAGE

URL: DNS + `api/v1/admin/package`

Body:

```
"body": {
        "mode": "raw",
        "raw": "{\n    \"title\": \"Nuevo paquete para partido\",\n    \"cost\":500,\n    \"description\":\"Nuevo paquete para partido\",\n    \"contact\":\"viajes@gmail.com\",\n    \"matches\":[6]\n}",
        "options": {
            "raw": {
                "language": "json"
            }
        }
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 201 Created`

--->[Index Packages Admin Services](#requests_packages_admin_services_api)

###### GET

- Descripcion: GET ALL PACKAGES

URL: DNS + `api/v1/admin/package`

Response:

```
{
    id: {id1},	
    contact: {contact1},	
    cost: {cost1},	
    creation_date: {creation_date1},	
    description: {description1},	
    discount: {discount1},	
    lodging: {lodging1},	
    reserved: {reserved1},
    title: {title1},
    travel: {travel1},
    lodging: {lodging1},
    match : [{match1}, {match2}...]
},
{
    id: {id2},	
    contact: {contact2},	
    cost: {cost2},	
    creation_date: {creation_date2},	
    description: {description2},	
    discount: {discount2},	
    lodging: {lodging2},	
    reserved: {reserved2},
    title: {title2},
    travel: {travel2},
    lodging: {lodging1},
    match : [{match1}, {match2}...]
}, ...
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`



- Descripcion: GET PACKAGE BY ID

URL: DNS + `api/v1/admin/package/{id}`

Response:

```
{
    id: {id},	
    contact: {contact},	
    cost: {cost},	
    creation_date: {creation_date},	
    description: {description},	
    discount: {discount},	
    lodging: {lodging},	
    reserved: {reserved},
    title: {title},
    travel: {travel}
}
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`

--->[Index Packages Admin Services](#requests_packages_admin_services_api)

###### DELETE

Descripcion: DELETE PACKAGE BY ID

URL: DNS + `api/v1/admin/package/{id}`

Response:

```
{
    id: {id},	
    contact: {contact},	
    cost: {cost},	
    creation_date: {creation_date},	
    description: {description},	
    discount: {discount},	
    lodging: {lodging},	
    reserved: {reserved},
    title: {title},
    travel: {travel}
}
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`

--->[Index Packages Admin Services](#requests_packages_admin_services_api)

--->[Index APIs](#apis)


### Payment Service API<a name="payment_service_api"></a>

1. [Descripcion](#descripcion_payment_service_api)
3. [Modelo Fisico](#modelo_fisico_payment_service_api)
4. [Requests](#requests_payment_service_api)

#### Descripcion<a name="descripcion_payment_service_api"></a>

#### Modelo Fisico<a name="modelo_fisico_payment_service_api"></a>

#### Requests<a name="requests_payment_service_api"></a>

##### Methods

###### POST

--->[Index Package Client Services](#payment_service_api)

###### GET

--->[Index Package Client Services](#payment_service_api)

###### DELETE

--->[Index Package Client Services](#payment_service_api)

--->[Index APIs](#apis)

---

### Health Services API<a name="health_services_api"></a>

1. [Descripcion](#descripcion_health_services_api)
3. [Modelo Fisico](#modelo_fisico_health_services_api)
4. [Requests](#requests_health_services_api)

#### Descripcion<a name="descripcion_health_services_api"></a>

#### Modelo Fisico<a name="modelo_fisico_health_services_api"></a>

![image](https://user-images.githubusercontent.com/78567418/170505187-ce2f04a7-bc79-403d-9be3-3b2655f6bc7d.png)

#### Requests<a name="requests_health_services_api"></a>

##### Methods

###### POST

- Descripcion: CREATE HEALTH INSURANCE

URL: DNS + `/api/v1/health`

Body:

```
"body": {
        "mode": "raw",
        "raw": "{\n    \"description\":\"Este es un servicio de salud\",\n    \"services\":[1,2,3]\n}",
        "options": {
            "raw": {
                "language": "json"
            }
        }
    },
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 201 Created`

--->[Index Health Services](#health_services_api)

###### GET

- Descripcion: GET HEALTH INSURANCE

URL: DNS + `/api/v1/health`

Response:

```
{
    id: {id}
    description: {description}
},
{
    id: {id2}
    description: {description2}
}, ...
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`



- Descripcion: GET HEALTH INSURANCE BY ID

URL: DNS + `/api/v1/health/{id}`

Response:

```
{
    id: {id}
    description: {description}
}
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`



- Descripcion: GET SERVICES

URL: DNS + `/api/v1/health/services`

Response:

```
{
    id: {id}
    description: {description}
},
{
    id: {id2}
    description: {description2}
}, ...
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`

--->[Index Health Services](#health_services_api)

###### DELETE

Descripcion: DELETE  HEALTH INSURANCE BY ID

URL: DNS + `/api/v1/health/{id}`

Response:

```
{
    id: {id}
    description: {description}
}
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`

--->[Index Health Services](#health_services_api)

--->[Index APIs](#apis)

---

### Match Services API<a name="match_services_api"></a>

1. [Descripcion](#descripcion_match_services_api)
3. [Modelo Fisico](#modelo_fisico_match_services_api)
4. [Requests](#requests_match_services_api)

#### Descripcion<a name="descripcion_match_services_api"></a>

Este servicio está realizado con el fin de brindar la posibilidad de crear cada partido y cargar entradas. A su vez también se puede listar los partidos y consultar uno en particular. El administrador lo debe crear cuando quiere crear un paquete.

#### Modelo Fisico<a name="modelo_fisico_match_services_api"></a>

![image](https://user-images.githubusercontent.com/78567418/170411093-285bf887-b366-4853-b78d-4ef83fd76b36.png)

#### Requests<a name="requests_match_services_api"></a>

Endpoint: `api/v1/match`

##### Methods

###### POST

- Descripcion: CREATE MATCHES WITH TICKETS

URL: DNS + `/api/v1/match`

Body:

```
"body": {
        "mode": "raw",
        "raw": "{\n    \"vistTeam\":\"Senegal\",\n    \"localTeam\":\"Ecuador\",\n    \"matchDate\":\"2022-11-29\",\n    \"matchTime\":\"19:00\",\n    \"stadium\":\"Estadio Internacional Khalifa\",\n    \"listTickets\":[\n        {\n            \"position\" : \"Popular\",\n            \"cost\":500.00,\n            \"count\":2\n        },\n        {\n            \"position\" : \"Medio\",\n            \"cost\":200.00,\n            \"count\":1\n        }\n    ]\n}",
        "options": {
            "raw": {
                "language": "json"
            }
        }
    },
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 201 Created`

--->[Index Match Services](#match_services_api)

###### GET

- Descripcion: GET ALL MATCHES

URL: DNS + `/api/v1/match`

Response:

```
{
    id: {id1},
    local_team: {local_team1},
    match_date: {match_date1},
    match_time: {match_time1},
    stadium: {stadium1},
    vist_team: {vist_team1}
},
{
    id: {id2},
    local_team: {local_team2},
    match_date: {match_date2},
    match_time: {match_tim2},
    stadium: {stadium2},
    vist_team: {vist_team2}
}, ...
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`



- Descripcion: GET MATCH BY ID

URL: DNS + `/api/v1/match/{id}`

Response:

```
{
    id: {id},
    local_team: {local_team},
    match_date: {match_date},
    match_time: {match_time},
    stadium: {stadium},
    vist_team: {vist_team}
}
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`



- Descripcion: GET TICKETS BY ID MATCH

URL: DNS + `/api/v1/match/{id}/ticket`

```
{
    id: {id1},
    buyed: {buyed1},
    cost: {cost1},
    position: {position1},
    matchgame_id: {matchgame_id}  
},
{
    id: {id2},
    buyed: {buyed2},
    cost: {cost2},
    position: {position2},
    matchgame_id: {matchgame_id} 
}, ...
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`

--->[Index Match Services](#match_services_api)

###### DELETE

Descripcion: DELETE MATCH BY ID

URL: DNS + `/api/v1/match/{id}`

Response:

```
{
    id: {id},
    local_team: {local_team},
    match_date: {match_date},
    match_time: {match_time},
    stadium: {stadium},
    vist_team: {vist_team}
}
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`

--->[Index Match Services](#match_services_api)

--->[Index APIs](#apis)

---

### Lodging Services API<a name="lodigin_services_api"></a>

1. [Descripcion](#descripcion_lodigin_services_api)
3. [Modelo Fisico](#modelo_fisico_lodigin_services_api)
4. [Requests](#requests_lodigin_services_api)

#### Descripcion<a name="descripcion_lodigin_services_api"></a>

Este servicio está realizado con el fin de brindar la posibilidad de crear alojamientos y también las habitaciones. Estos luego podrán ser consultados y añadidos a cualquier paquete.

#### Modelo Fisico<a name="modelo_fisico_lodigin_services_api"></a>

![image](https://user-images.githubusercontent.com/78567418/170410920-8c11ad8a-29c5-48b5-b472-2250a430dfb6.png)

#### Requests<a name="requests_lodigin_services_api"></a>

Endpoint: `api/v1/lodging`

##### Methods

###### POST

- Descripcion: CREATE LODGING

URL: DNS + `/api/v1/lodging`

Body:

```
"body": {
        "mode": "raw",
        "raw": "{\n    \"nameHotel\":\"Hotel california\",\n    \"localization\":\"Calle falsa 123\",\n    \"contact\":\"hotelCalifornia@servicios.com\",\n    \"description\":\"Este es un hotel muy destacado\",\n    \"listRooms\":[\n        {\n        \"numberRoom\":10,\n        \"occupancy\":4,\n        \"service\":\"Tenemos servicios de tipo 2\"\n        }\n    ]\n}",
        "options": {
            "raw": {
                "language": "json"
            }
        }
    },
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 201 Created`

--->[Index Lodging Services](#lodigin_services_api)

###### GET

- Descripcion: GET ALL LODGINGS

URL: DNS + `/api/v1/lodging`

Response:

```
{
    id: {id1},
    contact: {contact1},
    description: {description1},
    localization: {localization1},
    hotel: {hotel1},
    rating: {rating1}
},
{
    id: {id2},
    contact: {contact2},
    description: {description2},
    localization: {localization2},
    hotel: {hotel2},
    rating: {rating2}
}, ...
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`



- Descripcion: GET LODGING BY ID

URL: DNS + `/api/v1/lodging/{id}`

Response:

```
{
    id: {id},
    contact: {contact},
    description: {description},
    localization: {localization},
    hotel: {hotel},
    rating: {rating}
}
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`

--->[Index Lodging Services](#lodigin_services_api)

###### DELETE

Descripcion: DELETE LODGING BY ID

URL: DNS + `/api/v1/lodging/{id}`

Response:

```
{
    id: {id},
    contact: {contact},
    description: {description},
    localization: {localization},
    hotel: {hotel},
    rating: {rating}
}
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`

--->[Index Lodging Services](#lodigin_services_api)

--->[Index APIs](#apis)

---

### Travel Services API<a name="travel_services_api"></a>

1. [Descripcion](#descripcion_travel_services_api)
3. [Modelo Fisico](#modelo_fisico_travel_services_api)
4. [Requests](#requests_travel_services_api)

#### Descripcion<a name="descripcion_travel_services_api"></a>

#### Modelo Fisico<a name="modelo_fisico_travel_services_api"></a>

![image](https://user-images.githubusercontent.com/78567418/170411263-bb82e83b-c20a-4f6a-8ba9-52637634a60b.png)

#### Requests<a name="requests_travel_services_api"></a>

Endpoint: `api/v1/travel`

##### Methods

###### POST

- Descripcion: CREATE TRAVEL

URL: DNS + `/api/v1/travel`

Body:

```
"body": {
        "mode": "raw",
        "raw": "{\n    \"descripcion\":\"El mejor servicio de viaje\", \n    \"travelTime\" : \"5 horas de viaje\",\n    \"travelDate\" : \"2022-11-27\",\n    \"travelHour\" : \"18:00 horario argentino\",\n    \"localization\" : \"Aeropuerto argentino\",\n    \"service\" : \"Servicio de clase 3\",\n    \"type\" : \"Viaje en avion\",\n    \"company\" : \"Aerolineas argentinas\",\n    \"tickets\":[\n        {\n            \"numberTravel\": 1,\n            \"position\" : \"Asiento A2\"\n        },\n        {\n            \"numberTravel\": 2,\n            \"position\" : \"Asiento A4\"\n        },\n        {\n            \"numberTravel\": 3,\n            \"position\" : \"Asiento A5\"\n        }\n    ]\n}",
        "options": {
            "raw": {
                "language": "json"
            }
        }
    },
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 201 Created`

--->[Index Travel Services](#travel_services_api)

###### GET

- Descripcion: GET ALL TRAVELS

URL: DNS + `/api/v1/travel`

Response:

```
{
    id: {id1},
    company: {company1},
    descripcion: {descripcion1},
    localization: {localization1},
    rating: {rating1},
    service: {service1},
    traveldate: {traveldate1},
    travelhour: {travelhour1},
    traveltime: {traveltime1},
    type: {type1}
},
{
    id: {id2},
    company: {company2},
    descripcion: {descripcion2},
    localization: {localization2},
    rating: {rating2},
    service: {service2},
    traveldate: {traveldate2},
    travelhour: {travelhour2},
    traveltime: {traveltime2},
    type: {type2}
}, ...
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`



- Descripcion: GET TRAVEL BY ID

URL: DNS + `/api/v1/travel/{id}`

Response:

```
{
    id: {id},
    company: {company},
    descripcion: {descripcion},
    localization: {localization},
    rating: {rating},
    service: {service},
    traveldate: {traveldate},
    travelhour: {travelhour},
    traveltime: {traveltime},
    type: {type}
}
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`

--->[Index Travel Services](#travel_services_api)

###### DELETE

Descripcion: DELETE TRAVEL BY ID

URL: DNS + `/api/v1/travel/{id}`

Response:

```
{
    id: {id},
    company: {company},
    descripcion: {descripcion},
    localization: {localization},
    rating: {rating},
    service: {service},
    traveldate: {traveldate},
    travelhour: {travelhour},
    traveltime: {traveltime},
    type: {type}
}
```

Para que la accion sea correcta se necesita que el status sea el siguiente: `STATUS: 200 OK`

--->[Index Travel Services](#travel_services_api)

--->[Index APIs](#apis)

---

### Package Client Service <a name="package_client_service_api"></a>

1. [Descripcion](#descripcion_package_cliente_services_api)
2. [Requests](#requests_package_cliente_services_api)

#### Descripcion<a name="descripcion_package_cliente_services_api"></a>
Esta API se sirve de la API de paquetes que es manejada por un administrador. Su principal funcionalidad es permitir al cliente ver los paquetes cargados y disponibles en el sistema, a su vez de permitirle comprar/reservar un paquete

#### Requests<a name="requests_package_cliente_services_api"></a>
Endpoint: `/api/v1/fantur/`

##### Methods

###### GET

- Descripcion: GET ALL PACKAGES

URL: DNS + `/api/v1/fantur/packages`

Response:
```
{
    id: {id1},	
    contact: {contact1},	
    cost: {cost1},	
    creation_date: {creation_date1},	
    description: {description1},	
    discount: {discount1},	
    lodging: {lodging1},	
    reserved: {reserved1},
    title: {title1},
    travel: {travel1},
    lodging: {lodging1},
    match : [{match1}, {match2}...]
},
{
    id: {id2},	
    contact: {contact2},	
    cost: {cost2},	
    creation_date: {creation_date2},	
    description: {description2},	
    discount: {discount2},	
    lodging: {lodging2},	
    reserved: {reserved2},
    title: {title2},
    travel: {travel2},
    lodging: {lodging1},
    match : [{match1}, {match2}...]
}, ...
```
###### PUT

- Descripcion: BUY PACKAGE, UPDATE STATE PAYMENT

URL: DNS + `/api/v1/fantur/payment/{id_payment}/card/{id_card}`

Response:

```
{
    id: {id},
    amount : {amount}
    paymentDate : {paymentDate}
    paymentId : {paymentId}
}
```

## Configuracion de enrutamiento<a name="configuracion_de_enrutamiento"/>

![2](https://user-images.githubusercontent.com/56406481/178035308-e8a2f1a4-fcb8-42da-badb-ad3f870b937c.png)

## Configuracion de docker<a name="configuracion_de_docker"/>
```
--> docker pull mysql:8

--> docker run -p 3307:3306 --name=springcloud-mysql8 --network springcloud -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=tpidacsdb -d mysql:8 

--> docker logs -f springcloud-mysql8
```

```
Health Service 

--> docker build -t service-health-insurance:v1 .

--> docker run -p 8003:8003 --name=service-health-insurance --network springcloud service-health-insurance:v1
```

```
Lodging Service

--> docker build -t lodging-service:v1 .

--> docker run -p 8005:8005 --name=lodging-service --network springcloud lodging-service:v1
```


```
Matches Service

--> docker build -t match-service:v1 .

--> docker run -p 8001:8001 --name=match-service --network springcloud match-service:v1
```

```
Payment Service


--> docker build -t payment-service:v1 .

--> docker run -p 8007:8007 --name=payment-service --network springcloud payment-service:v1
```

```
Travel Service

--> docker build -t travel-service:v1 .

--> docker run -p 8004:8004 --name=travel-service --network springcloud travel-service:v1
```

```
Admin package Service

--> docker build -t package-admin-service:v1 .

--> docker run -p 8002:8002 --name=package-admin-service --network springcloud package-admin-service:v1
```

```
Client package Service

--> docker build -t package-client-service:v1 .

--> docker run -p 8009:8009 --name=package-client-service --network springcloud package-client-service:v1
```

```
Zull Gateway Service

--> docker build -t zull-server:v1 .

--> docker run -p 8090:8090 --name=zull-server --network springcloud zull-server:
```

--->[Index](#index)

![Screenshot from 2022-07-08 02-59-17](https://user-images.githubusercontent.com/56406481/178038500-b8e89332-3495-49d9-919f-d7c374f7be1b.png)


## Conclusion<a name="conclusion"/>

Gracias a este trabajo logramos interiorizarnos en nuestra nueva arquitectura de desarrollo, pudiendo comprender sus ventajas y desventajas, aprendiendo a implementar nuevas tecnologías de desarrollo. Todavía quedan pendientes algunos servicios y llevar este proyecto backend al siguiente nivel que es implementar seguridad en las aplicaciones, persistencia en la nube y virtualizar a partir de docker las aplicaciones desarrolladas.  

--->[Index](#index)

## Despedida<a name="despedida"/>

Fue un gusto trabajar en este proyecto y compartir nuestros conocimientos. Con :heart: Por :alien:[ianklebold](https://github.com/ianklebold) y 😎[xlmriosx](https://github.com/xlmriosx)

--->[Index](#index)



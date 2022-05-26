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
-   a. Eureka server
-   b. Levantar cualquier servidor excepto admin-package-service (Este debe ejecutarse ultimo)
-   c. Luego levantar Gateway server
- 3 Ahora podemos utilizar las apis con postman, en el repositorio te dejamos los archivos para probar la API

## Documentacion :neckbeard:

- [Click aquí para la documentacion](https://docs.google.com/document/d/1wGC4wTk7F5qkzgaWLeb7Qw4DiPhNnDUku-vDG0EsHfg/edit?usp=sharing)

## Autores :star_struck:

- Fernández Ian - *Desarrollador, Tester, Documentación* - :alien:[ianklebold](https://github.com/ianklebold)
- Rios Lucas - *Ingeniero de datos, Documentacion* - 😎[xlmriosx](https://github.com/xlmriosx)

## Introduccion<a name="introduccion"></a>

Este proyecto consiste en una aplicacion compuesta por APIs con realizadas en Java con
el framework Spring, siguiendo una arquitectura de microservicios con disponibilidad multiplataforma
para cualquier cliente con acceso a un navegador, se usaran Kubernets para correr los procesos
y Docker como creador de imagenes, tendra una base de datos centralizada en la nube para todas
las APIs, con LoadBalancer de Google y Eureka desde las APIs para cubrir la carga en las instancias.

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

## APIs identificadas<a name="apis_identificadas"></a>

SignUp and Security: Permite registrarse con un nombre de usuario/email y una constraseña que luego de ser introducida
es encriptada para mantener la confidencialidad. 

- Package Admin Service: Este servicio está realizado con el fin de brindar la posibilidad de crear paquetes, para esto es necesario tener en ejecución los demás servicios y consultarlos para añadirlos al paquete.

- Package Client Service: Permite obtener los paquetes creados por el Admin y ser adquiridos por el cliente.

- Payment Service: Permite en funcion del paquete seleccionado poder pagarlo.

- Health Service: Este servicio está realizado con el fin de permitir crear y consultar los servicios de cobertura médica para los paquetes. 

- Match Service: Este servicio está realizado con el fin de brindar la posibilidad de crear cada partido y cargar entradas. A su vez también se puede listar los partidos y consultar uno en particular. El administrador lo debe crear cuando quiere crear un paquete.

- Travel Service: Este servicio está realizado con el fin de brindar la posibilidad de crear viajes y sus pasajes. Los viajes pueden ser de vuelo o por otro medio. Estos luego pueden ser consultados para poder añadirlos a un paquete de viaje.

- Lodging Service: Este servicio está realizado con el fin de brindar la posibilidad de crear alojamientos y también las habitaciones. Estos luego podrán ser consultados y añadidos a cualquier paquete.

- User Login Service: Permite a un usuario con un rol determinado poder acceder a los servicios del negocio.

- Mail Service: Permite enviar al usuario emails con promociones y ofertas.


## Arquitectura del proyecto<a name="arquitectura_del_proyecto"></a> 

En este caso y viendo los nuevos paradigmas de la industria hemos optado utilizar una arquitectura de 
microservicios con una base de datos centralizada.
El producto sera puesto en un container y se administraran los servicios en Kubernetes los cuales 
podras ser accedidos mediante protocolo HTTPS esto permitiria que los clientes puedan consumir los
servicios de la empresa desde cualquier dispositivo con acceso a internet.

![image](https://user-images.githubusercontent.com/78567418/170382165-d67a1a76-d1eb-4a90-94dd-ca647357e204.png)

## Modelo de negocio<a name="modelo_de_negocio"></a>

### Externo<a name="modelo_de_negocio_externo"></a> 

![image](https://user-images.githubusercontent.com/78567418/169663351-f4dc7a31-1e23-4d43-8f8c-07ba2834993d.png)

### Modelo Físico

![Vista desde Dbeaver](https://user-images.githubusercontent.com/56406481/170394286-b86ffd55-a8fb-4f2b-a3e4-88d5af509b62.png)

## Herramientas utilizadas<a name="herramientas_utilizadas"/>

| Nombre | Utilidad | Version |
| :--- | :--- | :--- |
| ![Visual Studio Code](https://img.shields.io/badge/Visual_Studio_Code-007ACC?style=for-the-badge&logo=Visual-Studio-Code&logoColor=white) | `IDE` | |
| ![Java](https://img.shields.io/badge/Java-FF7800?style=for-the-badge&logo=Visual-Studio-Code&logoColor=white) | `Lenguaje de programacion` | `Version 11` |
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


## APIs<a name="apis"></a> 

1. [User Login Services API](#user_login_services_api)
2. [Package Admin Services API](#packages_admin_services_api)
3. [Package Client Services API](#packages_client_services_api)
4. [Payment Service API](#payment_service_api)
5. [Health Services API](#health_services_api)
6. [Match Services API](#match_services_api)
7. [Lodging Services API](#lodigin_services_api)
8. [Travel Services API](#travel_services_api)

---

### User Login Services API<a name="user_login_services_api"></a>

1. [Descripcion](#descripcion_user_login_services_api)
2. [Modelo Fisico](#modelo_fisico_user_login_services_api)
3. [Requests](#requests_user_login_services_api)

#### Descripcion<a name="descripcion_user_login_services_api"></a>

#### Modelo Fisico<a name="modelo_fisico_user_login_services_api"></a>

![image](https://user-images.githubusercontent.com/78567418/170410565-58cb716f-8929-40e0-aa25-93c69fe97efe.png)

#### Requests<a name="requests_user_login_services_api"></a>

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

---

### Package Client Services API<a name="packages_client_services_api"></a>

1. [Descripcion](#descripcion_packages_client_services_api)
3. [Modelo Fisico](#modelo_fisico_packages_client_services_api)
4. [Requests](#requests_packages_client_services_api)

#### Descripcion<a name="descripcion_packages_client_services_api"></a>

#### Modelo Fisico<a name="modelo_fisico_packages_client_services_api"></a>

#### Requests<a name="requests_packages_client_services_api"></a>

---

### Payment Service API<a name="payment_service_api"></a>

1. [Descripcion](#descripcion_payment_service_api)
3. [Modelo Fisico](#modelo_fisico_payment_service_api)
4. [Requests](#requests_payment_service_api)

#### Descripcion<a name="descripcion_payment_service_api"></a>

#### Modelo Fisico<a name="modelo_fisico_payment_service_api"></a>

#### Requests<a name="requests_payment_service_api"></a>

---

### Health Services API<a name="health_services_api"></a>

1. [Descripcion](#descripcion_health_services_api)
3. [Modelo Fisico](#modelo_fisico_health_services_api)
4. [Requests](#requests_health_services_api)

#### Descripcion<a name="descripcion_health_services_api"></a>

#### Modelo Fisico<a name="modelo_fisico_health_services_api"></a>

#### Requests<a name="requests_health_services_api"></a>

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

---

### Travel Services API<a name="travel_services_api"></a>

1. [Descripcion](#descripcion_travel_services_api)
3. [Modelo Fisico](#modelo_fisico_travel_services_api)
4. [Requests](#requests_travel_services_api)

#### Descripcion<a name="descripcion_travel_services_api"></a>

#### Modelo Fisico<a name="modelo_fisico_travel_services_api"></a>

![image](https://user-images.githubusercontent.com/78567418/170411263-bb82e83b-c20a-4f6a-8ba9-52637634a60b.png)

#### Requests<a name="requests_travel_services_api"></a>

---

## Configuracion de enrutamiento<a name="configuracion_de_enrutamiento"/>

![image](https://user-images.githubusercontent.com/78567418/170409867-2dac7dbe-6dff-40f2-9c9a-8da50c89bd96.png)

## Despedida

Fue un gusto trabajar en este proyecto y compartir nuestros conocimientos. Con :heart: Por :alien:[ianklebold](https://github.com/ianklebold) y 😎[xlmriosx](https://github.com/xlmriosx)

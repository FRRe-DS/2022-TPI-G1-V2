# DESARROLLO DE APLICACIONES CLIENTE SERVIDOR -  TPI 2022 - GRUPO 1
Aqui presentamos el proyecto para el TPI de cliente servidor 

## Iniciemos :boom:

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

## Construido con :neckbeard:

- [MYSQL 8.0](https://www.postgresql.org/download/) - Base de datos
- [Dbeaver-ce](https://dbeaver.io/download/) - Herramienta de administracion de datos 
- [DbVisualizer](https://www.dbvis.com/) - Herramienta de administracion de datos 
- [Java 11](https://www.oracle.com/ar/java/technologies/javase/jdk11-archive-downloads.html) - Lenguaje de programacion
- [Maven 4.0.0](https://maven.apache.org/index.html) - Manejador de dependencias
- [Spring-Boot](https://spring.io/projects/spring-boot) - Framework


### Capa de datos (Modelo entidad relacion)
![Vista desde Dbeaver](https://user-images.githubusercontent.com/56406481/170394286-b86ffd55-a8fb-4f2b-a3e4-88d5af509b62.png)

## Documentacion :neckbeard:

- [Click aquí para la documentacion](https://docs.google.com/document/d/1wGC4wTk7F5qkzgaWLeb7Qw4DiPhNnDUku-vDG0EsHfg/edit?usp=sharing)

## Autores :star_struck:

- Fernández Ian - *Desarrollador, Tester, Documentación* - :alien:[ianklebold](https://github.com/ianklebold)
- Rios Lucas - *Ingeniero en datos, Documentacion* _:alien:[xlmriosx](https://github.com/xlmriosx)

## Despedida

Fue un gusto trabajar en este proyecto y compartir nuestros conocimientos. Con :heart: Por :alien:[ianklebold](https://github.com/ianklebold) y :alien:[xlmriosx](https://github.com/xlmriosx)

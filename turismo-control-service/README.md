![Turismo Buils](https://github.com/FRRe-DACS/turismo-control/actions/workflows/makefile.yml/badge.svg)

# Turismo Control

Servicio de la Agencia de Control de Operaciones de Turismo

## Construir la imagen de Docker

```console
make docker
```

La imagen se publica en [Docker Hub](https://hub.docker.com/repository/docker/frredacs/turismo-control).

## Iniciar el Servicio

```bash
docker run -d -p 8080:8080 frredacs/turismo-control:1.2
```

## Llamar al servicio

```bash
curl --location --request POST 'http://localhost:8080/operacion' \
--header 'Content-Type: application/json' \
--data-raw '{
    "cuit": 20284435215,
    "fecha_incio": "2022-04-23T11:11:43.7635-03:00",
    "fecha_fin": "2022-04-23T11:11:43.7635-03:00",
    "precio": 10000
}'
```

Resultado

```json
{
    "id": 11,
    "cuit": 20284435215,
    "fecha_creacion": "2022-04-23T11:12:30.407218-03:00",
    "fecha_incio": "2022-04-23T11:11:43.7635-03:00",
    "fecha_fin": "2022-04-23T11:11:43.7635-03:00",
    "precio": 10000,
    "aprobada": true
}
```

## Detener el servicio

```bash
docker ps

ONTAINER ID   IMAGE                          COMMAND       CREATED          STATUS          PORTS                    NAMES
48d0277ced7c   frredacs/turismo-control:1.0   "./turismo"   22 seconds ago   Up 21 seconds   0.0.0.0:8080->8080/tcp   wizardly_poitras
```

```bash 
docker stop wizardly_poitras
docker rm wizardly_poitras
```

FROM golang:1.17 as builder
RUN mkdir /build 
ADD . /build/
WORKDIR /build 
RUN go get -v -d && CGO_ENABLED=0 GOOS=linux go build -a -installsuffix cgo -ldflags '-extldflags "-static"' -o turismo .
FROM scratch
COPY --from=builder /build/turismo /app/
COPY ./banner.txt /app/
WORKDIR /app
CMD ["./turismo"]
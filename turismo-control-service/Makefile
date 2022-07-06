SERVER_OUT=bin/turismo
BANNER=banner.txt
BANNER_OUT=bin/banner.txt
PKG := "github.com/FRRe-DACS/turismo-control"
DOCKER_TAG=frredacs/turismo-control:1.2

.PHONY: docker

dep: ## Get the dependencies
	@go get -v -d ./...
copy_banner:

server: dep 
	@go build -i -v -o $(SERVER_OUT) && cp $(BANNER) $(BANNER_OUT)

docker:
	@docker build -t $(DOCKER_TAG) .
	docker tag $(DOCKER_TAG) latest

publish:
	@docker push $(DOCKER_TAG)
	docker push latest

clean: ## Remove previous builds
	@rm $(SERVER_OUT) $(BANNER_OUT)
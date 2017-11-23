.PHONY: help dev bootRun build-local build-and-run

default: help

help: ## Show this help
	@echo "Setlist Creator"
	@echo "======================"
	@echo
	@echo "An application to get a probable setlist for an artist"
	@echo
	@fgrep -h " ## " $(MAKEFILE_LIST) | fgrep -v fgrep | sed -Ee 's/([a-z.]*):[^#]*##(.*)/\1##\2/' | column -t -s "##"

dev: ## run continous build for code changes and keep your server running
	make -j2 build-local bootRun

bootRun:
	@./gradlew bootRun

build-local:
	@./gradlew build --continuous

build-and-run: ## Build the Docker image and make sure it works by running it
	@docker run -v $(PWD):/app -w /app --rm openjdk:8-alpine ./gradlew clean build
	@docker build . -t setlist-creator
	@docker run -p 8080:8080 --rm setlist-creator

.PHONY: setup run-dist

setup:
	cd app && ./gradlew clean install

run-dist:
	./app/build/install/app/bin/app

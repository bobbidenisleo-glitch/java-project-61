.PHONY: run-dist

run-dist:
	./app/build/install/app/bin/app

build:
	cd app && ./gradlew build

test:
	cd app && ./gradlew test

clean:
	cd app && ./gradlew clean

install:
	cd app && ./gradlew install

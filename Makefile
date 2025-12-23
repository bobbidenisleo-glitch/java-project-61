.PHONY: build test clean install

build:
	./gradlew build

test:
	./gradlew test

clean:
	./gradlew clean

install:
	./gradlew install

setup:
	./gradlew clean install

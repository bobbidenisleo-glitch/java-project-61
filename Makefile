.PHONY: build test

build:
	./gradlew build

test:
	./gradlew test

install:
	./gradlew install

clean:
	./gradlew clean

setup:
	./gradlew clean install

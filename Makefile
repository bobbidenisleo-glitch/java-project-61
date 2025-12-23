.PHONY: run-dist setup build test clean install

run-dist:
	./code/app/build/install/app/bin/app

setup:
	cd code/app && ./gradlew clean install

build:
	cd code/app && ./gradlew build

test:
	cd code/app && ./gradlew test

clean:
	cd code/app && ./gradlew clean

install:
	cd code/app && ./gradlew install

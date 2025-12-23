.PHONY: setup run-dist

setup:
	cd code/app && ./gradlew clean install

run-dist:
	./code/app/build/install/app/bin/app

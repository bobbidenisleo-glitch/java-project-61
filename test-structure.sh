#!/bin/bash
echo "=== Testing Hexlet Structure ==="
echo "PWD: $(pwd)"
echo "LS root:"
ls -la
echo "LS code/app:"
ls -la code/app/
echo "Java files in src:"
find code/app/src -name "*.java" | wc -l
echo "Gradle test:"
cd code/app && ./gradlew --version

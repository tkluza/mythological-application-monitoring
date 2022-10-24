#!/bin/bash

set -o errexit

echo "Build with maven..."
cd ..
./mvnw clean install


#!/bin/bash

set -o errexit

echo "Starting local applications..."

profile=local-slow

echo "Starting smart-mobility application..."
cd ../../smartmobility
./mvnw spring-boot:run -Dspring-boot.run.profiles=$profile

echo "Starting application application..."
cd ../payment
./mvnw spring-boot:run -Dspring-boot.run.profiles=$profile


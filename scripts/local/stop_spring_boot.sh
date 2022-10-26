#!/bin/bash

set -o errexit

echo "Stopping local applications..."

echo "Stopping smart-mobility application..."
cd ../../smartmobility
./mvnw spring-boot:stop

echo "Stopping payment application..."
cd ../payment
./mvnw spring-boot:stop


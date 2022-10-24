#!/bin/bash

set -o errexit

echo "Cleanup docker configuration for smart city..."

cd ../docker
docker-compose stop smart-mobility
docker-compose stop payment

docker-compose rm -v -f smart-mobility
docker-compose rm -v -f payment

#!/bin/bash

set -o errexit

echo "Build and start docker images"

cd ../docker
docker-compose up -d --build --force-recreate smart-mobility

sleep 10



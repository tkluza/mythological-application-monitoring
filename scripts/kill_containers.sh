#!/bin/bash

set -o errexit

echo "Cleanup docker configuration..."

cd ../docker
docker-compose stop
docker-compose down -v

#!/bin/bash

set -o errexit

echo "Cleanup docker configuration..."

cd ../docker
docker-compose down -v

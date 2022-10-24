#!/bin/bash

set -o errexit

echo "Starting to setup environment..."

./kill_containers.sh
./build_with_maven.sh
./start_containers.sh

echo "Apps are running!"


#!/bin/bash

set -o errexit

echo "Reloading smart city apps..."

./kill_smart_city_containers.sh
./build_with_maven.sh
./start_smart_city_containers.sh

echo "Smart city apps are running!"


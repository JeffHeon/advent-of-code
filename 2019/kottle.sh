#!/bin/bash

# Script to compile and run a Kotlin "class" file
# Drive-by running: will delete the intermediate uberjar afterwards
source=$1
core_name=${source/%.kt}
jar_name=uber${core_name}.jar

echo Compiling ${source}
kotlinc ${source} -include-runtime -d ${jar_name}

echo "Running ${jar_name} (Output, if any, between lines)"
echo ---------------------------------------
java -jar ${jar_name}
echo ---------------------------------------

echo Cleaning up ${jar_name}
rm ${jar_name}

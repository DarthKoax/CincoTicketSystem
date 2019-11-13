#!/bin/bash
cd com/example/java
rm *.class
find -name "*.java" > javas.txt
javac -Xlint:unchecked @javas.txt
cd ../../../

#!/bin/sh

#TODO mieux gérer les chemins (pour pouvoir appeler le script de n'importe où)

JARS=`/bin/ls lib/*.jar`

CLASSPATH=""

for JAR in $JARS ; do
    CLASSPATH=$CLASSPATH:$JAR
done

java -cp "$CLASSPATH"  io.github.algorys.agshmne.Agshmne

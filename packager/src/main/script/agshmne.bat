rem mieux gérer les chemins (pour pouvoir appeler le script de n'importe où)

SET CLASSPATH="lib/agshmne-swing-0.0.1-SNAPSHOT.jar;lib/agshmne-core-0.0.1-SNAPSHOT.jar"
java -cp "%CLASSPATH%"  io.github.algorys.agshmne.Agshmne



First step : compilation

javac -d target src/java/fr/my/printer/*.java

Secound step : cp image it to target


cp -rf src/resources target

3 eme step : create jar file 

jar cvfe target/images-to-chars-printer.jar fr.my.printer.Program -C target .


4 eme step: execution 

java -jar target/images-to-chars-printer.jar . 0

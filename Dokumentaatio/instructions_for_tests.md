# Istructions for terminal


## Jacoco tests
In terminal go to the directory "DynaamisetIstutukset" and type command: "mvn test jacoco:report".

## Jar creation
In terminal go to the directory "DynaamisetIstutukset" and type command: "mvn package".
Jar can be found here: https://github.com/vipy123/ot-harjoitustyo/blob/master/ot-harjoitustyo/original-DynaamisetIstutukset-1.0-SNAPSHOT.jar

## Jar run
type command java -jar original-DynaamisetIstutukset-1.0-SNAPSHOT.jar or 
type command java -jar DynaamisetIstutukset.jar

## Check style
In terminal go to the directory "DynaamisetIstutukset" and type command: "mvn jxr:jxr checkstyle:checkstyle".

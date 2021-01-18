# partielwebservice-client

## PREREQUIS: 

Installer [tomcat](https://tomcat.apache.org/tomcat-8.5-doc/setup.html)

Installer maven

## INSTALLATION:

### ETAPE 1 : 
  Clonez le projet a partir du repository

Si vous n'effectuer pas de modifications passer directement a l'etape 4

Si oui passer a l'etape  2
  
### ETAPE 2 : 

Une fois les modications effectuées

  Generer le war aller a la racine du projet et excuter la commande:
  
    > mvn clean package
    
 ### ETAPE 3 :
 
 Deployer le war 
  
    -Récupérer le fichier war genere a partir du repertoire "partielwebservice-client/target/partielwebservice-client.war"
    
    -coller le ficher  nommé partielwebservice-client.war dans le repertoire webapps de tomcat
    
    -Lancer le serveur tomcat 
    
     -Lancer l'application via un navigateur : [http://localhost:8080/partielwebservice-client](http://localhost:8080/partielwebservice-client)
     
     - Se connecter avec un login: admin et un mot de passe: admin


### ETAPE 4 :
 
 Deployer le war 
  
    -Récupérer le fichier war genere a partir de la racine  du projet client partielwebservice-client.war"
    
    -coller le fichier dans le repertoire webapps de tomcat
    
    -Lancer le serveur tomcat 
    
    Lancer l'application via un navigateur : [http://localhost:8080/partielwebservice-client](http://localhost:8080/partielwebservice-client)

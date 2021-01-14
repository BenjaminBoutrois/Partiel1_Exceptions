# Partiel1_2021

SONARQUBE :

-Télechargez SonarQube ( https://www.sonarqube.org/downloads/ )
-Allez dans le dossier bin de sonarQube et lancez sonar.bat / sonar.sh
-Rendez vous sur votre navigateur sous l’url localhost:9000
-Identifiez vous (login = admin , mdp = admin )
-Créez un projet
-Laissez vous guider puis rendez vous dans le dossier de votre projet et executez la commande :
mvn sonar:sonar \

  -Dsonar.projectKey=myProject \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=myLogin

en remplacant myProject et myLogin par le nom de votre projet et de votre login

AMAZON CLOUD

Etape 1

Acceder au lien https://aws.amazon.com/fr/

Etape 2

Creer un compte Amazon Cloud

Etape 3 Ouvrir et configurer Ec2

- Ouvrez la console Amazon EC2 à l'adresse https://console.aws.amazon.com/ec2/.

- Dans le volet de navigation, cliquez sur Key Pairs.

- Choisissez Créer une paire de clés.

- Dans Nom, entrez un nom descriptif pour la paire de clés.

- Dans File format, choisissez le format

Etape 4 

- Télécharger TomCat 9 et JDK et les Configurer
- Lancer xaamp
- Acceder au site grace au lien URL 
http://localhost:8080/partielwebservice-client/

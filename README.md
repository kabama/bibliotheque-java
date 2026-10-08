# Bibliothèque Java

Petit projet Java en ligne de commande pour gérer une bibliothèque de livres.

## Fonctionnalités

- Afficher les livres et leur catégorie.
- Rechercher un titre sans tenir compte des majuscules et minuscules.
- Rechercher les livres par catégorie.
- Ajouter des livres en refusant les titres invalides et les doublons.
- Supprimer un livre par titre.
- Compter les livres longs et trouver celui qui a le plus de pages.
- Conserver une copie indépendante de la liste reçue par la bibliothèque.

## Prérequis

- Java 17.
- Maven installé et accessible avec la commande `mvn`.

## Exécution

Depuis la racine du projet, construire le JAR :

```powershell
mvn clean package
```

Cette commande supprime les anciens fichiers générés, compile le code
et crée le JAR dans le dossier `target`.

Lancer ensuite l’application :

```powershell
java -jar target/bibliotheque-java-1.0-SNAPSHOT.jar
```
## Tests

Exécuter les tests automatisés :

```powershell
mvn test
```

Les tests vérifient l’ajout d’un livre valide, le refus d’un livre null
et le refus d’un doublon dont le titre contient des espaces autour.
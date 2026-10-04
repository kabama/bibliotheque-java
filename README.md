# Bibliothèque Java

Petit projet Java en ligne de commande pour gérer une bibliothèque de livres.

## Fonctionnalités

- Afficher les livres et leur catégorie.
- Rechercher un titre sans tenir compte des majuscules et minuscules.
- Ajouter des livres si leur titre est valide et qu’aucun doublon n’existe.
- Supprimer un livre par titre.
- Compter les livres longs et trouver celui qui a le plus de pages.
- Gérer une liste indépendante de celle reçue par la bibliothèque.

## Prérequis

Java 11 ou version ultérieure (testé avec Java 17).

## Exécution

Depuis la racine du projet, compiler les fichiers Java puis lancer le programme :

```powershell
javac src/Bibliotheque.java src/Livre.java src/Main.java
java -cp src Main
```
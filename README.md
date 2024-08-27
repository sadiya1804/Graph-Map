# Cahiers des charges

## Les modules liés à la SAE

- Programmation IHM
- Mathématiques : Graphes
- SDD
- Java
- Qualité de Développement
- Gestion de Projet Informatique

## Quels sont les attentes ?

- Concevoir un graphe représentant le trajet entre le lieu de naissance ou résidence de deux personnes. Il devra y avoir au moins 30 sites (ville, restaurant et centre de loisir).
- Analyser une carte représentée par un graphe.
- Concevoir une IHM pour explorer le graphe via graph-MAP.
- Sauvegarder le projet sur GIT.

## Contraintes techniques

**Lors du choix des nœuds et liens :**

- La répartition des nœuds :
    - 3/5 doivent être des villes
    - 1/5 doivent être des restaurants
    - 1/5 doivent être des centres de loisirs
- La répartition des liens :
    - 3/10 doivent être des autoroutes
    - 3/10 doivent être des nationales
    - 4/10 doivent être des départementales

Aussi, il doit y avoir la possibilité d’avoir plusieurs liens entre deux mêmes nœuds, comme entre Lyon et Paris une autoroute et une nationale.

Lors du chargement du programme :

Le graphe doit être donné au programme via un fichier CSV, comme décrit ci-dessous :

![Graphe Exemple]([https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d7dd149b-3581-443b-99f4-50bdfd113de8/Untitled.png](https://file.notion.so/f/f/1f9535ae-3728-4a77-bb07-99d943344b0d/d480ca4e-5c2d-49b4-a6fd-130167348262/Capture_dcran_2022-03-08_103332.png?table=block&id=d45321cc-b59d-4a01-94d6-8976abad7495&spaceId=1f9535ae-3728-4a77-bb07-99d943344b0d&expirationTimestamp=1724889600000&signature=ImtvMxCrDLcfG_GVtSWm6HH-EVlOKpp2S1PG2KLAFsw&downloadName=Capture+d%E2%80%99%C3%A9cran+2022-03-08+103332.png))

![Graphe Exemple](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/83033489-7d69-43f1-99b6-514e42d2d080/Untitled.png)

Le programme doit être capable de comprendre et charger les données du fichier en mémoire.

## Description du travail à faire

![Capture d’écran](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d480ca4e-5c2d-49b4-a6fd-130167348262/Capture_dcran_2022-03-08_103332.png)
![Capture d’écran 2022-03-08 103332.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d480ca4e-5c2d-49b4-a6fd-130167348262/Capture_dcran_2022-03-08_103332.png)

## Comité de pilotage

- Richard : valider les phases de choix (Structures de Données, technologies employées), veiller au respect des délais.
- Sadiya : valider le respect du cahier des charges, mettre en place les choix.

## Arborescence – Plan des écrans

| Écrans          | Fonctionnalité                                      |
| --------------- | --------------------------------------------------- |
| Écran Principal | Charger le graphe MAP et le visualiser              |
| Écran 0         | Affichage des (0-distance)                          |
| Écran 1         | Affichage des voisins directs (1-distance)          |
| Écran 2         | Affichage des voisins à deux sauts (2-distance)     |
| Écran 3         | Comparer des sites à deux sauts ou plus             |
| Écran 4         | Déterminer entre deux sites tous les sauts et chemins (p-distance) |

## Objectifs du personnel

Indiquez les principaux résultats attendus :

- Avoir fini le travail demandé
- Obtenir une bonne note
- Acquérir de nouvelles connaissances

## Fonctionnalités

Lister de manière exhaustive les fonctionnalités attendues du projet, par ordre de priorité. Cette partie peut être développée selon le niveau de détail voulu.

## Affichage à la demande

Pouvoir afficher à la demande :

- Villes, centres de loisirs et restaurants (NŒUDS)
- Autoroutes, Nationales et Départementales
- Lister par catégorie
- Compter le nombre de nœuds ou liens.

## Sites à 1-distance

Selon un nœud, afficher tous ses voisins directs à 1-distance. De tout type confondu ou d’un type précis.

![Sites à 1-distance](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/16c23131-bce3-420c-98bc-7076c10c6ed5/Untitled.png)

## Sites à 2-distance

Selon deux sites quelconques, dire s’ils sont à 2-distance ou pas.

![Sites à 2-distance](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/339bb3eb-fd46-4733-8e89-f0ae93f5f081/Untitled.png)

## Comparaison de sites

Déterminer l’ouverture d’un nœud par rapport à un autre, c’est-à-dire comparer le nombre de voisins à 2-distance. Les deux sites doivent être à au moins 2-distance entre eux.

- Les villes :
    
    Si la ville A a plus de villes voisines à 2-distance que la ville B, alors la ville A est plus **ouverte** que la ville B ; à l’inverse, la ville A est plus **fermée** que la ville B.
    
- Les restaurants :
    
    Si le restaurant A a plus de restaurants voisins à 2-distance que le restaurant B, alors le restaurant A est **plus gastronomique** que le restaurant B ; à l’inverse, le restaurant A est **moins gastronomique** que le restaurant B.
    
- Les lieux de loisirs :
    
    Si le centre A a plus de centres de loisirs voisins à 2-distance que le centre B, alors le centre A est **plus culturel** que le centre B ; à l’inverse, le centre A est **moins culturel** que le centre B.
    

## [Bonus] Distance entre sites

Entre deux sites quelconques :

- Calculer la plus courte distance
- Trouver une route traversant un site intermédiaire
- Trouver une route traversant **plusieurs** sites intermédiaires

## Livrables

- Un dessin du graph-MAP
- Cahier des charges
- Dossiers de GPI
- Fonctionnalités
- Code en Java
- Interface IHM

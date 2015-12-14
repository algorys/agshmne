# Agshmne

> Nom du Jeu : Agshmne

## Informations Générales
Le style général sera le Jeu de Rôle Solo, en se basant sur des titres comme Daggerfall ou encore Planescape Torment pour le système de jeu et l'univers. Le mode de déplacement et de vue se rapprochera plus des premiers Civilizations.

Le jeu se déroulera sur une carte en 2D, avec des cases carrées. Le système de jeu sera au Tour par Tour. Le but est de proposer au joueur une histoire sans fin où il sera libre de continuer sa partie autant de temps qu'il le voudra. Le monde sera représenté par plusieurs régions de 256 cases générée aléatoirement puis les modifications seront sauvegardées au fur et à mesure.

Il proposera un maximum d'interactivité et surtout la possibilité de pouvoir modifier l'univers selon les désirs du joueur. La personnalisation du personnage, ainsi que la création d'objets, de différentes guildes, clans, royaumes dans l'univers apportera cette sensation.

Enfin chaque monde sera généré aléatoirement… si les donjons existent, il en sera de même.

La 2D ainsi que des graphismes légers seront privilégiés afin de ne pas être limité en terme de possibilité d'action comme le font trop souvent les jeux actuels (notamment les derniers Elders Scrolls et consort).

## Description Détaillée
### Contexte
L'univers d'Agshmne sera un mélange de fantasy provenant de différents mondes (Donjons & Dragons, Elders Scroll, Planescape Torment, Baldur's Gate, etc…) Cela ira du simple nain grognon à l'accès aux Plans Spirituelles ou Élémentaires, tout en passant par des lieux mystiques et légendaire ou des choses étranges comme de la technologie incomprise ou des choses innommables (Cthulhu).

### Objectif du Jeu

L'objectif d'Agshmne est inconnu ! Il variera selon l'envie du joueur. Si le joueur trouvent que les guildes marchandes ou bien la création d'un royaume du mal sont ses objectifs principaux, rien ne doit l'en empêcher.

Les entités (guildes ou royaumes) par défaut du monde d'Agshmne doivent pouvoir un jour appartenir au joueur comme elle peuvent être alliées ou ennemis de celles qu'il aura créée.

## Gameplay
### Informations
Le jeu sera accessible via une interface Web à l'aide de Ruby on Rails (ou un autre si besoin). Il y aura un système d'enregistrement pour que chaque joueur puisse sauvegarder ses personnages. Toutes les données du jeu seront sur serveur.
Encore une fois les graphismes seront simples mais un minimum travaillés afin de toujours faire en sorte que chaque icône ou décor soit compréhensible.

### Lancement du Jeu : 
Le joueur arrivera sur une page d'accueil présentant l'entrée d'un Donjon ou la vue d'un paysage. Il aura alors différents choix : Démarrer une partie, Charger une partie, Configurer le jeu (peut-être la taille de la carte, mort permanente, etc...) ou bien Quitter le jeu (la session du joueur). Voici chaque choix plus en détails :

* Démarrer une partie : Le joueur pourra ensuite Créer un personnage avec différentes parties personnalisables comme les caractéristiques, la race, etc., Continuer une Partie existante ou retourner en arrière :
  * Créer un personnage : le joueur devra définir plusieurs choses parmi :
    * Choisir son nom et son sexe
    * Choisir sa race 
    * Donner un nom à la classe de son personnage. (Il n'y aura pas de classes de personnage prédéfinies.)
    * Définir ses Caractéristiques : attribuer des points !
  * De base le joueur aura :
    * Un Équipement de départ
    * Argent : 10 po par exemple
  * Début : le Personnage sera sur une case (0,0) et sera une case de Type « Ville »)
* Charger / Lancer / Continuer la partie : Une fois un personnage créé, le joueur pourra lancer la partie que ce soit avec un personnage fraîchement créé ou une sauvegarde existante.
* Configurer le Jeu : Le joueur aura accès à différents réglages… Les premier réglages à pouvoir être définis seront la taille de la carte et la possibilité de rendre la mort permanente (comme un Roguelike).
* Quitter partie : Quitter la partie de fermer la session du joueur. Le joueur retournera alors à l'accueil.

## La Carte
La carte sera un des éléments principaux du jeu. Elle sera fractionnée entre différentes Régions qui seront nommée à l'avance, mais non calculées. Chaque région fera 256 cases. 

> Algo : générer des noms parmi une liste

Au début du jeu le personnage ne connaît aucune case et les découvre donc au fur et à mesure. Les cases non découvertes seront donc représenté par un point d'interrogation ou un fond noir. Elle sera composée de plusieurs cases (ou tuiles) ayant les caractéristiques suivantes :

**Type** : le type de la case
**Noms** : les noms affichés
**Actions** : les actions que le personnage pourra voir apparaître à l'écran. Ces actions peuvent aussi varier selon les compétences du personnage !

Types prévus :

* Type Ville : 
  * Noms : Cité, Village, Ville, Capitale, Ferme
  * Actions : Commercer (magasin standard, Dormir, Manger, Apprendre, Quêtes. (Gestion de la faim et de la fatigue : EPUISEMENT)
  * Spécial : la case Ville sera spéciale et fera apparaître des onglets en plus. Algo : générer aléatoirement ces magasins)
* Type Roche : 
  * Noms : Montagne, Valée, Falaises.
  * Actions : Miner
* Type Herbe : 
  * Noms : Plaine, Collines, prairies
  * Actions : Cultiver
* Type Bois :
  * Noms : Bois, Forêt, Jungle
  * Actions : Bûcheron
* Type Eau : 
  * Noms : Lac, Mer, Rivière
  * Actions : Pêcher
* Type Désert :
  * Noms : désert, toundra
  * Actions : -

> Algo : Générer une carte de 256 cases.

## Événements
Ensuite chaque case peut avoir des événements aléatoires et ainsi rajouter encore des actions possibles au personnage. Par exemple si un personnage tombe sur une fontaine de vie, il pourra régénérer ses points de vie ou encore si il rencontre un ennemi et qu'il le tue, il pourra récupérer la viande crue dessus. Ces actions peuvent aussi varier selon les compétences du personnage.

* **Rencontre Amicale** : le joueur peut se voir proposer une quête ou apprendre une compétence. (30% - DANGER)
* **Rencontre Hostile** : le joueur doit se battre ou monnayer sa fuite (si la rencontre le permet. Exemple : un joueur pourra marchander avec un bandit mais pas avec un loup). (20% + DANGER)
* **Lieu-dit** :(7%)
  * Aléatoire : Fontaine, Lieu Sacré ou maudit, Lieu hanté etc. Le Lieu-dit peut aussi bien être bénéfique ou maléfique. (Générés aléatoirement. Algo : liste / modif vie, mana, carac,...)
* **Donjon** : le donjon sera certainement la dernière chose à voir dans ce projet car il demandera beaucoup de règles pour être bien fait : passage secret, monstres bien organisés, etc. En attendant, ce sera la rencontre avec un être puissant : Dragon, Archimage, Diable, Divinités, etc. (3%)
* **Rien** : car de temps en temps il n'y a rien. (40%)

> Algo : Générer ces événements aléatoirement. (Voir ci dessus)

## Interface de l'Utilisateur
### Zone de Jeu
La zone de jeu définit l'espace où le joueur va évoluer. Il comprend un bout de la carte (3 cases autour du joueur à peu près), les boutons Déplacement, les barres de vie, mana, épuisement, l'onglet Ville si c'est une cases ville et l'onglet Action.

* Onglet Action (Zone de Jeu) : permet d'accéder à des compétences si le cas se présente (Ex : si le personnage se trouve sur une case Bois et qu'il a une Hache = Bûcher). Ou bien Attaque, Marchander, Fuir si il a détecté / rencontré un monstre, etc.
* Onglet Ville (Zone de Jeu) : Permet d'accéder au divers magasin, actions propres à la ville.
* Déplacement (Zone de Jeu) : Nord, Est, Sud et Ouest. Déplace le personnage.

### Onglets Menu

Voici les différents onglets :
* **Magie (Menu / Combat)** : Liste les sorts du personnage. Possibilité pour le joueur de lancer certains sorts selon le contexte (En combat tous les sorts seront lançables / En Zone de jeu non !)
* **Personnage (Menu)**: donnera un aperçu des caractéristiques du personnage. Cet onglet servira notamment aux passage de niveaux. (Bouton – et + pour les points)
* **Inventaire (Menu)**: affichera la liste des objets que possède le personnage. Certains objets comme les potions offriront des actions supplémentaires (comme boire, manger, équiper, enchanter, etc.) via un bouton.
* **Équipement (Menu)**: affichera une silhouette du personnage et de ce qu'il porte actuellement. Les équipements possibles seront : Tête, Bras, Torse, Jambes, 2 anneaux, 2 mains, Sac-à-dos (pour la capacité) et 1 Compagnon (Pet).
  * Le Personnage pourra retirer des équipements via ce menu.
  * Le personnage pourra renommer son Pet et l'enlever.
* **Compétences (Menu)**: les compétences seront les plus variées possibles afin de fournir au joueur le plus de combinaisons possibles. Le joueur aura tout de même certaines compétences de bases. Certaines compétences pourront être utilisés ici, comme Atelier.
  * Compétences de Base (pour tout personnage créé!) :
    * Cuisiner (Unités : repas))
    * Fouiller (Jet DEX, Objet Trouvé)
    * Boucherie (Unités : Viandes)
    * Bûcheron (Unités : bois)
    * Miner (Unités : métaux différents)
    * Cultiver (Unités : Herbes)
    * Pêcher (Unités : Poissons)
    * Magie (Voir Personnage)
  * Compétences à apprendre
    * Feu de Camp (Existe sur Carte, utilise Unités : Feu)
    * Atelier (pour les objets que l'on souhaite construire)
    * Chasser (Unités Viande)
    * Vole à la tire (Ville, Objet Trouvé)
    * Négocier (Fais baisser les prix des magasins)
    * Construction (pour les bâtiments)
    * Commandement (pour commander des royaumes ou des guildes)
    * Gérant (gère des magasins, rémunération)
    * Cacher (Cacher un objet)
Ces compétences pourront être agrandies par la suite et auront un NIVEAU.
* **Carte (Menu)**: affichera la carte en plus grand (toutes les cases idéalement) et au minimum les types de Cases. Le Joueur pourra ajouter des marqueurs avec texte.
* **Quêtes (Menu)** : montrera les quêtes acceptées par le personnage.
* **Menu (Menu)** : permet de sauvegarder, charger, quitter une partie.

### Expérience
L'expérience du personnage augmentera au fur et à mesure des succès du personnage. Bien sûr il y aura différents palier pour les niveaux.
Voici un aperçu :
* Le personnage gagne de l'expérience après différentes actions (combat, découverte de lieux, etc.)
* Gain de Niveau :
  * Points à attribuer aux Caractéristiques.

## Données
### Gestion des Tours et du Danger
* **Tours / Jours** : Les tours (ou jours) évoluent comme suit :
A chaque déplacement le tour est incrémenté, ainsi que le niveau de danger. Le Tour ne retombent jamais à 0 et continue tant que le personnage est en vie. (+1 à chaque déplacement)
Le danger est un peu spécial et influera sur les événements.
* **Danger** : Le Danger retombe à 0 après un combat. Si le personnage n'effectue aucun combat, le Danger s'incrémente à chaque déplacement. Le danger a un maximum de 20. Le danger ne s'incrémente jamais sur une case Ville.

### Personnage
Le personnage sera le plus complet possible ou tout du moins laisser la possibilité de la faire évoluer.
**Le Vital :**
* 5 Caractéristiques (Force, Dextérité, Constitution, Intelligence et Charisme)
* 4 Vitales : Vie et Mana → dépensées par combat / compétences, Fatigue et Faim → incrémenté à chaque déplacement.
* 1 caractéristique Position
* 1 Équipement : Tête, Torse, Bras, Jambes, 2 Mains, 2 anneaux
* 1 Sac-à-dos : espace limité par la Force
* Compétences : celles de bases et celles apprises.
* Expérience
* Niveau
* Argent

**Les Possessions :**
Le personnage pourra avoir un animal, posséder un royaume, une guilde, etc. Ces différents états apporteront des bonus différents.

### Combat
Les règles seront simple mais nécessiteront une instance à part de la Zone de Jeu.

## Algorithmes
### Monde
Cet algo devra générer aléatoirement des noms de région parmi une liste. Dans l'idéal, il devrait y avoir au moins 9 Régions (Carré de 3 * 3). Chaque région contiendra une carte de 256 cases. 

### Région
Cet algo devra générer une carte de 256 cases (carré de 16 cases * 16) ou bien pouvoir tirer au sort un type de case et l'écrire quelque part (BDD ou fichier). La carte possédera les attributs suivants :
* Nom : Le nom de la région
* Position : Où elle se trouve par rapport aux autres régions.
* Possession : à quel Faction elle appartient.
* Carte : L'intégrale de ses cases

### Cases
Cet Algo devra définir une case. Chaque case devra contenir les choses suivantes :
* Événement : doit être généré en premier pour savoir ce qu'il arrive. (voir fin de tour)
* Type : Le type de la case
* Actions : Les actions possibles, avec leurs conditions.
* Sol : Les objets à terre
* Possession : à quel Faction appartient la case.

### Factions
Les Factions seront très simple à gérer. Une Faction entend différents type :
* Type : Guilde, Royaume, Clan
* Location : Nom de la région à laquelle elle appartient
* Puissance : Pour les combats de région. (Disponible quand il y a 2 région découvertes)
* Cases : une fois la carte générée, les factions auront 20 % des cases d'une région.

### Villes
Les villes seront placés aléatoirement sur la carte. Chaque ville doit être espacée de 2 cases minimum. Elle généreront un menu supplémentaire à l'écran. Au moins un magasin (Bazar) vendra de tout ! 

**Magasin Principal**
* Génération du contenu du magasin
* Génération des objets :
  * Lorsqu'un personnage achète ou trouve un objet, il devra être créé aléatoirement et avoir un prix relatif à ses caractéristiques.

Différents magasins supplémentaires seront proposés au joueur avec au moins un qui vent les bases. Chaque magasins apportera un ou plusieurs bonus en plus : 
* Forge
* Alchimiste 
* Thaumaturge
* Auberge
* Taverne
* Cathédrale

### Déplacement (Fin de tour)
A chaque déplacement du personnage, c'est une « fin de tour ». C'est à dire que plusieurs état devront être vérifiés.
* Danger : si le danger est à 20, il y a un combat.
* Faim et Fatigue du personnage
* Tours : le nombre de tour fera avancer la date.
  * Générer la Date. 
* Génération de la prochaine cases ? (A voir si toute la région est générée dès le début ou pas ?)

> A faire

Combat
Monstres
Quêtes
Evènement spéciaux 





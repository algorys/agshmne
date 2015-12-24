# DOCUMENT DE CONCEPTION

## Jeu

> **Code :** Java <br>
> **IDE :** Eclipse <br>
> **Style :** RPG <br>
> **Plateformes Envisagées :** Desktop / Android

# Information Générales

> **Nom du Jeu :** Agshmne

> **Background :** ayant joué aux jeux cités ci-dessous et à de nombreux jeu de rôle sur table (Donjons et Dragons, Cyberpunk, Cthulhu pour ne citer qu'eux), je souhaite réaliser un jeu qui puisse se jouer, se rejouer et se rejouer encore d'où de nombreux côtés aléatoires. J'espère aussi pouvoir apporté du texte fourni mais pas envahissant.

Le style général sera le Jeu de Rôle en Solitaire, en se basant sur des titres comme Daggerfall pour le système de jeu ou encore Planescape Torment pour l'univers déjanté et original. Le Monde sortira quand même des sentiers battus sur certains aspects comme l'origine des races ou leurs pouvoirs. Le joueur aura un impact direct sur le Monde que ce soit au niveau de ses choix, de ses créations et des actions. Par exemple, si le joueur déclare la guerre à un Royaume, celui-ci le poursuivra et essaiera de détruire les bâtiment du joueur, etc...

La Magie sera présente dans Agshmne. Le jeu comprendra des écoles de bases que le joueur pourra ensuite s'approprier ou modifier.

## Fonctionnaliés souhaités

**Générales :**

* Personnalisation du personnage et biens matériels
* Création d'objets et objets existants dans l'univers
* Gestion et création de Clans, Guilde, Royaumes (et Capitale) dans l'univers
* Gestion des Régions
* Quêtes et énigmes à résoudre
* Gestion et création de sorts

* Donjons (J'aimerais vraiment faire quelque chose de complet, donc prévus dans des versions plus avancées)

**Système de Jeu :**
Jeu de Rôle sur table

* Lancé de Dés
* Compétences
* Expérience et Niveaux

**Aspect graphique :**
Des graphismes légers seront privilégiés afin de ne pas être limité en terme de possibilité d'action comme le font trop souvent les jeux actuels (notamment les derniers Elders Scrolls et consort).

* 2D
* Système avec des cases
* Vue de dessus
* Dessins simplistes mais modernes

## Détails

> Les premières versions seront réduites au minimum et prendront de l'ampleur et du détail petit à petit.

Le mode de déplacement et de vue se rapprochera plus des premiers Civilizations. Le jeu sera généré un maximum aléatoirement… du nom des régions aux objets trouvé, tout en passant par la nature de chaque cases et leur description. C'est un **risque** car l'aléatoire est dur à doser, mais en se basant sur un système de règles proches du JdR sur table cela doit être possible. Le but est de proposer au joueur une histoire sans fin où il sera libre de continuer sa partie autant de temps qu'il le voudra.

La plupart du jeu se déroulera sur une carte en 2D, avec des cases carrées. Le monde sera représenté par 9 régions de 256 cases générées aléatoirement (dans un premier temps, plus s'il le faut). Les modifications sur la carte (pour les Possessions par exemple - _voir plus bas_) seront sauvegardées au fur et à mesure.

Le système de jeu sera au Tour par Tour (enclenchés par chaque mouvement sur la carte). Un déplacement équivaudra à un jour probabement et on passera ainsi de Montagnes Déchainés de Malarh aux Marais des Sans Sels.

Les combats se dérouleront par rounds, permettant d'effectuer une ou plusieurs actions.

## Contexte
L'univers d'Agshmne sera un mélange de fantasy provenant de différents mondes (Donjons & Dragons, Elders Scroll, Planescape Torment, Baldur's Gate, etc…) Cela ira du simple nain grognon à l'accès aux Plans Spirituelles ou Élémentaires, tout en passant par des lieux mystiques et légendaire ou des choses étranges comme de la technologie incomprise ou des choses innommables (Cthulhu).

# Description Détaillée

## Objectif du Jeu

L'objectif d'Agshmne est inconnu ! Il variera selon l'envie du joueur. Si le joueur trouvent que les guildes marchandes ou bien la création d'un royaume du mal sont ses objectifs principaux, rien ne doit l'en empêcher.

Les entités (guildes ou royaumes) par défaut du monde d'Agshmne doivent pouvoir un jour appartenir au joueur comme elle peuvent être alliées ou ennemis de celles qu'il aura créée.

# Gameplay

## Informations

Le jeu sera développé en Java ce qui permettra d'avoir aussi bien une version en mode Desktop qu'une version Android. Il sera aussi censé fonctionner sur Windows ou sur Linux. Le style graphique du jeu sera simple mais le plus travaillé possible, afin de toujours faire en sorte que chaque icône ou décor soit compréhensible. De préférence les lieux les plus importants auront tous un Artwork principal.

## Lancement du Jeu

Le joueur arrivera sur un écran d'accueil présentant l'entrée d'un Donjon ou la vue d'un paysage. Il aura alors différents choix : Démarrer une partie, Charger une partie, Configurer le jeu (peut-être la taille de la carte, une mort permanente, un niveau de difficulté, etc...) ou bien Quitter le jeu.

Voici chaque choix plus en détails :

* Démarrer une partie : Le joueur arrivera sur l'écran de création de personnage avec différentes parties personnalisables : caractéristiques, race, etc. :
  * Créer un personnage : le joueur devra définir plusieurs choses parmi :
    * Choisir son nom et son sexe
    * Choisir sa race
    * Donner un nom à la classe de son personnage. (Il n'y aura pas de classes de personnage prédéfinies, vu que le joueur sera libre de faire évoluer son personnage comme il l'entend)
    * Attribuer des points à ses caractéristiques.
    * De base le joueur aura :
      * Un Équipement de départ
      * De l'Argent : 10 po par exemple.
      * Des compétences (Voir plus bas).
  * Une fois son personnage créé, le joueur pourra démarrer sa partie :
    * Début : le Personnage sera sur une case (0,0), de Type « Ville ».
* Charger / Lancer / Continuer la partie : Une fois un personnage créé, le joueur pourra reprendre sa partie que ce soit avec un personnage fraîchement créé ou une sauvegarde existante.
* Configurer le Jeu : Le joueur aura accès à différents réglages… Les premier réglages à pouvoir être définis seront la taille de la carte et la possibilité de rendre la mort permanente (comme un Roguelike).
* Quitter la partie : Quitter la partie permet de quitter le jeu.

## La Carte
La carte sera un des éléments principaux du jeu. Une carte de 1024 cases sera d'abord envisagée.

Elle sera ensuite fractionnée entre 9 Régions. Le personnage commencera dans la région du centre et devra ensuite découvrir les autres par ses propres moyens. Chaque région aura de base 200 cases, dont une vingtaine aléatoires.

Au début du jeu le personnage ne connaît aucune case (hormis celle de départ) et les découvre donc au fur et à mesure. Un système de "brouillard" devra être mis en place. Les cases non découvertes seront donc représenté par un point d'interrogation ou un fond noir.

Chaque case aura des propriétés spécifique et représentera un lieu : Montagne, Plaines, Grottes, Chutes d'eau, Désert, etc...

## Événements

Chaque case peut avoir des événements aléatoires et ainsi rajouter des actions possibles au personnage. Par exemple si un personnage se situe sur les Plaines du Grand Soir et tombe sur une fontaine de vie, il pourra régénérer ses points de vie ou encore si il rencontre un monstre ou une bête et qu'il le tue, il pourra récupérer de la viande crue dessus.

Ces actions peuvent aussi varier selon les compétences du personnage.

## Interface de l'Utilisateur

### Zone de Jeu
La zone de jeu définit l'espace où le joueur va évoluer. Il comprend un bout de la carte (3 cases autour du joueur), les boutons Déplacement, les barres de vie, mana, épuisement, l'onglet Ville si c'est une cases ville et l'onglet Action.

La Carte restera toujours centrée sur le Personnage.

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
* **Compétences (Menu)**: les compétences seront le plus possibles variés afin de fournir au joueur le plus de combinaisons possibles. Le joueur aura certaines compétences de bases et d'autres qu'il pourra apprendre. Certaines compétences pourront être utilisés ici, comme Atelier.
* **Carte (Menu)**: affichera la carte en plus grand (toutes les cases idéalement) et au minimum les types de Cases. Le Joueur pourra ajouter des marqueurs avec texte.
* **Quêtes (Menu)** : montrera les quêtes acceptées par le personnage.
* **Menu (Menu)** : permet de sauvegarder, charger, quitter une partie.

## Expérience

L'expérience du personnage augmentera au fur et à mesure des succès du personnage. Bien sûr il y aura différents palier pour les niveaux.

* Le personnage gagne de l'expérience après différentes actions (combat, découverte des lieux spéciaux, etc.)
* Gain de Niveau : le personnage ommencera au niveau 1 et à chaque passage de niveau :
  * Points à attribuer aux Caractéristiques.

# Données

## Gestion des Tours et du Danger

* **Tours / Jours** : Les tours (ou jours) évoluent comme suit :
A chaque déplacement le tour est incrémenté, ainsi que le niveau de danger. Le Tour ne retombent jamais à 0 et continue tant que le personnage est en vie. (+1 à chaque déplacement)
Le danger est un peu spécial et influera sur les événements.
* **Danger** : Le Danger retombe à 0 après un combat. Si le personnage n'effectue aucun combat, le Danger s'incrémente à chaque déplacement. Le danger a un maximum de 20. Le danger ne s'incrémente jamais sur une case Ville.

## Personnage

Le personnage sera le plus complet possible ou tout du moins, le jeu devra laisser la possibilité de le faire évoluer.

**Le Vital :**
* 5 Caractéristiques (Force, Dextérité, Constitution, Intelligence et Charisme)
* 4 Vitales : Vie et Mana → dépensées par combat / compétences, Fatigue et Faim → incrémenté à chaque déplacement.
* 1 caractéristique Position
* 1 Équipement : Tête, Torse, Bras, Jambes, 2 Mains, 2 anneaux
* Compétences : celles de bases et celles apprises.
* Expérience et Niveau : augmentera selon les succès du joueur. Cela apportera des bonus et des points à distribuer.
* Argent : gagné de diverses façons.

**Les Possessions :**
Le personnage pourra avoir un animal, posséder un royaume, une guilde, etc. Ces différents états apporteront des bonus différents.

* 1 Sac-à-dos : espace limité par la Force
* Un coffre : espace accessible sur toutes les cases "Ville".
* Propriétés :
  * Le joueur pourra avoir une Guilde, un royaume, un batiment...

## Combat

Les règles seront simple mais nécessiteront une instance à part de la Zone de Jeu. Chaque combat sera découpé en round, laisant au joueur comme à l'adversaie la possibilité d'avoir une ou plusieurs actions.

# Algorithmes

## Monde
Cet algorithme devra générer aléatoirement des noms de région parmi une liste. Dans l'idéal, il devrait y avoir au moins 9 Régions (Carré de 3 * 3). Chaque région contiendra une carte de 256 cases.

## Région

Cet algo devra générer une carte de 256 cases (carré de 16 cases * 16) ou bien pouvoir tirer au sort un type de case et l'écrire quelque part (BDD ou fichier). La carte possédera les attributs suivants :

* Nom : Le nom de la région
* Position : Où elle se trouve par rapport aux autres régions.
* Possession : à quel Faction elle appartient.
* Carte : L'intégrale de ses cases

## Cases

Cet Algo devra définir une case. Chaque case devra contenir les choses suivantes :

* Événement : doit être généré en premier pour savoir ce qu'il arrive. (voir fin de tour)
* Type : Le type de la case
* Nom et Description : le nom de la case et sa description.
* Actions : Les actions possibles, avec leurs conditions.
* Sol : Les objets à terre
* Possession : à quel Faction appartient la case.

Chaque case (ou tuiles) aura les caractéristiques suivantes :

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

## Evénement

Voici l'algorithme prévu :

* **Rencontre Amicale** : le joueur peut se voir proposer une quête ou apprendre une compétence. (30% - DANGER)
* **Rencontre Hostile** : le joueur doit se battre ou monnayer sa fuite (si la rencontre le permet. Exemple : un joueur pourra marchander avec un bandit mais pas avec un loup). (20% + DANGER)
* **Lieu-dit** :(7%)
  * Aléatoire : Fontaine, Lieu Sacré ou maudit, Lieu hanté etc. Le Lieu-dit peut aussi bien être bénéfique ou maléfique. (Générés aléatoirement. Algo : liste / modif vie, mana, carac,...)
* **Donjon** : le donjon sera certainement la dernière chose à voir dans ce projet car il demandera beaucoup de règles pour être bien fait : passage secret, monstres bien organisés, etc. En attendant, ce sera la rencontre avec un être puissant : Dragon, Archimage, Diable, Divinités, etc. (3%)
* **Rien** : car de temps en temps il n'y a rien. (40%)

## Factions
Les Factions seront très simple à gérer. Une Faction entend différents type :
* Type : Guilde, Royaume, Clan
* Location : Nom de la région à laquelle elle appartient
* Puissance : Pour les combats de région. (Disponible quand il y a 2 région découvertes)
* Cases : une fois la carte générée, les factions auront 20 % des cases d'une région.

## Villes

Les villes seront placés aléatoirement sur la carte. Chaque ville doit être espacée de 2 cases minimum. Elle généreront un menu supplémentaire à l'écran. Au moins un magasin (Bazar) vendra de tout !

**Magasin Principal (Bazar)**
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

## Déplacement (Fin de tour)

A chaque déplacement du personnage, c'est une « fin de tour ». C'est à dire que plusieurs élément devront être vérifiés.
* Danger : si le danger est à 20, il y a un combat.
* Faim et Fatigue du personnage
* Tours : le nombre de tour fera avancer la date.
  * Générer la Date.

## Personnage

Le personnage aura beaucoup d'attributs et notamment des caractéritiques, de l'expérience, des possessions etc.

Caractéristiques voulues (Création) :

* 5 Caractéristiques (MIN : 3 - MAX : 20) :
  * Force (FOR) : impactera l'attaque au Corps à Corps, les actions demandant de la force (pousser, tirer, casser, etc...)
  * Dextérité (DEX) : impactera l'attaque à distance, le Crochetage, les actions délicates (Crocheter, équilibre, etc...)
  * Constitution (CON) : impactera les Points de Vie, la résitance aux poisons, aux maladies, etc...
  * Intelligence (INT) : impactera les Points de Mana, les sorts, la résolution de problèmes.
  * Charisme (CHA) : impactera les réactions aves les gens (Comme les négociations de prix).
    * Chaque caratéristique aura 10 points + les points que le joueur attribuera.
* 4 Vitales :
  * Vie : CON + 10 + NIV
  * Mana : INT + NIV
  * Fatigue et Faim : CON + 10
* Position : (0,0)
* Équipement : Tête, Torse, Bras, Jambes, 2 Mains, 2 anneaux.
  * Départ : Epée ou Baton
* Sac-à-dos : espace Sac + FOR = nombre d'objets portés
* Compétences : celles de bases toutes au niveau 1
* Expérience : 0
* Niveau : 1
* Argent : 5po + 1d10

Caractéristiques (En jeu) :

Un lancer de caractéristique se fera avec 1d20. Il faudra que le résultat du dé soit inférieur à la caractéristique pour que ce soit réussi.

## Compétences

Ces compétences pourront être améliorées par la suite et auront donc un NIVEAU.

Compétences souhaitées :
  * Compétences de Base (pour tout personnage créé!) :
    * Cuisiner (Unités : repas))
    * Fouiller (DEX : Objet Trouvé)
    * Boucherie (Unités : Viandes)
    * Bûcheron (Unités : bois)
    * Miner (Unités : métaux différents)
    * Cultiver (Unités : Herbes)
    * Pêcher (Unités : Poissons)
    * Magie (INT : Voir Personnage)
  * Compétences à apprendre
    * Feu de Camp (Existe sur Carte, utilise Unités : Feu)
    * Atelier (ATELIER : pour les objets que l'on souhaite construire)
    * Chasser (Unités : Viandes)
    * Vole à la tire (DEX : Ville, Objet Trouvé)
    * Négocier (CHA : Fais baisser les prix des magasins)
    * Construction (INT : pour les bâtiments)
    * Commandement (CHA : pour commander des royaumes ou des guildes)
    * Gérant (gère des magasins, rémunération)
    * Crocheter (DEX : crocheter une serrure)
    * Langues Anciennes (INT : déchiffrer des énigmes)

Compétences (En jeu) :

Les compétence auront une difficulté (DD = 15 facile, 20 moyen, 20 difficile etc.) à atteindre pour réussir et augmenter leur progression.

Exemple : Jet Fouiller = 1d10 + (DEX - 10) + NIV Fouiller devra battre une difficulté de 15, 20, 25 etc.

La compétence gagne n% pour n au dessus du DD en progression.

> A faire

Combat
Monstres
Quêtes
Evènement spéciaux

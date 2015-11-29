<?php

class Deplacer {

    /***************
    * Coordonnées initiales du PJ
    */
    var $x;
    var $y;

    /*
    * Quatres déplacements possible (est, ouest, sud, nord)
    */
    function monter() {

        $this->y += 1;
    }

    function descendre() {

        $this->y -= 1;
    }

    function gauche() {

        $this->x -= 1;
    }

    function droite() {

        $this->x += 1;
    }

    function afficherPosition() {

        echo "Vous vous trouvez en : <br>";

        echo "x = : ".$this->x;

        echo " y = : ".$this->y;

        echo '<br>';
    }

}

$pj = new Deplacer();

// Inititalisation des coordonnées
$pj->x=0;
$pj->y=0;

// Position initiale
$pj->afficherPosition();
    
$pj->monter();
$pj->afficherPosition();
    
$pj->droite();
$pj->droite();
$pj->afficherPosition();

echo '<h4>Objet en cours</h4>';
print_r($pj);



?>            

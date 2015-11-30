<?php

class Emplacement {
    private $x;
    private $y;

    function Emplacement($x, $y) {
        $this->x = $x;
        $this->y = $y;
    }

    function getX() { return $this->x; }
    function getY() { return $this->y; }

    function getVoisin($direction) {
        $x = $this->x;
        $y = $this->y;

        switch($direction) {
            case Direction::NORTH:
                $y = $this->y + 1;
            break;
            case Direction::EAST:
                $x = $this->x + 1;
            break;
            case Direction::SOUTH:
                $y = $this->y - 1;
            break;
            case Direction::WEST:
                $x = $this->x - 1;
            break;
            default:
                //ERROR
        }
        return new Emplacement($x, $y);
    }
}

abstract class Direction {
    const NORTH = 0;
    const EAST = 1;
    const SOUTH = 2;
    const WEST = 3;
}

class Personnage {
    private $pos;
    function Personnage() {
        $this->pos = new Emplacement(0, 0);
    }
    function aller($direction) {
        $this->pos = $this->pos->getVoisin($direction);
        /*
        switch($direction) {
            case Direction::NORTH:
                $this->y++;
            break;
            case Direction::EAST:
                $this->x++;
            break;
            case Direction::SOUTH:
                $this->y--;
            break;
            case Direction::WEST:
                $this->x--;
            break;
            default:
                //ERROR
        }*/
    }


    function getX() {
        return $this->pos->getX();
    }
    function getY() {
        return $this->pos->getY();
    }
}

class Util {
    static function affichePersonnagePosition($p) {
        echo "Le personnage se situe en (" . $p->getX() . ", " . $p->getY() . ")<br/>\n";
    }
}
$pj = new Personnage(); // Initialisation 0,0
Util::affichePersonnagePosition($pj);
$pj->aller(Direction::EAST);
//assert $pj->getX() == 1;
//assert $pj->getY() == 0;
Util::affichePersonnagePosition($pj);

$pj->aller(Direction::EAST);
//assert $pj->getX() == 2;
//assert $pj->getY() == 0;
Util::affichePersonnagePosition($pj);


?>            

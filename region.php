<?php

    function map_type() {

        $terrain = [
            "Montagne"
            , "Plaine"
            , "Désert"
            , "Colline"
            , "Champs"
            , "Forêt"
        ];

        $terrainL = count($terrain);
        $n = rand(1,$terrainL-1);
    return $terrain[$n];
    }

    function region($coord, $name) {
        $terrain = '';
        $name = map_type($terrain);
        $region = [
            'coord' => $coord
            , 'name'=> $name
        ];

        return $region;
    }

    function create_region($x, $y) { 
        $coord = [$x, $y];
        $name = '';
        $place = region($coord, $name);
        return $place;
    }

//$map = create_region();
//print_r($map['coord']);

    function create_grid() {
        $x = 1;
        $y = 1;
        $max = 6;
        $region = array();
        for ($x; $x!=$max; $x++) {
            $place = create_region($x, $y);
            $region[] = [
                'place' => $place
            ];
        }
        print_r($region);
        $x = 5;
        for ($y; $y!=$max; $y++) {
            $place = create_region($x, $y);
            $region[] = [
                'place' => $place
            ];
        }
        foreach ($region as $place) {
//            print_r($place['place']);
            echo 'Place : '.$place['place']['name'].'<br />';
            echo 'Coord : '.$place['place']['coord'][0].','.$place['place']['coord'][1].'<br />';

        }
    }

create_grid();


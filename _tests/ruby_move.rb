<<-DOC
OBJECTIF
 Créer un personnage qui se déplace.
DOC

# @Position : Définit la direction du personnage et ses coordonnées
# @pos correspond à l'objet "coordonnees"
#
class Position
    private
    def initialize(p = 0)
        @pos = p
    end
    public
    def move(direction)
        case direction
            when "NORTH"
                @pos += 5
            when "EAST"
                @pos += 1
            when "SOUTH"
                @pos -= 5
            when "WEST"
                @pos -= 1
            TODO Gerer ERROR
            else
                puts "Vous vous êtes trompé de direction !"
        end
    end
    def get_x()
        @pos % 5
    end
    def get_y()
        @pos / 5
    end
end

# Personnage : Définit le personnage
# TODO : Déplacer cet objet dans un fichier à part
#
class Personnage
    private
    def initialize()
        @vital = {'vie'=>0,'mana'=>0}
        @carac = {'puissance'=>0,'defense'=>0}
        @position = Position.new
    end
    public
    def go_to(direction)
        @position.move(direction)
    end
    def get_x()
        @position.get_x
    end
    def get_y()
        @position.get_y
    end
end

# TODO : déplcer dans un fichierà part
class Dice
    def self.d(n)
        @n = rand(n)
    end
end

class Terrain
    private
    def initialize()
        @terrain = []
    end

    public
    def lib_terrain()
        g = [
            :prairie,
            :route,
            :arbre,
            :lac,
            :foret,
            :bois]
        g[Dice.d(5)]
    end
    public
    def type_terrain()
        @terrain = lib_terrain()
    end
end

terrain = Terrain.new
terrain.type_terrain

puts terrain.inspect

# Map : crée la carte
#
class Map
    private
    def initialize()
        @width = 3
        @height = 3
        @content = [[:arbre,:route,:prairie],
                    [:prairie,:arbre,:prairie],
                    [:arbre,:route,:arbre]]
    end
    
    public
    def get_content(content)
        content[[terrain.id]]
        puts content
    end

    def get_case(x,y)
        @content[x % @width][y % @height]
    end
end


class Util
    def self.affiche_pos(p)
        puts "Le personnage se trouve en x = #{p.get_x} et y = #{p.get_y} !"
    end
    def self.affiche_case(map, p)
        puts "Le personnage se trouve sur un case \"#{map.get_case(p.get_x, p.get_y)}\""
    end
end


map = Map.new
pj = Personnage.new()
puts pj.inspect

(0..5).each do
    pj.go_to("NORTH")
    Util.affiche_pos(pj)
    Util.affiche_case(map, pj)
end

pj.go_to("NORTH")
pj.go_to("NORTH")
pj.go_to("SOUTH")
Util.affiche_pos(pj)
Util.affiche_case(map, pj)

pj.go_to("EAST")
Util.affiche_pos(pj)
Util.affiche_case(map, pj)

pj.go_to("droite")




<<-DOC
OBJECTIF
 Créer un personnage qui se déplace.
DOC

# @Position : Définit la direction du personnage et ses coordonnées
# @pos correspond à l'objet "coordonnees"
#
class Position
    private
    def initialize *args
        case args.size
        when 0
            @pos = 0
        when 1
            @pos = args[0]
        when 2
            @pos = 5*args[1] + args[0]
        end
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
            #TODO Gerer ERROR
                # utiliser raise
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
    def get_pos()
        @pos
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

class TypeTerrain
    # TODO Fusionner avec Terrain
    def initialize(type, aff)
        @type = type
        @affichage = aff
    end
    public
    def get_type()
        @type
    end
    def to_s()
        @affichage
    end
end

class Terrain
    private
    def initialize()
        @type = lib_terrain()
    end
    @@list_terrain = [
        :prairie,
        :route,
        :arbre,
        :lac,
        :foret,
        :bois,
        :hell]
    def lib_terrain()
        case @@list_terrain[Dice.d(@@list_terrain.size())]
        when :prairie
            @type = TypeTerrain.new(:prairie, '/')
        when :route
            @type = TypeTerrain.new(:route, '.')
        when :arbre
            @type = TypeTerrain.new(:arbre, '^')
        when :lac
            @type = TypeTerrain.new(:lac, 'o')
        when :foret
            @type = TypeTerrain.new(:foret, 'w')
        when :bois
            @type = TypeTerrain.new(:bois, 'v')
        when :hell
            @type = TypeTerrain.new(:hell, 'x')
        end
    end
    public
    def get_type()
        @type
    end
    def to_s()
        @type.to_s
    end
end

terrain = Terrain.new
puts terrain.get_type

puts terrain.inspect

tile0 = Terrain.new
puts tile0.get_type
grid = [tile0]
tile1 = Terrain.new
puts tile1.get_type
grid += [tile1]
puts grid.inspect
# Map : crée la carte
#
class Map
    private
    def initialize()
        @content = {}
        (0..24).each do |i|
            @content[i] = Terrain.new
        end
    end
    
    public
    def get_case_from_pos(pos)
        @content[pos]
    end
    def get_case(x, y)
        get_case_from_pos(Position.new(x,y).get_pos)
    end
    def to_s()
        ans = ""
        4.downto(0) do |y|
            (0..4).each do |x|
                ans += get_case(x,y).to_s
            end
            ans += "\n"
        end
        ans
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

(0..3).each do
    pj.go_to("NORTH")
    Util.affiche_pos(pj)
    Util.affiche_case(map, pj)
end


puts "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
puts map.to_s
puts "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"


pj.go_to("NORTH")
pj.go_to("NORTH")
pj.go_to("SOUTH")
Util.affiche_pos(pj)
Util.affiche_case(map, pj)

pj.go_to("EAST")
Util.affiche_pos(pj)
Util.affiche_case(map, pj)

pj.go_to("droite")





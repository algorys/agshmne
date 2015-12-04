#######################################""
# Le but 

class Position
    private 
    def initialize(x = 0, y = 0)
        @x = x
        @y = y
    end
    public
    def move(direction)
        case direction
            when "NORTH"
                @y += 1
            when "EAST"
                @x += 1
            when "SOUTH"
                @y -= 1
            when "WEST"
                @x -= 1
            TODO
            else
                puts "Vous vous êtes trompé de direction !"
        end
    end
    def get_x()
        @x
    end
    def get_y()
        @y
    end
end

class Position2
    private
    def initialize(z = 0)
        @toto = z
    end
    public
    def move(direction)
        case direction
            when "NORTH"
                @toto += 5
            when "EAST"
                @toto += 1
            when "SOUTH"
                @toto -= 5
            when "WEST"
                @toto -= 1
            TODO
            else
                puts "Vous vous êtes trompé de direction !"
        end
    end
    def get_x()
        @toto % 5
    end
    def get_y()
        @toto / 5
    end
end

class Personnage
    private
    def initialize()
        @position = Position2.new
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


#:arbre = "Arbre"
#:route = "Route"
#:prairie = "Prairie"

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




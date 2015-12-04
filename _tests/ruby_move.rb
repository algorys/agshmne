class Emplacement
    attr_reader :x, :y
    private 
    def initialize(x = 0, y = 0)
        @x = x
        @y = y
    end
    public
    def getPos(position)
        case position
            when "NORTH"
                @y += 1
            when "EAST"
                @x += 1
            when "SOUTH"
                @y -= 1
            when "WEST"
                @x -= 1
            else
                puts "Vous vous êtes trompé de direction !"
        end
    end


end

class Personnage
    attr_reader :direction, :position
    private
    def initialize()
        @position = Emplacement.new
    end
    public
    def goTo(direction)
        position.getPos(direction)
    end
end

class Util
    attr_reader :p
    def affichePos(p)
        puts "Le personnage se trouve en x = #{p.position.x} et y = #{p.position.y} !"
    end
end

pj = Personnage.new()

pj.goTo("NORTH")
Util.new.affichePos(pj)

pj.goTo("EAST")
Util.new.affichePos(pj)

pj.goTo("droite")

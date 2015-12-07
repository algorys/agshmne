

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


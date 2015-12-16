require_relative 'position'

<<-DOC
Définit tout ce qui est en rapport avec le Personnage
DOC

# Personnage : Définit le personnage
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


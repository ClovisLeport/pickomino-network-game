package modele

import iut.info1.pickomino.exceptions.IncorrectKeyException

class Player(numberPlayer:Int,localPlayer : Boolean) {
    private val numberPlayer : Int = numberPlayer
    private val localPlayer : Boolean = localPlayer
    private var ListPickomino = mutableListOf<Pickomino>()
    private var diceKept = mutableListOf<Dice>()
    private var dicePlayed = mutableListOf<Dice>()
    public fun countWorms():Int{
        var nb_worms = 0
        for (i in 0..ListPickomino.size-1) {
            nb_worms +=ListPickomino[i].getnbWorm()
        }
        return nb_worms
    }

    public fun firstElement():Pickomino {
        return ListPickomino[-1]
    }

    public fun addElement(Picko: Pickomino) {
        if (ListPickomino.size == 16) {
            return
        }else {
            ListPickomino.add(Picko)
        }
    }

    public fun removeElement():Pickomino {
        var picko = ListPickomino[-1]
        try {
            ListPickomino.removeAt(ListPickomino.size-1)
        }
        catch (e:IndexOutOfBoundsException) {
            throw  IncorrectKeyException()
        }
        return picko
    }

}
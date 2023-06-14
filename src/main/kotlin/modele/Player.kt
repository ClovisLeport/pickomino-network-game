package modele

import iut.info1.pickomino.exceptions.IncorrectKeyException

class Player(id:Int, name:String) {
    private var id = id
    private var name = name
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
        if (ListPickomino.size == 0) {
            throw IncorrectKeyException()
        }
        return ListPickomino[ListPickomino.size-1]
    }

    public fun addElement(Picko: Pickomino) {
        if (ListPickomino.size == 16) {
            return
        }else {
            ListPickomino.add(Picko)
        }
    }

    public fun removeElement():Pickomino {
        var picko = ListPickomino[ListPickomino.size-1]
        try {
            ListPickomino.removeAt(ListPickomino.size-1)
        }
        catch (e:IndexOutOfBoundsException) {
            throw  IncorrectKeyException()
        }
        return picko
    }

}
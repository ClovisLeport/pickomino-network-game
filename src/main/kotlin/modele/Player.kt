package modele

import iut.info1.pickomino.exceptions.IncorrectKeyException

class Player(numberPlayer:Int,localPlayer : Boolean) {
    private val numberPlayer : Int = numberPlayer
    val localPlayer : Boolean = localPlayer
    private var ListPickomino :MutableList<Pickomino> = mutableListOf<Pickomino>()

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


    fun topPickominoIs(picko : Pickomino){
        if (picko in ListPickomino){
            if (picko != ListPickomino[ListPickomino.size-1]){
                this.removeElement()
                this.topPickominoIs(picko)
            }
        }
        else{
            this.addElement(picko)
        }
    }



}
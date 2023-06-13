package modele

import iut.info1.pickomino.exceptions.PickominoException

class Pickomino(value :Int,nbWorms :Int) {
    private val value :Int
    private val nbWorms :Int

    init {
        if (value <=36 && value >=21) this.value = value else throw Exception()
        if (nbWorms >=0 && nbWorms <= 5) this.nbWorms = nbWorms else throw Exception()
    }

    fun getValue() :Int{
        return this.value
    }
    fun getnbWorm() :Int{
        return this.nbWorms
    }

}
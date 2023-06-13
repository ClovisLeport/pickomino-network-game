package modele

class Pickomino(value :Int,nbWorms :Int) {
    private val value :Int
    private val nbWorms :Int

    init {
        this.value = value
        this.nbWorms = nbWorms
    }

    fun getValue() :Int{
        return this.value
    }
    fun getnbWorm() :Int{
        return this.nbWorms
    }

}
package modele


class Pickomino(value :Int,nbWorms :Int) {
    private val value :Int
    private val nbWorms :Int

    init {
        if (value >=21 &&  value <=36) this.value = value else throw Exception()
        if (nbWorms >=0 && nbWorms <= 5) this.nbWorms = nbWorms else throw Exception()
    }

    fun getValue() :Int{
        return this.value
    }
    fun getnbWorm() :Int{
        return this.nbWorms
    }

}
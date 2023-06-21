package modele


class Pickomino(value :Int) {
    private val value :Int
    private val nbWorms :Int

    init {
        if (value == 0) {
            this.value = 0
            nbWorms = 0
        }
        else{
            if (value >=21 &&  value <=36) this.value = value
            else throw Exception()

            if (value >=21 &&  value <=24) this.nbWorms = 1

            else if (value >=25 &&  value <=28) this.nbWorms = 2
            else if (value >=29 &&  value <=32) this.nbWorms = 3
            else if (value >=33 &&  value <=36) this.nbWorms = 4
            else throw Exception()
        }

    }

    fun getValue() :Int{
        return this.value
    }
    fun getnbWorm() :Int{
        return this.nbWorms
    }

    override fun toString(): String {
        return "$value"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Pickomino

        if (value != other.value) return false

        return true
    }



}
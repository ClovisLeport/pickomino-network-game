package modele
import kotlin.random.Random

internal class Dice {
    private var value: Int = -1

    fun getValue() : Int {
        if (this.value > 0 && this.value <6) return this.value else throw Exception()
    }

    fun rolls() {
        this.value = (0..5).random()
    }
}

package modele
import kotlin.random.Random

internal class Dice {
    private var value: Int = -1

    fun getValue() : Int {
        return this.value
    }

    fun rolls() {
        this.value = (0..10).random()
    }
}

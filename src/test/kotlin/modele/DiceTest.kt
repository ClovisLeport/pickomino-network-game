package modele

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DiceTest {
    private val dice =Dice()

    @Test
    fun test_dice() {
        repeat(60) {
            this.dice.rolls()
            val result = this.dice.getValue()
            assertTrue(result in 0..5)
        }
    }




}
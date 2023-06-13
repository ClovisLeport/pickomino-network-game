import iut.info1.pickomino.data.DICE
import iut.info1.pickomino.data.Game
import iut.info1.pickomino.data.Pickomino
import iut.info1.pickomino.exceptions.BadPickominoChosenException
import iut.info1.pickomino.exceptions.PickominoException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TestExample {


    @Test
    fun testDice1() {
        var d1 = DICE.d1
        assertEquals(0 ,d1.ordinal)
    }
    @Test
    fun testDice1Name() {
        var d1 = DICE.d1
        assertEquals("d1" ,d1.name)
    }
    @Test
    fun testDice2() {
        var d1 = DICE.d2
        assertEquals(1 ,d1.ordinal)
    }
    @Test
    fun testDice2Name() {
        var d1 = DICE.d2
        assertEquals("d2" ,d1.name)
    }
    @Test
    fun testDice3() {
        var d1 = DICE.d3
        assertEquals(2,d1.ordinal)
    }
    @Test
    fun testDice3Name() {
        var d1 = DICE.d3
        assertEquals("d3" ,d1.name)
    }
    @Test
    fun testDice4() {
        var d1 = DICE.d4
        assertEquals(3 ,d1.ordinal)
    }
    @Test
    fun testDice4Name() {
        var d1 = DICE.d4
        assertEquals("d4" ,d1.name)
    }

    @Test
    fun testDice5() {
        var d1 = DICE.d5
        assertEquals(4 ,d1.ordinal)
    }
    @Test
    fun testDice5Name() {
        var d1 = DICE.d5
        assertEquals("d5" ,d1.name)
    }

    @Test
    fun testDiceWorm() {
        var d1 = DICE.worm
        assertEquals(5 ,d1.ordinal)
    }
    @Test
    fun testDiceWormName() {
        var d1 = DICE.worm
        assertEquals("worm" ,d1.name)
    }

//    @Test
//    fun TestGameAccessiblePickos() {
//        var Picko = Pickomino(27, 1)
//        var game1 = Game(1, mutableListOf<Pickomino>(Picko), mutableMapOf<Int, MutableList<Pickomino>>(),)
//        assertEquals()
//    }

//    @Test
//    fun BAdPickExcept1() {
//        var d1 = DICE.worm
//        assertEquals("worm" ,d1.name)
//    }
}

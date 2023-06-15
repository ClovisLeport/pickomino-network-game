package modele

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class PickominoTest {


    @Test
    fun test1_getValue() {
        var pick =Pickomino(21)
        assertEquals(21,pick.getValue(),"Il n'a pas renvoyer la bonne valeur")
    }
    @Test
    fun test2_getValue() {
        var pick =Pickomino(36)
        assertEquals(36,pick.getValue(),"Il n'a pas renvoyer la bonne valeur")
    }
    @Test
    fun test3_InitErrorValue() {
        assertThrows<Exception>{Pickomino(16)}
    }

    @Test
    fun test4_InitErrorValue() {
        assertThrows<Exception>{Pickomino(54)}
    }



    @Test
    fun test1_getnbWorms() {
        var pick =Pickomino(21)
        assertEquals(0,pick.getnbWorm(),"Il n'a pas renvoyer la bonne valeur")

    }
    @Test
    fun test2_getnbWorms() {
        var pick =Pickomino(21)
        assertEquals(5,pick.getnbWorm(),"Il n'a pas renvoyer la bonne valeur")
    }
    @Test
    fun test3_InitErrorWorms() {
        assertThrows<Exception>{Pickomino(0)}
    }

    @Test
    fun test4_InitErrorWorms() {
        assertThrows<Exception>{Pickomino(0)}
    }


}
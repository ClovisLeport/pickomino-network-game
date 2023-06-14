package modele

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class GameTest {

    @Test
    fun preremplir() {
        var game1 = Game(1)
        game1.preremplir()
        assertEquals(16,game1.getPickos().size)
    }

    @Test
    fun isEmpty() {
        var game1 = Game(1)
        assertEquals(true,game1.isEmpty())
    }

    @Test
    fun Addplayer() {
        var game1 = Game(1)
        var player1 = Player(1,"test")
        game1.addPlayer(player1)
        assertEquals(1,game1.playerList().size)
    }
    @Test
    fun removeElement() {
        var game1 = Game(1)
        game1.preremplir()
        var listPick = game1.getPickos()
        game1.removeElement(listPick.elementAt(2))
        assertEquals(15,game1.getPickos().size)
    }
}
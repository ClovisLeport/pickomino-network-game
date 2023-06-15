package modele

import iut.info1.pickomino.data.DICE
import iut.info1.pickomino.data.STATUS
import iut.info1.pickomino.exceptions.IncorrectKeyException

class Game(numérojoueur : Int) {
    //private val id = id
    private var listPickominosEnJeu = mutableListOf<Pickomino>()
    private var listPlayer = mutableListOf<Player>()
    var numérojoueur :Int = numérojoueur


    private var diceKept = listOf<DICE>() //Dice
    private var diceChosen = listOf<DICE>()





    public fun preremplir() {
        listPickominosEnJeu.add(Pickomino(21))
        listPickominosEnJeu.add(Pickomino(22))
        listPickominosEnJeu.add(Pickomino(23))
        listPickominosEnJeu.add(Pickomino(24))
        listPickominosEnJeu.add(Pickomino(25))
        listPickominosEnJeu.add(Pickomino(26))
        listPickominosEnJeu.add(Pickomino(27))
        listPickominosEnJeu.add(Pickomino(28))
        listPickominosEnJeu.add(Pickomino(29))
        listPickominosEnJeu.add(Pickomino(30))
        listPickominosEnJeu.add(Pickomino(31))
        listPickominosEnJeu.add(Pickomino(32))
        listPickominosEnJeu.add(Pickomino(33))
        listPickominosEnJeu.add(Pickomino(34))
        listPickominosEnJeu.add(Pickomino(35))
        listPickominosEnJeu.add(Pickomino(36))
    }

    public fun isEmpty():Boolean {
        return listPickominosEnJeu.size ==0
    }

    public fun addPlayer( player : Player) : Boolean{
        if (player !in this.listPlayer){
            this.listPlayer.add(player)
            return true
        }
        return false
    }

    public fun removeElement(Picko:Pickomino) {

        try {
            listPickominosEnJeu.remove(Picko)
        }
        catch (e:IndexOutOfBoundsException) {
            throw  IncorrectKeyException()
        }

    }
    fun playerList():MutableList<Player> {
        return listPlayer
    }

    public fun getPickos(): MutableCollection<Pickomino> {
        if (listPickominosEnJeu.size == 0) {
            throw IncorrectKeyException()
        }
        return listPickominosEnJeu
    }


    fun setDice(diceskept : List<DICE>, diceschosen : List<DICE>){
        diceKept = diceskept
        diceChosen = diceschosen
    }

    fun setPickomino(Pickominos : List<Int>){
        var newlistPickominosEnJeu = mutableListOf<Pickomino>()
        for ( Picko in Pickominos){
            newlistPickominosEnJeu.add(Pickomino(Picko))
        }

        this.listPickominosEnJeu = newlistPickominosEnJeu
    }

}
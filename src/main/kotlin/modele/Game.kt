package modele

class Game(name:String) {
    private val name = name
    private var listPickominosEnJeu = mutableListOf<Pickomino>()
    private var listPlayer = mutableListOf<Player>()
    public fun preremplir() {
        listPickominosEnJeu.add(Pickomino(21,1))
        listPickominosEnJeu.add(Pickomino(22,1))
        listPickominosEnJeu.add(Pickomino(23,1))
        listPickominosEnJeu.add(Pickomino(24,1))
        listPickominosEnJeu.add(Pickomino(25,2))
        listPickominosEnJeu.add(Pickomino(26,2))
        listPickominosEnJeu.add(Pickomino(27,2))
        listPickominosEnJeu.add(Pickomino(28,2))
        listPickominosEnJeu.add(Pickomino(29,3))
        listPickominosEnJeu.add(Pickomino(30,3))
        listPickominosEnJeu.add(Pickomino(31,3))
        listPickominosEnJeu.add(Pickomino(32,3))
        listPickominosEnJeu.add(Pickomino(33,4))
        listPickominosEnJeu.add(Pickomino(34,4))
        listPickominosEnJeu.add(Pickomino(35,4))
        listPickominosEnJeu.add(Pickomino(36,4))
    }

    public fun isEmpty():Boolean {
        return listPickominosEnJeu.size ==0
    }
}
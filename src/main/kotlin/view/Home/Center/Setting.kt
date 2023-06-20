package view.Home.Center

import javafx.collections.ObservableArray
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.Slider
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import view.components.Title
import view.components.TransparentButton
import javafx.collections.ObservableList as ObservableList1

class Setting :HomeCenter(false) {
    var vbox : VBox = VBox()
    var title = Text()
    var slide :Slider
    var listener :ComboBox<String> = ComboBox()
    var sizeScreen : Int = 0
    var nombre :Label

     private var list = listOf<String>( "720 × 480","960 × 720","1280 × 1080","1440 × 1080","1440 × 1080","2048 × 1556","3656 × 2664")
    init {

        var titre = Label("Setting")
        titre.styleClass.add("setting")


        var hbox = HBox()
        var slidetxt = Label("Volume :")
        slidetxt.styleClass.add("txt")
        nombre = Label("0")
        var symbole = Label("%")
        nombre.styleClass.add("txt")
        symbole.styleClass.add("txt")
        slide = Slider(0.0,100.0,1.0)
        hbox.children.addAll(slide,nombre,symbole)
        hbox.alignment = Pos.CENTER

        var comboboxtxt = Label("Affichage :")
        comboboxtxt.styleClass.add("txt")
        listener.items.addAll(list)
        listener.styleClass.add("combobox")
        listener.value = listener.items[this.sizeScreen]



        this.alignment = Pos.CENTER

        this.children.addAll(titre,comboboxtxt,listener,slidetxt,hbox)
    }
    fun getlist(index :Int) : String {
        return list.get(index)
    }


    override fun fixeButton(listControleur:Array<EventHandler<ActionEvent>>){
        //TODO
    }
}
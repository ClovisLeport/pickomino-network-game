package view.Home.Center

import javafx.collections.ObservableArray
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.Slider
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import view.components.Title
import view.components.TransparentButton
import view.components.WhiteButton
import javafx.collections.ObservableList as ObservableList1

class Setting :HomeCenter(false) {
    var vbox : VBox = VBox()
    var title = Text()
    var slide :Slider
    var listener :ComboBox<String> = ComboBox()
    var sizeScreen : Int = 0
    var nombre :Label

     private var list = listOf<String>(
         "Plein écran",
         "Fenetré sans bordure",
         "Fenetré"
     )
    init {
        val titre = Label("Setting")
        titre.styleClass.add("setting")
        titre.padding = Insets(10.0, 0.0, 0.0, 0.0) // Ajout d'un padding de 10px au-dessus du titre

        // Boîte de volume
        val volumeBox = VBox()
        volumeBox.alignment = Pos.CENTER_LEFT
        volumeBox.maxWidth = 500.0

        val slidetxt = Label("Volume :")
        slidetxt.padding = Insets(0.0, 0.0, 10.0, 0.0)
        slidetxt.styleClass.add("txt")
        nombre = Label("0")
        nombre.styleClass.add("txt")
        slide = Slider(0.0, 100.0, 1.0)
        slide.prefWidth = 500.0

        val sliderBox = HBox()
        sliderBox.alignment = Pos.CENTER_LEFT
        sliderBox.spacing = 10.0
        sliderBox.children.addAll(slide, nombre)

        volumeBox.children.addAll(slidetxt, sliderBox)

        // Boîte d'affichage
        val displayBox = VBox()
        displayBox.alignment = Pos.CENTER_LEFT
        displayBox.maxWidth = 500.0

        val comboboxtxt = Label("Affichage :")
        comboboxtxt.padding = Insets(0.0, 0.0, 10.0, 0.0)
        comboboxtxt.styleClass.add("txt")
        listener.items.addAll(list)
        listener.styleClass.add("combobox")
        listener.value = listener.items[this.sizeScreen]
        listener.prefWidth = 500.0

        displayBox.children.addAll(comboboxtxt, listener)

        // Save Button
        val saveButton = WhiteButton("Save")


        // VBox principale
        val mainBox = VBox()
        mainBox.alignment = Pos.CENTER
        mainBox.spacing = 20.0
        mainBox.children.addAll(volumeBox, displayBox, saveButton)


        this.alignment = Pos.TOP_CENTER
        this.children.addAll(titre, mainBox)
    }

    fun getlist(index :Int) : String {
        return list.get(index)
    }


    override fun fixeButton(listControleur:Array<EventHandler<ActionEvent>>){
        //TODO
    }
}
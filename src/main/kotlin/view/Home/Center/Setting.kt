package view.Home.Center

import javafx.collections.ObservableArray
import javafx.scene.control.ComboBox
import javafx.scene.control.Slider
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import view.components.Title
import view.components.TransparentButton
import javafx.collections.ObservableList as ObservableList1

class Setting :HomeCenter(false) {
    var vbox : VBox = VBox()
    var title = Text()
    var listener :ComboBox<String> = ComboBox()

     private var list = listOf<String>( "720 × 480","960 × 720","1280 × 1080","1440 × 1080","1440 × 1080","2048 × 1556","3656 × 2664")
    init {

        var titre = Title()
        listener.items.addAll(list)
        listener.getStyleClass().add("combololbox")
        var slide = Slider(0.0,100.0,1.0)
        slide.getStyleClass().add("slider")



        this.children.addAll(listener,titre,slide)
    }
    fun getlist(index :Int) : String {
        return list.get(index)
    }


    override fun fixeButton(listControleur: Array<EventHandler<ActionEvent>>) {
        TODO("Not yet implemented")
    }
}
package controleur

import javafx.css.converter.StringConverter
import javafx.scene.Scene
import javafx.util.converter.NumberStringConverter
import view.Home.Center.HomeCenter
import view.Home.Center.Menu
import view.MainView


class Binding(private val vue: Menu, private val scene: Scene) {
    var vue1 = vue
    var scene1 = scene

    fun bindModeleVue() {
        vue1.PlayButton.policeheight.bind(scene1.widthProperty().divide(3))
        println(vue1.PlayButton.policeheight.value)
    }
}
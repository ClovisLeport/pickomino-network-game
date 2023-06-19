package controleur

import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.scene.shape.Arc

class BindingFloor(private val arc: Arc) {
    fun bindArcWidthToStageWidth(stageWidthProperty: ObservableValue<out Number>) {
        stageWidthProperty.addListener(object : ChangeListener<Number> {
            override fun changed(
                observable: ObservableValue<out Number>,
                oldValue: Number,
                newValue: Number
            ) {
                val width = newValue.toDouble()
                arc.centerX = width / 2
                arc.radiusX = width / 2
            }
        })
    }
}
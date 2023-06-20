package view.components

import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.shape.StrokeType

class Iluminate(w :Double, h : Double) : Rectangle() {
    init {
        this.width = w
        this.height = h
        this.arcHeight = 18.0
        this.arcWidth = 18.0
        this.fill = Color.TRANSPARENT
        this.stroke = Color.web("#F5D849")  // Couleur de la bordure
        this.strokeWidth = 4.0  // Largeur de la bordure
        //this.strokeDashArray.addAll(5.0, 5.0)  // Motif de pointillés (5 pixels pleins, 5 pixels vides)
    }
}
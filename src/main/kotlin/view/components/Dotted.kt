package view.components

import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.shape.StrokeType

class Dotted(w :Double, h : Double) : Rectangle() {
    init {
        this.width = w
        this.height = h
        this.arcHeight = 18.0
        this.arcWidth = 18.0
        this.fill = Color.TRANSPARENT
        this.stroke = Color.web("#0F1820")  // Couleur de la bordure
        this.strokeWidth = 2.0  // Largeur de la bordure
        this.strokeType = StrokeType.CENTERED  // Type de trait (pointillés)
        this.strokeDashArray.addAll(5.0, 5.0)  // Motif de pointillés (5 pixels pleins, 5 pixels vides)
    }
}
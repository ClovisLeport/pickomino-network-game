package view.components

import javafx.geometry.Pos
import javafx.scene.Group
import javafx.scene.control.Label
import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.effect.InnerShadow
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.text.Font
import javafx.scene.text.FontWeight

class Pawn(value: Int, thworm: Int) : StackPane() {
    init {
        val rectangle = Rectangle()
        rectangle.width = 86.0
        rectangle.height = 165.0
        rectangle.fill = Color.web("#FBFBF3") // Background
        rectangle.arcHeight = 16.0 // Radius
        rectangle.arcWidth = 16.0 // Radius

        // Shadow
        val boxShadow = DropShadow()
        boxShadow.radius = 4.0
        boxShadow.color = Color.rgb(0, 0, 0, 0.25)

        val insetShadow1 = InnerShadow()
        insetShadow1.radius = 2.0
        insetShadow1.offsetX = 1.0
        insetShadow1.offsetY = 0.0
        insetShadow1.color = Color.rgb(0, 0, 0, 0.25)

        val insetShadow2 = InnerShadow()
        insetShadow2.radius = 4.0
        insetShadow2.offsetX = -5.0
        insetShadow2.offsetY = -5.0
        insetShadow2.color = Color.rgb(0, 0, 0, 0.25)

        rectangle.effect = boxShadow
        boxShadow.input = insetShadow1
        insetShadow1.input = insetShadow2

        // Value
        val valueLabel = Label(value.toString())
        valueLabel.textFill = Color.web("#0F1820")
        valueLabel.font = Font.font("Helvetica",FontWeight.BOLD,48.0)

        // Line
        val line = Rectangle()
        line.width = 91.0
        line.height = 3.0
        line.fill = Color.web("#0F1820")
        line.arcWidth = 1.5
        line.arcHeight = 1.5

        // StackPane for line and value label
        val lineAndValuePane = VBox()
        lineAndValuePane.alignment = Pos.CENTER
        lineAndValuePane.children.addAll(valueLabel, line)

        // Set lineAndValuePane as the center node of the VBox
        this.alignment = Pos.CENTER
        this.children.addAll(rectangle, lineAndValuePane)
    }
}
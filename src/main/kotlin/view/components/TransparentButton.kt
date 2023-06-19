package view.components

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.text.Font

class TransparentButton(text: String) : Button() {
    init {
        // Text
        this.text = text
        this.textFill = Color.web("#FBFBF2")
        this.font =  Font.font(18.0)

        // Border Radius
        val borderRadius = CornerRadii(33.0) // Rayon de coin de 10 pixels

        // Background
        val backgroundColor = Color.TRANSPARENT
        this.background = Background(BackgroundFill(backgroundColor, CornerRadii.EMPTY, null))

        // Border
        val borderWidth = 3.0
        val borderColor = Color.web("#FBFBF2")
        this.border = Border(BorderStroke(borderColor, BorderStrokeStyle.SOLID, borderRadius, BorderWidths(borderWidth)))

        // Padding
        val paddingSize = Insets(4.0, 45.0, 4.0, 45.0)
        this.padding = paddingSize
        // Cursor
        this.cursor = javafx.scene.Cursor.HAND
    }

}
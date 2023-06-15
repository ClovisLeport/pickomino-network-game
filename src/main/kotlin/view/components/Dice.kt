package view.components

import javafx.scene.image.Image
import javafx.scene.image.ImageView

class Dice(diceNumber: Int) : ImageView() {
    init {
        // Dice image
        val diceImage = when (diceNumber) {
            1 -> Image("file:src/main/kotlin/view/assets/dice1.png")
            2 -> Image("file:src/main/kotlin/view/assets/dice2.png")
            3 -> Image("file:src/main/kotlin/view/assets/dice3.png")
            4 -> Image("file:src/main/kotlin/view/assets/dice4.png")
            5 -> Image("file:src/main/kotlin/view/assets/dice5.png")
            else -> Image("file:src/main/kotlin/view/assets/diceEarth-worm.png")
        }

        this.fitWidth = 70.0
        this.fitHeight = 70.0

        this.image = diceImage
    }
}
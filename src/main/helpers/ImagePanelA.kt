package main.helpers

import java.awt.Dimension
import java.awt.Image
import javax.swing.JPanel
import java.awt.Graphics
import java.awt.GridLayout

import javax.swing.JFrame


class ImagePanelA(val image: Image) : JPanel() {

    init {
        preferredSize = Dimension(image.getWidth(null), image.getHeight(null))
    }


    override fun paintComponent(g : Graphics) {
        super.paintComponent(g)
        if (image != null) {
            g.drawImage(image, 0, 0, null)
        }
    }
}
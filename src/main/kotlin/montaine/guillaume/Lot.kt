package org.example.montaine.guillaume.montaine.guillaume

import montaine.guillaume.Manga

data class Lot(val Quantite : Int, val Manga : Manga) {

    val quantite: Int = Quantite
    val manga: Manga = Manga

    fun getPrix(): Double {
        return this.quantite * this.manga.Prix
    }

}

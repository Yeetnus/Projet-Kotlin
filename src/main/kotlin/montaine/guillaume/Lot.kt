package org.example.montaine.guillaume.montaine.guillaume

import montaine.guillaume.Manga

data class Lot(val quantite : Int, val manga : Manga) {

    fun getPrix(): Double {
        return this.quantite * this.manga.Prix
    }

}

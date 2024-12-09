package org.example.montaine.guillaume.montaine.guillaume

import montaine.guillaume.Manga

data class Lot(val quantite : Int, val manga : Manga) {

    fun getQuantite(): Int {
        return quantite
    }

    fun getManga(): Manga {
        return manga
    }

    fun getPrix(): Double {
        return this.getQuantite() * this.getManga().getPrix()
    }

}

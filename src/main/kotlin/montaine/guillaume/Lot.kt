import montaine.guillaume.Manga

data class Lot(val Quantite: Int, val Manga: Manga) {

    fun getPrix(): Double {
        return this.Quantite * this.Manga.Prix
    }
}

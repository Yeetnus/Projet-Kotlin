import montaine.guillaume.Manga

data class Lot(val Quantite: Int, val Manga: Manga) {

    init {
        if (Quantite < 1) {
            throw IllegalArgumentException("La quantité ne peut pas être négative ou nulle")
        }
        if (Manga == null) {
            throw IllegalArgumentException("Aucun manga n'a été renseigné")
        }
    }

    fun getPrix(): Double {
        return this.Quantite * this.Manga.Prix
    }
}

package montaine.guillaume

data class Manga(val Titre: String, val Prix: Double) {

    init {
        if (Prix < 0) {
            throw IllegalArgumentException("Le prix ne peut pas être négatif")
        }
    }

}

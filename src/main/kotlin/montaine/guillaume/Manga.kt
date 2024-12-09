package montaine.guillaume

data class Manga(val Titre: String, val Prix: Double) {

    fun getTitre(): String {
        return Titre
    }

    fun getPrix(): Double {
        return Prix
    }

}

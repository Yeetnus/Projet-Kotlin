package montaine.guillaume

import org.example.montaine.guillaume.montaine.guillaume.Pays

data class Boutique(val Pays: Pays) {

    init {
        if (Pays == null) {
            throw IllegalArgumentException("Aucun pays n'a été renseigné")
        }
    }


}


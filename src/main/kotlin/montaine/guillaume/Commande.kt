package org.example.montaine.guillaume.montaine.guillaume

import Lot
import montaine.guillaume.Boutique

data class Commande(val Boutique: Boutique, val Lots: List<Lot>) {

    fun getNbMangas(): Int {
        return this.Lots.sumOf { it.Quantite }
    }

}

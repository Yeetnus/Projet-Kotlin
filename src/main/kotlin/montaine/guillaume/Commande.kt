package org.example.montaine.guillaume.montaine.guillaume

import Lot
import montaine.guillaume.Boutique
import java.util.*

data class Commande(val Boutique: Boutique, val Lots: List<Lot>) {

    fun getMontantHT(): Double {
        return String.format(Locale.US, "%.2f", this.Lots.sumOf { it.getPrix() }).toDouble()
    }

    fun getRemise(): Double {
        val montant = this.getMontantHT()
        val result: Double
        if (montant < 150) {
            result = 0.0
        } else if (montant < 200) {
            result = montant*0.02
        } else if (montant < 300) {
            result = montant*0.03
        } else if (montant < 500) {
            result = montant*0.05
        } else if (montant < 1000) {
            result = montant*0.07
        } else {
            result = montant*0.1
        }
        return String.format(Locale.US, "%.2f", result).toDouble()
    }

    fun getMontantRemise(): Double {
        return this.getMontantHT() - this.getRemise()
    }

    fun getTaxes(): Double {
        return String.format(Locale.US, "%.2f", (this.getMontantRemise()*this.Boutique.Pays.taxes)).toDouble()
    }

    fun getMontantTTC(): Double {
        return String.format(Locale.US, "%.2f", this.getMontantRemise() + this.getTaxes()).toDouble()
    }

}

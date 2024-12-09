package org.example.montaine.guillaume.montaine.guillaume

import Lot
import montaine.guillaume.Boutique
import kotlin.math.round

data class Commande(val Boutique: Boutique, val Lots: List<Lot>) {

    fun getMontantHT(): Double {
        return round(this.Lots.sumOf { it.getPrix() } * 100) / 100
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
        return round(result * 100) / 100
    }

    fun getMontantRemise(): Double {
        return this.getMontantHT() - this.getRemise()
    }

    fun getTaxes(): Double {
        return this.getMontantRemise()*this.Boutique.Pays.taxes
    }

    fun getMontantTTC(): Double {
        return round(return this.getMontantRemise() + this.getTaxes() * 100) / 100
    }

}

package org.example.montaine.guillaume.montaine.guillaume

import Lot
import montaine.guillaume.Boutique

data class Commande(val Boutique: Boutique, val Lots: List<Lot>) {

    fun getNbMangas(): Int {
        return this.Lots.sumOf { it.Quantite }
    }

    fun getMontantHT(): Double {
        return String.format("%.2f", this.Lots.sumOf { it.getPrix() }).toDouble()
    }

    fun getRemise(): Double {
        if (this.getMontantHT() < 150) {
            return 0.0
        } else if (this.getMontantHT() < 200) {
            return this.getMontantHT()*0.02
        } else if (this.getMontantHT() < 300) {
            return this.getMontantHT()*0.03
        } else if (this.getMontantHT() < 500) {
            return this.getMontantHT()*0.05
        } else if (this.getMontantHT() < 1000) {
            return this.getMontantHT()*0.07
        } else {
            return this.getMontantHT()*0.1
        }
    }

    fun getMontantRemise(): Double {
        return this.getMontantHT() - this.getRemise()
    }

    fun getTaxes(): Double {
        return this.getMontantRemise()*this.Boutique.Pays.taxes
    }

    fun getMontantTTC(): Double {
        return String.format("%.2f", this.getMontantRemise() + this.getTaxes()).toDouble()
    }

}

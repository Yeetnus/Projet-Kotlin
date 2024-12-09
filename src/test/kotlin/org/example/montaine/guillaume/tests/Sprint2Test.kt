package org.example.montaine.guillaume.tests

import Lot
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import montaine.guillaume.Boutique
import montaine.guillaume.Manga
import org.example.montaine.guillaume.montaine.guillaume.Commande
import org.example.montaine.guillaume.montaine.guillaume.Pays

class Sprint2Test:BehaviorSpec({
    context("Commande 1") {
        given("une commande") {
            val lot = ArrayList<Lot>()
            lot.add(Lot(19, Manga("Manga1", 3.99)))
            val commande = Commande(Boutique(Pays.ESPAGNE),lot)

            When("je lis le prix total") {
                val prixTTC = commande.getMontantTTC()

                Then("le prix total est 89.61") {
                    prixTTC shouldBe 89.61
                }
            }
        }
    }

    context("Commande 2") {
        given("une commande") {
            val lot = ArrayList<Lot>()
            lot.add(Lot(42, Manga("Manga1", 3.92)))
            lot.add(Lot(82, Manga("Manga2", 4.10)))
            lot.add(Lot(12, Manga("Manga2", 18.95)))
            val commande = Commande(Boutique(Pays.FRANCE),lot)

            When("je lis le prix total") {
                val prixTTC = commande.getMontantTTC()

                Then("le prix est 812.72") {
                    prixTTC shouldBe 812.72
                }
            }
        }
    }
})
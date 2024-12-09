
package org.example.montaine.guillaume.tests

import Lot
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import montaine.guillaume.Manga

class LotTest : BehaviorSpec({

    context("je veux vérifier la quantité dans un lot") {

        given("un lot") {
            val lot = Lot(3, Manga("Naruto", 10.0))

            When("je lis la quantité") {
                val quantite = lot.Quantite

                Then("la quantité est 3") {
                    quantite shouldBe 3
                }
            }
        }
    }

    context("je veux vérifier le manga dans un lot") {

        given("un lot") {
            val lot = Lot(3, Manga("Naruto", 10.0))

            When("je lis le manga") {
                val manga = lot.Manga

                Then("le manga est Naruto") {
                    manga.Titre shouldBe "Naruto"
                }
            }
        }
    }

    context("je veux vérifier le prix dans un lot") {

        given("un lot") {
            val lot = Lot(3, Manga("Naruto", 10.0))

            When("je lis le prix") {
                val prix = lot.getPrix()

                Then("le prix est 30.0") {
                    prix shouldBe 30.0
                }
            }
        }
    }
})
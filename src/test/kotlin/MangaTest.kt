
package org.example.montaine.guillaume.tests

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import montaine.guillaume.Manga
import montaine.guillaume.TicketDeCaisse

class MangaTest : BehaviorSpec({

    context("je veux qu'un manga ai un titre") {
        given("un manga") {
            val manga = Manga("One Piece",5.0)

            When("je lis le titre") {
                val titre = manga.Titre

                Then("le titre est One Piece") {
                    titre shouldNotBe null
                }
            }
        }

    }

    context("je veux qu'un manga ai un prix") {
        given("un manga") {
            val manga = Manga("One Piece",5.0)

            When("je lis le prix") {
                val prix = manga.Prix

                Then("le prix est 5.0") {
                    prix shouldNotBe null
                }
            }
        }

    }

    context("je veux qu'un manga renvoie une erreur si il a un prix négatif"){
        given("un manga") {
            val manga = Manga("One Piece",-5.0)

            When("je lis le prix") {
                val prix = manga.Prix

                Then("le prix est 5.0") {
                    val exception= shouldThrow<IllegalArgumentException> {
                        prix
                    }
                    exception.message shouldBe "Le prix ne peut pas être négatif"
                }
            }
        }

    }
})
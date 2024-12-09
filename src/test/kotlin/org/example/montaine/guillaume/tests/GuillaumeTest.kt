
package org.example.montaine.guillaume.tests

import Lot
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe
import montaine.guillaume.Manga
import montaine.guillaume.TicketDeCaisse

class GuillaumeTest : BehaviorSpec({

    context("je veux vérifier que chaque ticket a son identifiant unique") {

        given("un ticket") {
            val lot = Lot(3, Manga("Naruto", 10.0))
            val lots = listOf(lot)
            val ticket = TicketDeCaisse(lots)

            And("un 2e ticket") {
                val ticket2 = TicketDeCaisse(lots)

                When("je lis les 2 identifiants") {
                    val id1 = ticket.Id
                    val id2 = ticket2.Id

                    Then("ce n'est pas le même") {
                        id1 shouldNotBe id2
                    }

                }
            }
        }
    }})
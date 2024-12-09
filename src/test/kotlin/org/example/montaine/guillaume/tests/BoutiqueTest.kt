package org.example.montaine.guillaume.tests

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe
import montaine.guillaume.Boutique
import org.example.montaine.guillaume.montaine.guillaume.Pays

class BoutiqueTest:BehaviorSpec ({
    context("je veux qu'une boutique ai un pays") {
        given("une boutique") {
            val boutique = Boutique(Pays.FRANCE)

            When("je lis le pays") {
                val pays = boutique.Pays

                Then("le pays est France") {
                    pays shouldNotBe null
                }
            }
        }
    }
})

package org.example.montaine.guillaume

import Lot
import montaine.guillaume.Boutique
import montaine.guillaume.Manga
import montaine.guillaume.TicketDeCaisse
import org.example.montaine.guillaume.montaine.guillaume.Commande
import org.example.montaine.guillaume.montaine.guillaume.Pays

fun main() {
    val TotoShop : Boutique = Boutique(Pays.FRANCE)

    val TataShop : Boutique = Boutique(Pays.ESPAGNE)

    val lot1s2 : Lot = Lot(19, Manga("Naruto", 3.99))

    val c1s2 : List<Lot> = listOf(lot1s2)
    val commande1s2 : Commande = Commande(TataShop, c1s2)
    val ticket1s2: TicketDeCaisse = TicketDeCaisse(commande1s2)


    val lot2s2 : Lot = Lot(42, Manga("One Piece", 3.92))
    val lot3s2 : Lot = Lot(82, Manga("AOT", 4.10))
    val lot4s2 : Lot = Lot(12, Manga("DBZ", 18.95))

    val c2s2 : List<Lot> = listOf(lot2s2, lot3s2, lot4s2)
    val commande2s2 : Commande = Commande(TotoShop, c2s2)
    val ticket2s2 : TicketDeCaisse = TicketDeCaisse(commande2s2)


    println(ticket1s2.printTicket())
    println(ticket2s2.printTicket())
}
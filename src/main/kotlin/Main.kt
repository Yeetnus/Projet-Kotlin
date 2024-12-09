
package org.example.montaine.guillaume

import Lot
import montaine.guillaume.Boutique
import montaine.guillaume.Manga
import montaine.guillaume.TicketDeCaisse
import org.example.montaine.guillaume.montaine.guillaume.Commande
import org.example.montaine.guillaume.montaine.guillaume.Pays

fun main() {
    val TotoShop : Boutique = Boutique(Pays.FRANCE)


    val lot1 : Lot = Lot(19, Manga("Naruto", 3.99))
    val c1 : List<Lot> = listOf(lot1)

    val commande1 : Commande = Commande(TotoShop, c1)
    val ticket1: TicketDeCaisse = TicketDeCaisse(commande1)

    
    val lot2 : Lot = Lot(42, Manga("One Piece", 3.92))
    val lot3 : Lot = Lot(82, Manga("AOT", 4.10))
    val c2 : List<Lot> = listOf(lot2, lot3)

    val commande2 : Commande = Commande(TotoShop, c2)
    val ticket2 : TicketDeCaisse = TicketDeCaisse(commande2)


    println(ticket1.printTicket())
    println(ticket2.printTicket())
}
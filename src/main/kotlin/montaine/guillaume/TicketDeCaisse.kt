
package montaine.guillaume

import org.example.montaine.guillaume.montaine.guillaume.Commande
import java.util.*
import kotlin.math.round


data class TicketDeCaisse(val Commande: Commande) {

    companion object {
        private var counter: Int = 0
    }

    val Id: String

    init {
        counter++
        Id = String.format("%02d", counter)
    }

    fun printTicket(): StringBuffer {

        val Taxe: Double = Commande.getTaxes()
        val Remise: Double = Commande.getRemise()

        val ticket: StringBuffer = StringBuffer()
        ticket.append("Ticket ${Id}\n\n")

        for (lot in Commande.Lots) {
            val montant = round(lot.Quantite*lot.Manga.Prix * 100) / 100
            ticket.append("${lot.Manga.Titre} x ${lot.Quantite} = ${montant}€\n")
        }


        ticket.append("\nTotalHt: ${Commande.getMontantHT()}\n\n")

        ticket.append("Remise: ${Commande.getRemise()}\n")
        ticket.append("Montant après remise: ${Commande.getMontantRemise()}\n")
        ticket.append("Taxe: ${Commande.getTaxes()}\n")
        ticket.append("Total TTC: ${Commande.getMontantTTC()}\n")

        return ticket
    }
}
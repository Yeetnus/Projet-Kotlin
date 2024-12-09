
package montaine.guillaume

import org.example.montaine.guillaume.montaine.guillaume.Commande
import java.util.*
import kotlin.math.round


data class TicketDeCaisse(val Commande: Commande) {

    init {
        if (Commande == null) {
            throw IllegalArgumentException("Aucune commande n'a été renseignée")
        }
    }

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


        ticket.append("\nTotalHt: ${round(Commande.getMontantHT() * 100) / 100}\n\n")

        ticket.append("Remise: ${round(Commande.getRemise() * 100) / 100}\n")
        ticket.append("Montant après remise: ${round(Commande.getMontantRemise() * 100) / 100}\n")
        ticket.append("Taxe: ${round(Commande.getTaxes() * 100) / 100}\n")
        ticket.append("Total TTC: ${Commande.getMontantTTC()}\n")

        return ticket
    }
}
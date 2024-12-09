
package montaine.guillaume

import Lot
import de.huxhorn.sulky.ulid.ULID;
import org.example.montaine.guillaume.montaine.guillaume.Commande


data class TicketDeCaisse(val Commande: Commande, val Id: String = ULID().nextULID()) {

    var TotalTtc: Double = 0.0
    val Taxe: Double = 0.0
    val Remise: Double = 0.0

    fun printTicket(): StringBuffer {

        val Taxe: Double = Commande.getTaxes()
        val Remise: Double = Commande.getRemise()

        val ticket: StringBuffer = StringBuffer()
        ticket.append("Ticket $Id\n\n")

        val totalesDesLots: List<Double> = Commande.Lots.map { lot -> lot.Quantite*lot.Manga.Prix }

        for (lot in Commande.Lots) {
            ticket.append("${lot.Manga.Titre} x ${lot.Quantite} = ${lot.Quantite*lot.Manga.Prix}€\n")
        }


        ticket.append("TotalHt: ${Commande.getMontantHT()}\n\n")

        ticket.append("Remise: ${Commande.getRemise()}\n")
        ticket.append("Taxe: ${Commande.getTaxes()}\n")
        ticket.append("Total TTC: ${Commande.getMontantTTC()}\n")

        return ticket
    }
}
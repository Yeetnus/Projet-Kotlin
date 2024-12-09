
package montaine.guillaume

import Lot
import de.huxhorn.sulky.ulid.ULID;
import org.example.montaine.guillaume.montaine.guillaume.Commande


data class TicketDeCaisse(val Commande: Commande, val Id: String = ULID().nextULID()) {

    var TotalTtc: Double = 0.0
    val Taxe: Double = Commande.Boutique.Pays.taxes
    val Remise: Double = 0.0

    fun printTicket(): StringBuffer {
        val ticket: StringBuffer = StringBuffer()
        ticket.append("Ticket $Id\n\n")

        val totalesDesLots: List<Double> = Commande.Lots.map { lot -> lot.Quantite*lot.Manga.Prix }

        for (lot in Commande.Lots) {
            ticket.append("${lot.Manga.Titre} x ${lot.Quantite} = ${lot.Quantite*lot.Manga.Prix}€\n")
        }

        var totalHt = totalesDesLots.sum()
        ticket.append("TotalHt: $totalHt\n\n")

        TotalTtc = totalHt + (totalHt * Taxe) - (totalHt * Remise)

        ticket.append("Taxe: $Taxe\n")
        ticket.append("Remise: $Remise\n")
        ticket.append("Total TTC: $TotalTtc\n")

        return ticket
    }
}
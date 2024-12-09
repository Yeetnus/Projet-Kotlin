
package montaine.guillaume

import Lot
import de.huxhorn.sulky.ulid.ULID;


data class TicketDeCaisse(val Id: String = ULID().nextULID(), val Lot: List<Lot>) {

    var TotalTtc: Double = 0.0
    val Taxe: Double = 0.0
    val Remise: Double = 0.0

    fun printTicket(): StringBuffer {
        val ticket: StringBuffer = StringBuffer()
        ticket.append("Ticket $Id\n\n")

        val totalesDesLots: List<Double> = Lot.map { lot -> lot.Quantite*lot.Manga.Prix }

        for (lot in Lot) {
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
package ion.carpintero.recyclerview2

// Aquesta data class representa un cotxe amb les dades necessàries per mostrar-lo a la llista
data class Cotxe(
    val name: String,        // Nom del cotxe que es mostrarà al títol de la targeta i a la pantalla de detalls
    val price: String,       // Preu en format textual (ex: "9.500€")
    val yearKm: String,      // Any i quilòmetres (ex: "2016 · 145.000 km")
    val imageUrl: String,    // URL de la imatge que s'ha de carregar amb Glide
    val description: String  // Descripció completa que s'exhibirà a l'activitat de detalls
)

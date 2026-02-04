package ion.carpintero.recyclerview2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.jvm.java

// Adapter pel RecyclerView que rep una llista de Cotxe i instancìa les targetes i les emplena amb dades.
class CotxeAdapter(private val cotxes: List<Cotxe>) :
    RecyclerView.Adapter<CotxeAdapter.CarViewHolder>() {

    // ViewHolder: manté les referències a les vistes d'una targeta per evitar un findViewById repetit
    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imatgeCotxe: ImageView = itemView.findViewById(R.id.imatgeCotxe) // ImageView de la targeta
        val tvCarName: TextView = itemView.findViewById(R.id.tvCarName)       // TextView del nom
        val tvCarPrice: TextView = itemView.findViewById(R.id.tvCarPrice)     // TextView del preu
        val tvCarYearKm: TextView = itemView.findViewById(R.id.tvCarYearKm)   // TextView any i km
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        // Inflate del layout de la targeta i creació del ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.targeta, parent, false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int = cotxes.size // Quantitat d'elements de la llista

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cotxes[position]

        // Assigno les propietats del model a les vistes corresponents
        holder.tvCarName.text = car.name
        holder.tvCarPrice.text = car.price
        holder.tvCarYearKm.text = car.yearKm

        // Carrego la imatge amb la llibreria Glide
        Glide.with(holder.itemView.context)
            .load(car.imageUrl)
            .into(holder.imatgeCotxe)

        // Click listener: quan es toca una targeta, obro el DetallsActivity i li passo les dades
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetallsActivity::class.java)
            intent.putExtra("name", car.name)
            intent.putExtra("price", car.price)
            intent.putExtra("yearKm", car.yearKm)
            intent.putExtra("imageUrl", car.imageUrl)
            intent.putExtra("description", car.description)
            holder.itemView.context.startActivity(intent)
        }
    }
}

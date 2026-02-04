package ion.carpintero.recyclerview2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

// Activity que mostra els detalls d'un element seleccionat
class DetallsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalls)

        // Obtenció de referències a les vistes del layout (ImageView i TextViews)
        val imgDetail = findViewById<ImageView>(R.id.imgDetail)
        val tvDetailName = findViewById<TextView>(R.id.tvDetailName)
        val tvDetailPrice = findViewById<TextView>(R.id.tvDetailPrice)
        val tvDetailYearKm = findViewById<TextView>(R.id.tvDetailYearKm)
        val tvDetailDescription = findViewById<TextView>(R.id.tvDetailDescription)

        // Llegim les dades passades via Intent des de l'adaptador (nom, preu, any/km, url, descripció)
        val marcamodel = intent.getStringExtra("name")
        val preu = intent.getStringExtra("price")
        val annyKilometres = intent.getStringExtra("yearKm")
        val urlImatge = intent.getStringExtra("imageUrl")
        val descripcio = intent.getStringExtra("description")

        // Assigno les dades a les vistes corresponents
        tvDetailName.text = marcamodel
        tvDetailPrice.text = preu
        tvDetailYearKm.text = annyKilometres
        tvDetailDescription.text = descripcio

        // Carrego la imatge de manera asíncrona amb Glide (gestiona descàrrega i cache)
        Glide.with(this)
            .load(urlImatge)
            .into(imgDetail)
    }
}

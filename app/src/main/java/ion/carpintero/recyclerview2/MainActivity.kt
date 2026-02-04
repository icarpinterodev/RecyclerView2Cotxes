package ion.carpintero.recyclerview2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerCarsContenidor = findViewById<RecyclerView>(R.id.recyclerCarsContenidor)

        // Faig una llista d'exemple de cotxes.
        val cotxes = listOf(
            Cotxe(
                "Volkswagen Golf",
                "9.500€",
                "2016 · 145.000 km",
                "https://upload.wikimedia.org/wikipedia/commons/4/44/VW_Golf_1.6_TDI_BlueMotion_Technology_Comfortline_%28VII%29_%E2%80%93_Frontansicht%2C_31._Dezember_2012%2C_D%C3%BCsseldorf.jpg",
                "Golf en bon estat, revisió al dia, consum baix."
            ),
            Cotxe(
                "BMW Serie 1",
                "12.200€",
                "2017 · 120.000 km",
                "https://upload.wikimedia.org/wikipedia/commons/f/f8/2019_BMW_118i_SE_1.5_Front.jpg",
                "Vendo este BMW Serie 1 porque soy tonto y me quiero comprar un coche a pilas."
            ),
            Cotxe(
                "Mazda Laputa",
                "3.900€",
                "2002 · 30.000 km",
                "https://imagenes.autobild.es/files/image_1920_1080/uploads/imagenes/2023/05/29/68cd7f16d77c4.jpeg",
                "Bon manteniment i model, amb nom d'una muntanya que ningú coneix. poc kilometratge!!"
            )
        )

        // Configuro el RecyclerView amb un LinearLayoutManager (llista vertical)
        recyclerCarsContenidor.layoutManager = LinearLayoutManager(this)
        // Assigno l'adaptador que gestionarà la creació i el vincle de les targetes
        recyclerCarsContenidor.adapter = CotxeAdapter(cotxes)
    }
}

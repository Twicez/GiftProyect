package mx.edu.potros.gift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
class GiftDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gift_details)

        // Obtener la información del regalo desde el intent
        val giftName = intent.getStringExtra("giftName")
        val friendName = intent.getStringExtra("friendName")
        val giftPrice = intent.getDoubleExtra("giftPrice", 0.0)

        // Actualizar la interfaz de usuario
        findViewById<TextView>(R.id.textViewGiftName).text = giftName
        findViewById<TextView>(R.id.textViewFriendName).text = "$friendName desea este regalo"
        findViewById<TextView>(R.id.textViewGiftPrice).text = "Precio: $giftPrice€"

        // Configurar el evento del botón "Agregar al carrito"
        findViewById<Button>(R.id.buttonAddToCart).setOnClickListener {
            // Aquí puedes agregar la lógica para agregar el regalo al carrito
            Toast.makeText(this, "Agregado al carrito", Toast.LENGTH_SHORT).show()
        }
    }
}
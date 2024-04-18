package mx.edu.potros.gift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageView
class FriendProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend_profile)

        // ...

        // Configurar el evento de clic para cada regalo
        findViewById<ImageView>(R.id.giftImage1).setOnClickListener {
            openGiftDetails("Balón", "Juan Carlos Isai", 29.99)
        }

        findViewById<ImageView>(R.id.giftImage2).setOnClickListener {
            openGiftDetails("Audífonos", "Juan Carlos Isai", 59.99)
        }

        // Agrega los demás eventos de clic para los demás regalos
    }

    private fun openGiftDetails(giftName: String, friendName: String, giftPrice: Double) {
        val intent = Intent(this, GiftDetailsActivity::class.java)
        intent.putExtra("giftName", giftName)
        intent.putExtra("friendName", friendName)
        intent.putExtra("giftPrice", giftPrice)
        startActivity(intent)
    }
}
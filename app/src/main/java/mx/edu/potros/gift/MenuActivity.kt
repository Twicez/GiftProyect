package mx.edu.potros.gift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.ImageView

class  MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val imageView1 = findViewById<ImageView>(R.id.imageView1)
        imageView1.setOnClickListener {
            val intent = Intent(this, FriendProfileActivity::class.java)
            startActivity(intent)
        }

        // Repite este proceso para los demás ImageViews si quieres que cada uno vaya a una actividad diferente.
    }
}

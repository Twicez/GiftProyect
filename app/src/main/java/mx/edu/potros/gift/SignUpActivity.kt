package mx.edu.potros.gift
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import mx.edu.potros.gift.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Configurar OnClickListener para el botón de registro
        binding.signUpAppCompatButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            // Verificar si los campos de correo electrónico y contraseña están vacíos
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Registrar al usuario en Firebase
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Registro exitoso, redirigir al usuario a la actividad principal
                            Toast.makeText(
                                this,
                                "Registro exitoso",
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            // Si el registro falla, mostrar un mensaje de error al usuario
                            Toast.makeText(
                                this,
                                "Error al registrar. Por favor, inténtelo de nuevo.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } else {
                // Si los campos de correo electrónico y contraseña están vacíos, mostrar un mensaje de error
                Toast.makeText(
                    this,
                    "Por favor, complete todos los campos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

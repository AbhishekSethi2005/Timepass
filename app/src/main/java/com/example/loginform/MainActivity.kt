import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginform.R

class MainActivity : AppCompatActivity() {

    // Key to store login state in SharedPreferences
    private val PREFS_NAME = "myPrefs"
    private val LOGIN_STATUS_KEY = "isLoggedIn"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check if user is already logged in
        val sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean(LOGIN_STATUS_KEY, false)

        if (isLoggedIn) {
            // If user is logged in, skip login screen and go to MainActivity
            navigateToHomeScreen()
        } else {
            setContentView(R.layout.activity_main)

            val usernameInput = findViewById<EditText>(R.id.username_input)
            val passwordInput = findViewById<EditText>(R.id.password_input)
            val loginButton = findViewById<Button>(R.id.login_button)

            loginButton.setOnClickListener {
                val username = usernameInput.text.toString()
                val password = passwordInput.text.toString()

                // Simple login validation (you can replace this with real authentication logic)
                if (username == "admin" && password == "password") {
                    // Save login state in SharedPreferences
                    val editor = sharedPreferences.edit()
                    editor.putBoolean(LOGIN_STATUS_KEY, true)
                    editor.apply()

                    // Navigate to home screen
                    navigateToHomeScreen()
                } else {
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun navigateToHomeScreen() {
        // Here you can navigate to the HomeActivity or main screen of your app
        startActivity(Intent(this, HomeActivity::class.java))
        finish()  // Close login screen so user can't go back
    }
}

import android.content.Context
import android.content.Intent
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    private val PREFS_NAME = "myPrefs"
    private val LOGIN_STATUS_KEY = "isLoggedIn"

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        val logoutButton = findViewById<Button>(R.id.logout_button)
        logoutButton.setOnClickListener {
            // Clear login state in SharedPreferences
            val sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean(LOGIN_STATUS_KEY, false)
            editor.apply()

            // Navigate back to login screen
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun Intent(homeActivity: HomeActivity, java: Class<MainActivity>): Any {
        return true
    }
}

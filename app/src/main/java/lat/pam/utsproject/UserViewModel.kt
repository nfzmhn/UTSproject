package lat.pam.utsproject.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPreferences = application.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun registerUser(username: String, email: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("username_$username", username)
        editor.putString("password_$username", password)
        editor.apply()
    }

    fun isUserValid(username: String, password: String): Boolean {
        val savedPassword = sharedPreferences.getString("password_$username", null)
        return savedPassword == password
    }

    fun isUsernameTaken(username: String): Boolean {
        return sharedPreferences.contains("username_$username")
    }
}

package lat.pam.utsproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)
        val foodName = intent.getStringExtra("FOOD_NAME")
        val foodNameTextView = findViewById<TextView>(R.id.etFoodName)
        foodNameTextView.text = foodName
        Log.d("OrderActivity", "Food Name received: $foodName")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOrder = findViewById<Button>(R.id.btnOrder)
        btnOrder.setOnClickListener {
            val NumberOfServing= findViewById<EditText>(R.id.etNumberOfServings).text.toString()
            val orderingName = findViewById<EditText>(R.id.etOrderingName).text.toString()
            val additionalNotes = findViewById<EditText>(R.id.etAdditionalNotes).text.toString()

            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("FOOD_NAME", foodName)
            intent.putExtra("NUMBER_OF_SERVINGS", NumberOfServing)
            intent.putExtra("ORDERING_NAME", orderingName)
            intent.putExtra("ADDITIONAL_NOTES", additionalNotes)

            startActivity(intent)
        }
    }
}
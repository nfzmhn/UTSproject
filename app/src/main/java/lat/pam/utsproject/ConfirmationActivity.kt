package lat.pam.utsproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        val foodName = intent.getStringExtra("FOOD_NAME")
        val NumberOfServing = intent.getStringExtra("NUMBER_OF_SERVINGS")
        val orderingName = intent.getStringExtra("ORDERING_NAME")
        val additionalNotes = intent.getStringExtra("ADDITIONAL_NOTES")

        val foodNameTextView = findViewById<TextView>(R.id.tvFoodName)
        val servingsTextView = findViewById<TextView>(R.id.tvNumberOfServings)
        val orderingNameTextView = findViewById<TextView>(R.id.tvOrderingName)
        val additionalNotesTextView = findViewById<TextView>(R.id.tvAdditionalNotes)

        foodNameTextView.text = foodName
        servingsTextView.text = "Number of Servings: $NumberOfServing"
        orderingNameTextView.text = "Ordering Name: $orderingName"
        additionalNotesTextView.text = "Additional Notes: $additionalNotes"


        val backButton = findViewById<Button>(R.id.backtoMenu)
        backButton.setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

package com.example.pacsxvirofoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class groups_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groups_page)

        //Going to the homepage
        val home_button: Button = findViewById(R.id.to_home)
        home_button.setOnClickListener {
            val intent = Intent(this, homepage::class.java)
            startActivity(intent)
        }

        //Already on the groups page
        val groups_button: Button = findViewById(R.id.to_groups)
        groups_button.setOnClickListener {
            Toast.makeText(this,"Already on Groups Page",Toast.LENGTH_SHORT).show()
        }

        //Going to the Profile page
        val profile_button: Button = findViewById(R.id.to_profile)
        profile_button.setOnClickListener {
            val intent = Intent(this, profile_page::class.java)
            startActivity(intent)
        }

        // Get reference to the cardsContainer
        val cardsContainer: LinearLayout = findViewById(R.id.cardsContainer)

        // Create a list of static card data
        val groupDataList = listOf(
            GroupData("Practical Application of Computer Science", "PACS", "Helping students create projects", "Science", "TMU"),
            GroupData("Computer Science Course Union", "CSCU", "Creating fun events for Computer Science students", "Science", "TMU"),
            GroupData("Toronto Metropolitan EnVIROnmental Club", "VIRO", "Helping making the school more environmentally friendly", "Science", "TMU"),

            // Add more card data as needed
        )

        // Iterate through the list of card data and create card views
        groupDataList.forEachIndexed { index, groupData ->
            val cardView = createCardView(groupData, index)
            cardsContainer.addView(cardView)
        }
    }

    private fun createCardView(groupData: GroupData, position: Int): View {
        // Inflate the card layout from card_items.xml
        val cardView = LayoutInflater.from(this).inflate(R.layout.group_items, null) as CardView

// Find views in the inflated card layout
        val shortNameTextView: TextView = cardView.findViewById(R.id.shortName)
        val longNameTextView: TextView = cardView.findViewById(R.id.longName)
        val descriptionTextView: TextView = cardView.findViewById(R.id.description)
        val schoolTextView: TextView = cardView.findViewById(R.id.school)
        val facultyTextView: TextView = cardView.findViewById(R.id.faculty)


        // Set data to the views
        shortNameTextView.text = "${groupData.short_name}"
        longNameTextView.text = "${groupData.long_name}"
        descriptionTextView.text = "${groupData.club_description}"
        schoolTextView.text = "${groupData.school_name}"
        facultyTextView.text = "${groupData.faculty_name}"

        // Alternate background colors based on the position
        if (position % 2 == 0) {
            cardView.findViewById<LinearLayout>(R.id.cardContentLayout)
                .setBackgroundColor(ContextCompat.getColor(this, R.color.light_blue))
        } else {
            cardView.findViewById<LinearLayout>(R.id.cardContentLayout)
                .setBackgroundColor(ContextCompat.getColor(this, R.color.light_green))
        }

        return cardView
    }
}


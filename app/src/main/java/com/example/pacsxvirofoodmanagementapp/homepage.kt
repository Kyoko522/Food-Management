package com.example.pacsxvirofoodmanagementapp

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.pacsxvirofoodmanagementapp.CardData

class homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        //going to the profile page
        val to_profile: Button = this.findViewById(R.id.profileButton)
        to_profile.setOnClickListener {
            val intent = Intent(this, activity_profile::class.java)
            startActivity(intent)
        }

        //going to the groups page
//        val groups_but: Button = this.findViewById(R.id.to_groups)
//        groups_but.setOnClickListener {
//            val intent = Intent(this, student_groups::class.java)
//            startActivity(intent)
//        }

        //already on the homepage
        val home_but: Button = findViewById(R.id.to_home)
        home_but.setOnClickListener {
            Toast.makeText(this,"Already at home", Toast.LENGTH_SHORT).show()
        }


        // Get reference to the cardsContainer
        val cardsContainer: LinearLayout = findViewById(R.id.cardsContainer)

        // Create a list of static card data
        val cardDataList = listOf(
            CardData("PACS", "Location A", "20", "There are 5 pizzas, vegetarian, and meat options are available. All Halal", "6pm", true, true, true, true, true, true, true, true, true, true, true, true),
            CardData("VIRO", "KHW 224", "60", "There are 5 pizzas, vegetarian, and meat options are available. All Halal", "8pm", false, true, true, true, true, false, false, false, false, true, true, false),
            CardData("MPCU", "Location B", "25", "There are 5 pizzas, vegetarian, and meat options are available. All Halal", "6pm", false, false, false, false, false, false, false, false, false, false, false, true),
            CardData("PACS", "Location A", "20", "There are 5 pizzas, vegetarian, and meat options are available. All Halal", "6pm", true, true, true, true, true, true, true, true, true, true, true, true),
            CardData("VIRO", "KHW 224", "60", "There are 5 pizzas, vegetarian, and meat options are available. All Halal", "8pm", false, true, true, true, true, false, false, false, false, true, true, false),
            CardData("MPCU", "Location B", "25", "There are 5 pizzas, vegetarian, and meat options are available. All Halal", "6pm", false, false, false, false, false, false, false, false, false, false, false, true),
            // Add more card data as needed
        )

        // Iterate through the list of card data and create card views
        cardDataList.forEachIndexed { index, cardData ->
            val cardView = createCardView(cardData, index)

            cardsContainer.addView(cardView)
        }
    }

    private fun createCardView(cardData: CardData, position: Int): View {
        // Inflate the card layout from card_item.xml
        val cardView = LayoutInflater.from(this).inflate(R.layout.card_items, null) as CardView

        // Find views in the inflated card layout
        val clubNameTextView: TextView = cardView.findViewById(R.id.clubName)
        val pickupLocationTextView: TextView = cardView.findViewById(R.id.pickupLocation)
        val stockLeftTextView: TextView = cardView.findViewById(R.id.stockLeft)

        // Set data to the views
        clubNameTextView.text = "Club Name: ${cardData.club_name}"
        pickupLocationTextView.text = "Pickup Location: ${cardData.pickup_location}"
        stockLeftTextView.text = "Stock Left: ${cardData.stock_left}"

        // Handle card click to show the pop-up
        cardView.setOnClickListener {
            showPopup(cardData, position)
        }

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

    private fun showPopup(cardData: CardData, position: Int) {
        // Create a dialog
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.card_pop_up) // Assuming you have a layout for the pop-up

        // Find views in the dialog layout
        val clubNameTextView: TextView = dialog.findViewById(R.id.clubName)
        val pickupLocationTextView: TextView = dialog.findViewById(R.id.pickupLocation)
        val stockLeftTextView: TextView = dialog.findViewById(R.id.stockLeft)
        val descriptionTextView: TextView = dialog.findViewById(R.id.description)
        val availabilityTextView: TextView = dialog.findViewById(R.id.availability)

        // Set data to the views
        clubNameTextView.text = "Club Name: ${cardData.club_name}"
        pickupLocationTextView.text = "Pickup Location: ${cardData.pickup_location}"
        stockLeftTextView.text = "Stock Left: ${cardData.stock_left}"
        descriptionTextView.text = "Additional Information: ${cardData.description}"
        availabilityTextView.text = "Time: ${cardData.availability}"

        // Find the root layout in the pop-up
        val popUpLayout: LinearLayout = dialog.findViewById(R.id.card_popup)

        // Set background color for the pop-up layout
        val backgroundColor = if (position % 2 == 0) {
            ContextCompat.getColor(this, R.color.light_blue)
        } else {
            ContextCompat.getColor(this, R.color.light_green)
        }
        popUpLayout.setBackgroundColor(backgroundColor)

        // Find the GridLayout in the pop-up
        val gridLayout: GridLayout = dialog.findViewById(R.id.grid_popup)

        // Set background color for the GridLayout in the pop-up
        gridLayout.setBackgroundColor(backgroundColor)

        // Find the CheckBoxes in the GridLayout
        val checkboxes = arrayOf(
            dialog.findViewById<CheckBox>(R.id.checkboxVegan),
            dialog.findViewById<CheckBox>(R.id.checkboxBeef),
            dialog.findViewById<CheckBox>(R.id.checkboxVegetarian),
            dialog.findViewById<CheckBox>(R.id.checkboxChicken),
            dialog.findViewById<CheckBox>(R.id.checkboxHalal),
            dialog.findViewById<CheckBox>(R.id.checkboxFish),
            dialog.findViewById<CheckBox>(R.id.checkboxDairyFree),
            dialog.findViewById<CheckBox>(R.id.checkboxShellfish),
            dialog.findViewById<CheckBox>(R.id.checkboxGlutenFree),
            dialog.findViewById<CheckBox>(R.id.checkboxPork),
            dialog.findViewById<CheckBox>(R.id.checkboxPeanutFree),
            dialog.findViewById<CheckBox>(R.id.checkboxOtherMeat)
        )

        // Set CheckBox states
        checkboxes[0].isChecked = cardData.vegan
        checkboxes[1].isChecked = cardData.beef
        checkboxes[2].isChecked = cardData.vegetarian
        checkboxes[3].isChecked = cardData.chicken
        checkboxes[4].isChecked = cardData.halal
        checkboxes[5].isChecked = cardData.fish
        checkboxes[6].isChecked = cardData.dairy_free
        checkboxes[7].isChecked = cardData.shellfish
        checkboxes[8].isChecked = cardData.gluten_free
        checkboxes[9].isChecked = cardData.pork
        checkboxes[10].isChecked = cardData.peanut_free
        checkboxes[11].isChecked = cardData.other_meat

        // Show the dialog
        dialog.show()
    }
}

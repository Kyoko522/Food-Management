package com.example.pacsxvirofoodmanagementapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.pacsxvirofoodmanagementapp.CardData

class homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        // Get reference to the cardsContainer
        val cardsContainer: LinearLayout = findViewById(R.id.cardsContainer)

        // Create a static card data
        val cardData = CardData(
            "Pacs", "Location A", "20",
            "There are 5 pizzas, vegetarian, and meat options are available. All Halal", "6pm",
            false, true, true, true, true, false, false, false, false, false, true, true
        )

        val cardData2 = CardData(
            "Pacs", "Location A", "20",
            "There are 5 pizzas, vegetarian, and meat options are available. All Halal", "8pm",
            false, true, true, true, true, false, false, false, false, false, true, true
        )

        // Create and add the card view
        val cardView = createCardView(cardData)
        cardsContainer.addView(cardView)

        val cardView2 = createCardView(cardData2)
        cardsContainer.addView(cardView2)

        // You can add more cards by repeating the above process
    }

    private fun createCardView(cardData: CardData): View {
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
            val fragmentManager = supportFragmentManager
            val cardPopupFragment = CardPopupFragment()

            // Pass data to the pop-up fragment
            val args = Bundle().apply {
                putString(CardPopupFragment.CLUB_NAME, cardData.club_name)
                putString(CardPopupFragment.PICKUP_LOCATION, cardData.pickup_location)
                putString(CardPopupFragment.STOCK_LEFT, cardData.stock_left)
                putString(CardPopupFragment.DESCRIPTION, cardData.description)
                putString(CardPopupFragment.AVAILABILITY, cardData.availability)

                // Add checkbox states to the arguments
                putBoolean(CardPopupFragment.IS_VEGAN, cardData.vegan)
                putBoolean(CardPopupFragment.HAS_BEEF, cardData.beef)
                putBoolean(CardPopupFragment.IS_VEGETARIAN, cardData.vegetarian)
                putBoolean(CardPopupFragment.HAS_CHICKEN, cardData.chicken)
                putBoolean(CardPopupFragment.IS_HALAL, cardData.halal)
                putBoolean(CardPopupFragment.HAS_FISH, cardData.fish)
                putBoolean(CardPopupFragment.IS_DAIRY_FREE, cardData.dairy_free)
                putBoolean(CardPopupFragment.HAS_SHELLFISH, cardData.shellfish)
                putBoolean(CardPopupFragment.IS_GLUTEN_FREE, cardData.gluten_free)
                putBoolean(CardPopupFragment.HAS_PORK, cardData.pork)
                putBoolean(CardPopupFragment.IS_PEANUT_FREE, cardData.peanut_free)
                putBoolean(CardPopupFragment.HAS_OTHER_MEAT, cardData.other_meat)
            }

            cardPopupFragment.arguments = args
            cardPopupFragment.show(fragmentManager, "card_popup")
        }

        return cardView
    }
}

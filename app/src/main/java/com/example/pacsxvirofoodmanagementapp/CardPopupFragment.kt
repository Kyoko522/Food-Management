package com.example.pacsxvirofoodmanagementapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class CardPopupFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.card_pop_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve data from arguments
        val clubName = arguments?.getString(CLUB_NAME)
        val pickupLocation = arguments?.getString(PICKUP_LOCATION)
        val stockLeft = arguments?.getString(STOCK_LEFT)
        val description = arguments?.getString(DESCRIPTION)
        val availability = arguments?.getString(AVAILABILITY)

        // Set data to the views in the popup using findViewById
        val clubNameTextView: TextView = view.findViewById(R.id.clubName)
        val pickupLocationTextView: TextView = view.findViewById(R.id.pickupLocation)
        val stockLeftTextView: TextView = view.findViewById(R.id.stockLeft)
        val descriptionTextView: TextView = view.findViewById(R.id.description)
        val availabilityTextView: TextView = view.findViewById(R.id.availability)

        clubNameTextView.text = "Club Name: $clubName"
        pickupLocationTextView.text = "Pickup Location: $pickupLocation"
        stockLeftTextView.text = "Stock Left: $stockLeft"
        descriptionTextView.text = "Description: $description"
        availabilityTextView.text = "Time: $availability"

        // Set up checkboxes
        val isVeganCheckBox: CheckBox = view.findViewById(R.id.checkboxVegan)
        val hasBeefCheckBox: CheckBox = view.findViewById(R.id.checkboxBeef)
        val isVegetarianCheckBox: CheckBox = view.findViewById(R.id.checkboxVegetarian)
        val hasChickenCheckBox: CheckBox = view.findViewById(R.id.checkboxChicken)
        val isHalalCheckBox: CheckBox = view.findViewById(R.id.checkboxHalal)
        val hasFishCheckBox: CheckBox = view.findViewById(R.id.checkboxFish)
        val isDairyFreeCheckBox: CheckBox = view.findViewById(R.id.checkboxDairyFree)
        val hasShellfishCheckBox: CheckBox = view.findViewById(R.id.checkboxShellfish)
        val isGlutenFreeCheckBox: CheckBox = view.findViewById(R.id.checkboxGlutenFree)
        val hasPorkCheckBox: CheckBox = view.findViewById(R.id.checkboxPork)
        val isPeanutFreeCheckBox: CheckBox = view.findViewById(R.id.checkboxPeanutFree)
        val hasOtherMeatCheckBox: CheckBox = view.findViewById(R.id.checkboxOtherMeat)

        // Retrieve checkbox states
        val isVegan = arguments?.getBoolean(IS_VEGAN) ?: false
        val hasBeef = arguments?.getBoolean(HAS_BEEF) ?: false
        val isVegetarian = arguments?.getBoolean(IS_VEGETARIAN) ?: false
        val hasChicken = arguments?.getBoolean(HAS_CHICKEN) ?: false
        val isHalal = arguments?.getBoolean(IS_HALAL) ?: false
        val hasFish = arguments?.getBoolean(HAS_FISH) ?: false
        val isDairyFree = arguments?.getBoolean(IS_DAIRY_FREE) ?: false
        val hasShellfish = arguments?.getBoolean(HAS_SHELLFISH) ?: false
        val isGlutenFree = arguments?.getBoolean(IS_GLUTEN_FREE) ?: false
        val hasPork = arguments?.getBoolean(HAS_PORK) ?: false
        val isPeanutFree = arguments?.getBoolean(IS_PEANUT_FREE) ?: false
        val hasOtherMeat = arguments?.getBoolean(HAS_OTHER_MEAT) ?: false

        // Set checkbox states
        isVeganCheckBox.isChecked = isVegan
        hasBeefCheckBox.isChecked = hasBeef
        isVegetarianCheckBox.isChecked = isVegetarian
        hasChickenCheckBox.isChecked = hasChicken
        isHalalCheckBox.isChecked = isHalal
        hasFishCheckBox.isChecked = hasFish
        isDairyFreeCheckBox.isChecked = isDairyFree
        hasShellfishCheckBox.isChecked = hasShellfish
        isGlutenFreeCheckBox.isChecked = isGlutenFree
        hasPorkCheckBox.isChecked = hasPork
        isPeanutFreeCheckBox.isChecked = isPeanutFree
        hasOtherMeatCheckBox.isChecked = hasOtherMeat
    }

    companion object {
        const val CLUB_NAME = "club_name"
        const val PICKUP_LOCATION = "pickup_location"
        const val STOCK_LEFT = "stock_left"
        const val DESCRIPTION = "description"
        const val AVAILABILITY = "availability"

        const val IS_VEGAN = "is_vegan"
        const val HAS_BEEF = "has_beef"
        const val IS_VEGETARIAN = "is_vegetarian"
        const val HAS_CHICKEN = "has_chicken"
        const val IS_HALAL = "is_halal"
        const val HAS_FISH = "has_fish"
        const val IS_DAIRY_FREE = "is_dairy_free"
        const val HAS_SHELLFISH = "has_shellfish"
        const val IS_GLUTEN_FREE = "is_gluten_free"
        const val HAS_PORK = "has_pork"
        const val IS_PEANUT_FREE = "is_peanut_free"
        const val HAS_OTHER_MEAT = "has_other_meat"
    }
}

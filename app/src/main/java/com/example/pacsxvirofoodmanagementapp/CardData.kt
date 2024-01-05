package com.example.pacsxvirofoodmanagementapp

import android.hardware.camera2.CameraManager.AvailabilityCallback

class CardData(
    clubName: String,
    pickupLocation: String,
    stockLeft: String,
    description: String,
    availability: String,
    isVegan: Boolean,
    hasBeef: Boolean,
    isVegetarian: Boolean,
    hasChicken: Boolean,
    isHalal: Boolean,
    hasFish: Boolean,
    isDairyFree: Boolean,
    hasShellfish: Boolean,
    isGlutenFree: Boolean,
    hasPork: Boolean,
    isPeanutFree: Boolean,
    hasOtherMeat: Boolean
) {
    var club_name: String = clubName
        private set

    var pickup_location: String = pickupLocation
        private set

    var stock_left: String = stockLeft
        private set

    var description: String = description
        private set

    var availability: String = availability
        private set

    var vegan: Boolean = isVegan
        private set

    var beef: Boolean = hasBeef
        private set

    var vegetarian: Boolean = isVegetarian
        private set

    var chicken: Boolean = hasChicken
        private set

    var halal: Boolean = isHalal
        private set

    var fish: Boolean = hasFish
        private set

    var dairy_free: Boolean = isDairyFree
        private set

    var shellfish: Boolean = hasShellfish
        private set

    var gluten_free: Boolean = isGlutenFree
        private set

    var pork: Boolean = hasPork
        private set

    var peanut_free: Boolean = isPeanutFree
        private set

    var other_meat: Boolean = hasOtherMeat
        private set
}

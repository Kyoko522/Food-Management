package com.example.pacsxvirofoodmanagementapp

class GroupData(
    val officialName: String,
    val acronymName: String,
    val description: String,
    val faculty: String,
    val school: String
){
    var short_name: String = acronymName
        private set

    var long_name: String= officialName
        private set

    var club_description: String = description
        private set

    var school_name: String = school
        private set

    var faculty_name: String = faculty
        private set
}

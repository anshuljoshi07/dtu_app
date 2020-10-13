package net.simplifiedcoding.firebaseauthtutorial.ui

import com.google.firebase.database.Exclude

data class Notice (
    @get:Exclude
    var id: String? = null,
    var Info: String? = null,
    var sender : String ?=null



)

package com.example.talk.models

data class CommonModel(
    val id: String = "",
    var username: String = "",
    var bio: String = "",
    var phone: String = "",
    var fullname: String = "",
    var state: String = "",
    var photoUrl: String = "empty",


    //message
    var text: String = "",
    var type: String = "",
    var from: String = "",
    var timeStamp: Any = ""
)
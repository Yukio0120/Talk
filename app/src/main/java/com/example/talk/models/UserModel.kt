package com.example.talk.models

data class UserModel(
    val id:String = "",
    var username:String = "",
    var bio:String = "",
    var phone:String = "",
    var fullname:String = "",
    var state:String = "",
    var photoUrl:String = "empty"
)
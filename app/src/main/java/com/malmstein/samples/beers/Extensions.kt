package com.malmstein.samples.beers

import android.app.Activity
import android.widget.Toast

fun Activity.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    val toast = Toast.makeText(this, message, length)
    toast.show()
}

package com.sopian.challengethree.utils

import android.content.Context
import android.widget.Toast

fun Context.shortToast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, text, duration).show()
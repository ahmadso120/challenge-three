package com.sopian.challengethree

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String,
    val address: String? = null,
    val age: Int? = null,
    val job: String? = null,
) : Parcelable

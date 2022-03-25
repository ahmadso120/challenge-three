package com.sopian.challengethree.utils

fun String?.isValid() : Boolean =
    !this.isNullOrEmpty()  && this.trim().isNotEmpty()
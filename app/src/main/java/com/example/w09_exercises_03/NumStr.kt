package com.example.w09_exercises_03

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NumStr(val num : Int, val str : String) : Parcelable {}

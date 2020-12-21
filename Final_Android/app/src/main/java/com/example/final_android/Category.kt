package com.example.final_android

import android.os.Parcel
import android.os.Parcelable

data class Category(
    var  business: String,
    var entertainment: String,
    var general: String,
    var health: String,
    var science: String,
    var sports: String,
    var technology: String
) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel?.writeString(business)
        parcel?.writeString(entertainment)
        parcel?.writeString(general)
        parcel?.writeString(health)
        parcel?.writeString(science)
        parcel?.writeString(sports)
        parcel?.writeString(technology)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Category> {
        override fun createFromParcel(parcel: Parcel): Category {
            return Category(parcel)
        }

        override fun newArray(size: Int): Array<Category?> {
            return arrayOfNulls(size)
        }
    }

}
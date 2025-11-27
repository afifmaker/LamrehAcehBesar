package com.example.explorelamreh.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wisata(
    val id: String,
    val nama: String,
    val lokasi: String,
    val kategori: String,
    val deskripsi: String,
    val lat: Double,
    val lng: Double
) : Parcelable
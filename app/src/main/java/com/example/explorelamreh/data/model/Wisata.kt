package com.example.explorelamreh.data.model // Sesuaikan dengan package kamu saat ini

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wisata(
    var id: String = "",       // Ubah val jadi var
    var nama: String = "",
    var lokasi: String = "",
    var deskripsi: String = "",
    var kategori: String = "", // Tambahan dari file lamamu (biarkan saja)
    var lat: Double = 0.0,     // Tambahan dari file lamamu (biarkan saja)
    var lng: Double = 0.0      // Tambahan dari file lamamu (biarkan saja)
) : Parcelable
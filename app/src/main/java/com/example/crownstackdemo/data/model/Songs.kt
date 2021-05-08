package com.example.crownstackdemo.data.model

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Songs(
    val amgArtistId: Int? = -1,
    val artistId: Int? = -1,
    val artistName: String? = "",
    val artistViewUrl: String? = "",
    val artworkUrl100: String? = "",
    val artworkUrl30: String? = "",
    val artworkUrl60: String? = "",
    val collectionArtistId: Int? = -1,
    val collectionArtistName: String? = "",
    val collectionArtistViewUrl: String? = "",
    val collectionCensoredName: String? = "",
    val collectionExplicitness: String? = "",
    val collectionHdPrice: Double? = 0.0,
    val collectionId: Int? = -1,
    val collectionName: String? = "",
    val collectionPrice: Double? = 0.0,
    val collectionViewUrl: String? = "",
    val contentAdvisoryRating: String? = "",
    val copyright: String? = "",
    val country: String? = "",
    val currency: String? = "",
    val description: String? = "",
    val discCount: Int? = -1,
    val discNumber: Int? = -1,
    val hasITunesExtras: Boolean? = false,
    val isStreamable: Boolean? = false,
    val kind: String? = "",
    val longDescription: String? = "",
    val previewUrl: String? = "",
    val primaryGenreName: String? = "",
    val releaseDate: String? = "",
    val shortDescription: String? = "",
    val trackCensoredName: String? = "",
    val trackCount: Int? = -1,
    val trackExplicitness: String? = "",
    val trackHdPrice: Double? = 0.0,
    val trackHdRentalPrice: Double? = 0.0,
    val trackId: Int? = -1,
    val trackName: String? = "",
    val trackNumber: Int? = -1,
    val trackPrice: Double? = 0.0,
    val trackRentalPrice: Double? = 0.0,
    val trackTimeMillis: Int? = -1,
    val trackViewUrl: String? = "",
    val wrapperType: String? = ""
) : Parcelable
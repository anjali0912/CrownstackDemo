package com.example.crownstackdemo.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.crownstackdemo.R
import com.example.techalchemytask.helpers.DateUtil

/**
 * Mapper provides modified data to the view.
 */
object Mapper {

    @JvmStatic
    fun getUpdatedDate(eventDate: String?): String? {
        return eventDate?.let { DateUtil.getStandardTime(it) }
    }

    @JvmStatic
    fun getTrackDuration(releaseDate: Int?): String? {
        var numberOfHours = (releaseDate?.rem(86400))?.div(3600);
        var numberOfMinutes = ((releaseDate?.rem(86400))?.rem(3600))?.div(60)
        var numberOfSeconds = ((releaseDate?.rem(86400))?.rem(3600))?.rem(60)
        var duration = "${numberOfMinutes}:${numberOfSeconds}"
        return duration
    }

    @JvmStatic
    @BindingAdapter("app:profileImage")
    fun loadImage(view: ImageView, imageUrl: String?) {
        val drawable = R.mipmap.ic_launcher_round
        Glide.with(view.context)
            .load(imageUrl).apply(RequestOptions().placeholder(drawable).fitCenter())
            .into(view)
    }
}
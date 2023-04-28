package dev.trendster.editorx.data.model

import com.google.gson.annotations.SerializedName

data class FontResponse(
    @SerializedName("fonts")
    val fonts: List<FontInfo>
)
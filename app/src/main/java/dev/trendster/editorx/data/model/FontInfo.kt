package dev.trendster.editorx.data.model

import com.google.gson.annotations.SerializedName

data class FontInfo(
    @SerializedName("fontName")
    val fontName: String,
    @SerializedName("displayName")
    val displayName: String
)
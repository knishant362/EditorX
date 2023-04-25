package dev.trendster.editorx.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.trendster.editorx.R


val Gotham = FontFamily(
    Font(R.font.gotham_light, FontWeight.Light),
    Font(R.font.gotham_book, FontWeight.Normal),
    Font(R.font.gotham_medium, FontWeight.Medium),
    Font(R.font.gotham_bold, FontWeight.Bold),
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    )
)
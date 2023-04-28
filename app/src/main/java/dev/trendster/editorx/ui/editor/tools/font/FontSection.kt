package dev.trendster.editorx.ui.editor.tools.font

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import dev.trendster.editorx.data.model.FontInfo

@Composable
fun FontSection(localFonts: List<TextFont>, onFontSelected: (TextFont) -> Unit) {
    val availableFonts: List<TextFont> = localFonts
    LazyRow {
        items(items = availableFonts){ textFont ->
            FontRow(textFont = textFont)
        }
    }

}


@OptIn(ExperimentalTextApi::class)
@Composable
fun FontRow(textFont: TextFont) {
    Column(
        modifier = Modifier
            .padding(horizontal = 6.dp, vertical = 4.dp)
    ) {

        val fontFamily = FontFamily(Font(textFont.filePath, LocalContext.current.assets))
        Text(text = textFont.displayName, fontFamily = fontFamily)

    }
}




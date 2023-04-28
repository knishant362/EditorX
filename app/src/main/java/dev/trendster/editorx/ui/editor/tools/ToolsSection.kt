package dev.trendster.editorx.ui.editor.tools

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.trendster.editorx.R
import dev.trendster.editorx.ui.editor.EditorScreen
import dev.trendster.editorx.ui.editor.tools.font.FontSection

@Composable
fun ToolsSection() {
    val tools = listOf(
        ToolEntity(id = 0, title = "Text", R.drawable.baseline_add_circle_outline_24),
        ToolEntity(id = 1, title = "Fonts", R.drawable.outline_font_download_24),
        ToolEntity(id = 2, title = "Stroke", R.drawable.baseline_adjust_24),
        ToolEntity(id = 3, title = "Color", R.drawable.outline_color_lens_24),
        ToolEntity(id = 4, title = "Align", R.drawable.baseline_format_align_center_24)
    )

    val selectedButtonState = rememberSaveable { mutableStateOf(0) }

//    when(selectedButtonState.value) {
//        0 -> { FontSection(localFonts = , onFontSelected = )   }
//        1 -> {  }
//        2 -> {}
//        3 -> {}
//        4 -> {}
//
//    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
                color = Color.White
            ),
    ) {
        LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {
            items(items = tools) { toolEntity ->
                Tool(
                    isSelected = selectedButtonState.value == toolEntity.id,
                    toolEntity = toolEntity
                ) { selectedButtonState.value = it }
            }
        }
    }
}


@Composable
fun Tool(isSelected: Boolean, toolEntity: ToolEntity, onItemClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val color = if (isSelected) Color.Black else Color.LightGray
        Image(
            painter = painterResource(id = toolEntity.icon),
            contentDescription = "Tool",
            modifier = Modifier
                .size(28.dp)
                .padding(4.dp)
                .clickable { onItemClick.invoke(toolEntity.id) },
            colorFilter = ColorFilter.tint(color = color),
        )
        Text(
            text = toolEntity.title,
            color = color,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewToolsSection() {
    ToolsSection()
}

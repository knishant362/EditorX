package dev.trendster.editorx.ui.editor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import dev.trendster.editorx.ui.editor.tools.ToolsSection
import dev.trendster.editorx.ui.theme.Purple400
import dev.trendster.editorx.ui.theme.Purple500

@Composable
fun EditorScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple400),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TitleBar()
        EditorFrame()
        ToolsSection()
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewEditorScreen() {
    EditorScreen()
}
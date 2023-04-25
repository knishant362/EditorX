package dev.trendster.editorx.ui.editor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.trendster.editorx.R
import dev.trendster.editorx.ui.theme.Typography

@Composable
fun TitleBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
            contentDescription = "Back Button",
            modifier = Modifier.padding(4.dp),
            colorFilter = ColorFilter.tint(Color.White)
        )
        Text(
            text = "Editor",
            modifier = Modifier
                .padding(vertical = 6.dp, horizontal = 10.dp),
            color = Color.White,
            style = Typography.h1
        )
        Image(
            painter = painterResource(id = R.drawable.ic_outline_file_download_24),
            contentDescription = "Save Image",
            modifier = Modifier.padding(4.dp),
            colorFilter = ColorFilter.tint(Color.White)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewTitleBar(){
    TitleBar()
}
package dev.trendster.editorx.ui.editor

import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import dev.trendster.editorx.R

@Composable
fun EditorFrame() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
    ) {
        InstaLogo()
        FbLogo()
//        DrawRectangle()
        DrawText()
        DrawImage()
        DrawPath()

    }
}

@Composable
fun InstaLogo() {

    val instaColors = listOf(Color.Yellow, Color.Red, Color.Magenta)
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {

        drawRoundRect(
            brush = Brush.linearGradient(colors = instaColors),
            cornerRadius = CornerRadius(60f, 60f),
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 40f,
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 13f,
            center = Offset(this.size.width * .80f, this.size.height * .20f)
        )
    }
}


@Composable
fun FbLogo() {
    val assetManager = LocalContext.current.assets
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(15.dp)
    ) {

        val paint = Paint().apply {
            textAlign = Paint.Align.CENTER
            textSize = 200f
            color = Color.White.toArgb()
            typeface = Typeface.createFromAsset(assetManager, "FACEBOLF.OTF")
        }

        drawRoundRect(
            brush = Brush.linearGradient(listOf(Color.Blue, Color.Blue)),
            cornerRadius = CornerRadius(20f, 20f)
        )
    }

    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(15.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            start = Offset(x = canvasWidth, y = 0f),
            end = Offset(x = 0f, y = canvasHeight),
            color = Color.Blue
        )

    }

}

@Composable
fun DrawRectangle() {
    Canvas(modifier = Modifier.size(100.dp)) {
        withTransform({
            translate(left = size.width / 5f)
            rotate(degrees = 45f)
        }) {
            drawRect(
                color = Color.Cyan,
                topLeft = Offset(x = size.width / 3F, y = size.height / 3F)
            )
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun DrawText() {
    val textMeasurer = rememberTextMeasurer()
    Spacer(
        modifier = Modifier
            .padding(15.dp)
            .drawWithCache {
                val measuredText =
                    textMeasurer.measure(
                        AnnotatedString("Hello, There, Go brr, more brr"),
                        constraints = Constraints.fixed(
                            width = (size.width / 2f).toInt(),
                            height = (size.height / 2f).toInt()
                        ),
                        style = TextStyle(fontSize = 12.sp),
                        overflow = TextOverflow.Ellipsis
                    )
                onDrawBehind {
                    drawRoundRect(
                        color = Color.Green,
                        size = measuredText.size.toSize(),
                        cornerRadius = CornerRadius(14f, 14f)
                    )
                    drawText(measuredText)
                }

            }
            .size(100.dp)
    )

}

@Composable
fun DrawImage() {
//    val image = ImageBitmap.imageResource(id = R.drawable.outline_font_download_24)
//    Canvas(modifier = Modifier.size(100.dp),  onDraw = {
//        drawImage(image)
//    })
}


@Composable
fun DrawPath() {
    Spacer(modifier = Modifier.drawWithCache {
        val path = Path()
        path.moveTo(0f,0f)
        path.lineTo(size.width / 2F, size.height / 2F)
        path.lineTo(size.width, 0f)

        onDrawBehind {
            drawPath(path, Color.Magenta, style = Stroke(width = 10f))
        }
    })
}


@Preview
@Composable
fun PreviewEditorFrame() {
    EditorFrame()
}
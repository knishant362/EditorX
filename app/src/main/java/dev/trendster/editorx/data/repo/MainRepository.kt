package dev.trendster.editorx.data.repo

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import com.google.gson.Gson
import dev.trendster.editorx.data.model.FontInfo
import dev.trendster.editorx.data.model.FontResponse
import org.json.JSONException
import java.io.InputStream
import java.nio.charset.Charset

class MainRepository(private val context: Context) {

    fun getFonts(): List<FontInfo>{
        try {
            val inn: InputStream = context.assets.open("fontName.json")
            val size: Int = inn.available()
            val buffer = ByteArray(size)
            inn.read(buffer)
            inn.close()
            val json = String(buffer, Charset.forName("UTF-8"))
            val lstOfFont = Gson().fromJson(json, FontResponse::class.java).fonts
            val listOfFonts = ArrayList<FontInfo>()

            lstOfFont.forEach {
                listOfFonts.add(it)
            }
            return listOfFonts
        } catch (jsonException: JSONException) {
            return emptyList()
        }
    }

}
package dmitry.man.task5mycat

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CatData(
    @Json(name = "id") val id: String?,
    @Json(name = "url") val imageUrl: String?,
    @Json(name = "width") val width: Int,
    @Json(name = "height") val height: Int
)
data class Cats(
    val imageUrl: String?,
    val width: Int,
    val height: Int
)

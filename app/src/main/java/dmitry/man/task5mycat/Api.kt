package dmitry.man.task5mycat

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface CatApi {
    @GET("/v1/images/search?api_key=api_key=ac8d0176-027e-40e2-a5e7-324c947a044a&limit=10")
    suspend fun getListOfCatData(): List<CatData>
}
    object CatApiImpl {
        var BASE_URL = "https://api.thecatapi.com"
            private val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

        private val CatService = retrofit.create(CatApi::class.java)

        suspend fun getListOfCats(): List<Cats> {
            return withContext(Dispatchers.IO) {
                CatService.getListOfCatData()
                    .map {
                        catData ->
                        Cats(catData.imageUrl, catData.width, catData.height)
                    }
            }
        }
    }

package project.elizavetamikhailova.mvvmexample.retrofit

import io.reactivex.Observable
import project.elizavetamikhailova.mvvmexample.ui.uimodels.Category

import retrofit2.http.GET

interface ProductsApi {

    @GET("get-all-categories")
    fun getAllCategories(): Observable<List<Category>>
}
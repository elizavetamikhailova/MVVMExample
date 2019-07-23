package project.elizavetamikhailova.mvvmexample.data

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import project.elizavetamikhailova.mvvmexample.retrofit.ProductsApi
import project.elizavetamikhailova.mvvmexample.retrofit.RetrofitClient
import project.elizavetamikhailova.mvvmexample.ui.uimodels.Category


class CategoryRemoteDataSource {

    private var retrofitClient: RetrofitClient = RetrofitClient()


    fun getCategories(): Observable<List<Category>> {
        return retrofitClient.getRetrofitRX().create<ProductsApi>(ProductsApi::class.java)
            .getAllCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}


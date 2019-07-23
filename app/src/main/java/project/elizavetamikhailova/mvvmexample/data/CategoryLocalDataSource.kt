package project.elizavetamikhailova.mvvmexample.data

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import project.elizavetamikhailova.mvvmexample.ui.uimodels.Category

class CategoryLocalDataSource {
    fun getCategories() : Observable<List<Category>> {
        val list : MutableList<Category> = mutableListOf()
//        list.add(
//            Category(
//                "First",
//                "First"
//            )
//        )
//        list.add(
//            Category(
//                "First",
//                "First"
//            )
//        )
//        list.add(
//            Category(
//                "First",
//                "First"
//            )
//        )

        return Observable.just(list.toList())
    }

    fun saveCategories(list: List<Category>) : Completable{
        return Single.just(1).toCompletable()
    }
}


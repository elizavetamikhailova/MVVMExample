package project.elizavetamikhailova.mvvmexample.data.local

import android.annotation.SuppressLint
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers
import project.elizavetamikhailova.mvvmexample.data.local.db.CategoryDao
import project.elizavetamikhailova.mvvmexample.ui.uimodels.Category
import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CategoryLocalDataSource @Inject constructor(val categoryDao: CategoryDao) {
    fun getCategories() : Observable<List<Category>> {
        return categoryDao.getAllCategories().toObservable()
    }


    @SuppressLint("CheckResult") //memory leak?
    fun saveCategories(list: List<Category>) : Completable{
        deleteAllCategories().subscribeWith(object : DisposableCompletableObserver() {
            override fun onComplete() {
                list.map { insertCategory(it) }
            }

            override fun onError(e: Throwable) {

            }
        })

        return Single.just(1).toCompletable()
    }

    private fun insertCategory(category: Category){

        val callable = Callable<Void> {
            categoryDao.insert(category)
            null
        }
        Completable.fromCallable(callable)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }


    private fun deleteAllCategories() : Completable{
        val callable = Callable<Void> {
            categoryDao.deleteAll()
            null
        }
        return Completable.fromCallable(callable)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}


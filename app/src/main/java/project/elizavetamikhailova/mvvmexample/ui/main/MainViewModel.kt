package project.elizavetamikhailova.mvvmexample.ui.main

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import project.elizavetamikhailova.mvvmexample.data.CategoryRepository
import project.elizavetamikhailova.mvvmexample.ui.uimodels.Category
import project.elizavetamikhailova.mvvmexample.utility.extension.plusAssign
import javax.inject.Inject

class MainViewModel @Inject constructor(var categoryRepository: CategoryRepository) : ViewModel() {

    val isLoading = ObservableField(false)

    var categories = MutableLiveData<List<Category>>()

    val connect = ObservableField(false)

    private val compositeDisposable = CompositeDisposable()

    fun loadRepositories() {
        connect.set(categoryRepository.networkManager.isConnectedToInternet)
        isLoading.set(true)
        compositeDisposable += categoryRepository.getCategories()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableObserver<List<Category>>() {
            override fun onError(e: Throwable) {

            }

            override fun onNext(data: List<Category>) {
                categories.value = data
            }

            override fun onComplete() {
                isLoading.set(false)
            }
        })
    }

    override fun onCleared() {
        super.onCleared()
        if(!compositeDisposable.isDisposed){
            compositeDisposable.dispose()
        }
    }
}
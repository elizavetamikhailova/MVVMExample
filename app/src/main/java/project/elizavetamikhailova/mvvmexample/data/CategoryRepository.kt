package project.elizavetamikhailova.mvvmexample.data

import io.reactivex.Observable
import project.elizavetamikhailova.mvvmexample.managers.NetworkManager
import project.elizavetamikhailova.mvvmexample.ui.uimodels.Category
import javax.inject.Inject


class CategoryRepository @Inject constructor(var networkManager: NetworkManager)  {

    private val localDataSource = CategoryLocalDataSource()
    private val remoteDataSource = CategoryRemoteDataSource()

    fun getCategories(): Observable<List<Category>> {

        networkManager.isConnectedToInternet?.let {
            if (it) {
                return remoteDataSource.getCategories().flatMap {
                    return@flatMap localDataSource.saveCategories(it)
                        .toSingleDefault(it)
                        .toObservable()
                }
            }
        }

        return localDataSource.getCategories()
    }
}

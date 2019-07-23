package project.elizavetamikhailova.mvvmexample.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import project.elizavetamikhailova.mvvmexample.ui.uimodels.Category
import androidx.room.Delete
import io.reactivex.Maybe
import io.reactivex.Observable


@Dao
interface CategoryDao {

    @Insert
    fun insert(category: Category)

    @Query("SELECT * FROM category")
    fun getAllCategories(): Maybe<List<Category>>

    @Delete
    fun delete(category: Category)

    @Query("DELETE FROM category")
    fun deleteAll()
}
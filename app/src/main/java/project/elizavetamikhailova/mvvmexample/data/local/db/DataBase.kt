package project.elizavetamikhailova.mvvmexample.data.local.db

import androidx.room.RoomDatabase
import androidx.room.Database
import project.elizavetamikhailova.mvvmexample.ui.uimodels.Category


@Database(entities = [Category::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    companion object {
        val DATABASE_NAME = "category.db"
    }
}
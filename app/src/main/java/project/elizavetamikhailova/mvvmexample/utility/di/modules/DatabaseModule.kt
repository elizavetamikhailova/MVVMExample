package project.elizavetamikhailova.mvvmexample.utility.di.modules

import android.content.Context
import dagger.Provides
import javax.inject.Singleton
import androidx.room.Room
import dagger.Module
import project.elizavetamikhailova.mvvmexample.data.local.db.CategoryDao
import project.elizavetamikhailova.mvvmexample.data.local.db.DataBase


@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideDataBase(context: Context): DataBase {
        return Room.databaseBuilder(
            context,
            DataBase::class.java,
            DataBase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideCategoryDao(dataBase: DataBase): CategoryDao{
        return dataBase.categoryDao()
    }
}
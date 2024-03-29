package project.elizavetamikhailova.mvvmexample

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule{

    @Provides
    fun providesContext(application: ModernApplication): Context {
        return application.applicationContext
    }
}
package project.elizavetamikhailova.mvvmexample

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import project.elizavetamikhailova.mvvmexample.ui.main.MainActivityModule
import project.elizavetamikhailova.mvvmexample.utility.di.ViewModelBuilder
import javax.inject.Singleton

    @Singleton
    @Component(
        modules = [AndroidSupportInjectionModule::class,
            AppModule::class,
            ViewModelBuilder::class,
            MainActivityModule::class]
    )
    interface AppComponent : AndroidInjector<ModernApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ModernApplication>()


}
package project.elizavetamikhailova.mvvmexample

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import project.elizavetamikhailova.mvvmexample.utility.di.modules.MainActivityModule
import project.elizavetamikhailova.mvvmexample.utility.di.ViewModelBuilder
import project.elizavetamikhailova.mvvmexample.utility.di.modules.DataBaseModule
import javax.inject.Singleton

    @Singleton
    @Component(
        modules = [AndroidSupportInjectionModule::class,
            AppModule::class,
            ViewModelBuilder::class,
            MainActivityModule::class,
            DataBaseModule::class]
    )
    interface AppComponent : AndroidInjector<ModernApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ModernApplication>()


}
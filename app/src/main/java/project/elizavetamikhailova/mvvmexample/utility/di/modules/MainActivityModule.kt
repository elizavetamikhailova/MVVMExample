package project.elizavetamikhailova.mvvmexample.utility.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import project.elizavetamikhailova.mvvmexample.ui.main.MainActivity
import project.elizavetamikhailova.mvvmexample.ui.main.MainViewModel
import project.elizavetamikhailova.mvvmexample.utility.di.ViewModelKey

@Module
internal abstract class MainActivityModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}
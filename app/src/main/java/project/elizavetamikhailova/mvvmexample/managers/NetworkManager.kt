package project.elizavetamikhailova.mvvmexample.managers

import android.content.Context
import android.net.ConnectivityManager
import project.elizavetamikhailova.mvvmexample.databinding.ActivityMainBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkManager @Inject constructor(var applicationContext: Context) {

    val isConnectedToInternet: Boolean?
        get() {
            val conManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val ni = conManager.activeNetworkInfo
            return ni != null && ni.isConnected
        }

}

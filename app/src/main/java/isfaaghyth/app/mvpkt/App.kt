package isfaaghyth.app.mvpkt

import android.app.Application
import isfaaghyth.app.mvpkt.di.*
import org.koin.android.ext.android.startKoin

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)
    }

}
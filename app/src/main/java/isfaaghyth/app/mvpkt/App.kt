package isfaaghyth.app.mvpkt

import android.app.Application
import isfaaghyth.app.mvpkt.di.networkModule
import isfaaghyth.app.mvpkt.di.presenterModule
import isfaaghyth.app.mvpkt.di.repositoryModule
import isfaaghyth.app.mvpkt.di.schedulerModule
import org.koin.android.ext.android.startKoin

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this,
            listOf(
                schedulerModule,
                networkModule,
                repositoryModule,
                presenterModule))
    }

}
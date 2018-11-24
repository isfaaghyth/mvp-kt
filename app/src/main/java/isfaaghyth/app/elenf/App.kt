package isfaaghyth.app.elenf

import android.app.Application
import isfaaghyth.app.elenf.di.*
import org.koin.android.ext.android.startKoin
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)
        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Soleil-Regular.otf")
                .setFontAttrId(R.attr.fontPath)
                .build())
    }

}
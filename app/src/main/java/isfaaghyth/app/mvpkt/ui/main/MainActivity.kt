package isfaaghyth.app.mvpkt.ui.main

import android.os.Bundle
import isfaaghyth.app.mvpkt.R
import isfaaghyth.app.mvpkt.base.BaseActivity

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class MainActivity: BaseActivity<MainPresenter>(), MainView {

    override fun contentView(): Int = R.layout.activity_main

    override fun presenter(): MainPresenter {
        return MainPresenter()
    }

    override fun onCreated(state: Bundle?) {

    }

}
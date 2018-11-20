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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreated(state: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
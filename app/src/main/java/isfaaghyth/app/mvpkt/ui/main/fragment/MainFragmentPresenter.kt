package isfaaghyth.app.mvpkt.ui.main.fragment

import isfaaghyth.app.mvpkt.base.BasePresenter
import isfaaghyth.app.mvpkt.data.DataManager

/**
 * Created by isfaaghyth on 24/11/18.
 * github: @isfaaghyth
 */
class MainFragmentPresenter(private val dataManager: DataManager)
    : BasePresenter<MainFragmentView>(), MainFragmentPresenterIntr {
}
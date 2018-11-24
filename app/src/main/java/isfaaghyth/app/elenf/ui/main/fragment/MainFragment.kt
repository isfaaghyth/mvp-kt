package isfaaghyth.app.elenf.ui.main.fragment

import android.view.View
import isfaaghyth.app.elenf.R
import isfaaghyth.app.elenf.base.BaseFragment
import org.koin.android.ext.android.inject

/**
 * Created by isfaaghyth on 24/11/18.
 * github: @isfaaghyth
 */
class MainFragment: BaseFragment<MainFragmentPresenter>(), MainFragmentView {

    override fun contentView(): Int = R.layout.fragment_main

    private val presenter by  inject<MainFragmentPresenter>()
    override fun presenter(): MainFragmentPresenter = presenter

    override fun onCreated(view: View) {

    }

}
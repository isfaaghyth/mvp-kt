package isfaaghyth.app.elenf.ui.main.fragment.home

import android.view.View
import isfaaghyth.app.elenf.R
import isfaaghyth.app.elenf.base.BaseFragment
import org.koin.android.ext.android.inject

/**
 * Created by isfaaghyth on 24/11/18.
 * github: @isfaaghyth
 */
class HomeFragment: BaseFragment<HomeFragmentPresenter>(), HomeFragmentView {

    override fun contentView(): Int = R.layout.fragment_home

    private val presenter by  inject<HomeFragmentPresenter>()
    override fun presenter(): HomeFragmentPresenter = presenter

    override fun onCreated(view: View) {

    }

}
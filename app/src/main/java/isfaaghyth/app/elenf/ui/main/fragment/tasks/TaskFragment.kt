package isfaaghyth.app.elenf.ui.main.fragment.tasks

import android.view.View
import isfaaghyth.app.elenf.R
import isfaaghyth.app.elenf.base.BaseFragment
import org.koin.android.ext.android.inject

/**
 * Created by isfaaghyth on 24/11/18.
 * github: @isfaaghyth
 */
class TaskFragment: BaseFragment<TaskFragmentPresenter>(), TaskFragmentView {

    override fun contentView(): Int = R.layout.fragment_tasks

    private val presenter by inject<TaskFragmentPresenter>()
    override fun presenter(): TaskFragmentPresenter = presenter

    override fun onCreated(view: View) {

    }

}
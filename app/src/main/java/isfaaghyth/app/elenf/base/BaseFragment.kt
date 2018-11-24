package isfaaghyth.app.elenf.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by isfaaghyth on 24/11/18.
 * github: @isfaaghyth
 */
abstract class BaseFragment<out P: BasePresenter<*>>: Fragment(), BaseView {

    //inflate a view in XML and return it
    protected abstract fun contentView(): Int

    /**
     * The presenter acts upon the model and the view.
     * It retrieves data from repositories (the model),
     * and formats it for display in the view.
     */
    private lateinit var presenter: P
    protected abstract fun presenter(): P

    protected abstract fun onCreated(view: View)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(contentView(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreated(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.dettachView()
    }

    override fun showLoading(message: String) {

    }

    override fun hideLoading() {

    }

    override fun onError(message: String) {

    }

    override fun onError(resId: Int) {
        onError(getString(resId))
    }

    override fun networkStatus(): Boolean? {
        //TODO(create an utility for check internet connection)
        return true
    }
}
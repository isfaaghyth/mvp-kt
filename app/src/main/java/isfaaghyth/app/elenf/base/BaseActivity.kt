package isfaaghyth.app.elenf.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
abstract class BaseActivity<out P: BasePresenter<*>>: AppCompatActivity(), BaseView {

    //inflate a view in XML and return it
    protected abstract fun contentView(): Int

    /**
     * The presenter acts upon the model and the view.
     * It retrieves data from repositories (the model),
     * and formats it for display in the view.
     */
    private lateinit var presenter: P
    protected abstract fun presenter(): P

    protected abstract fun onCreated(state: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentView())
        presenter = presenter()
        onCreated(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dettachView()
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
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
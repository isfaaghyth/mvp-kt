package isfaaghyth.app.mvpkt.base

import android.support.annotation.StringRes

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
interface BaseView {
    fun showLoading(message: String = "")
    fun hideLoading()
    fun onError(message: String)
    fun onError(@StringRes resId: Int)
    fun networkStatus(): Boolean?
}
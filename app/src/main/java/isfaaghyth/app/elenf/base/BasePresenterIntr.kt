package isfaaghyth.app.elenf.base

import io.reactivex.disposables.Disposable

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
interface BasePresenterIntr<V> {
    fun attachView(view: V)
    fun dettachView()
    fun subscribe(disposable: Disposable)
    fun onError(error: Throwable)
}
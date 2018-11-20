package isfaaghyth.app.mvpkt.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import isfaaghyth.app.mvpkt.network.Network
import isfaaghyth.app.mvpkt.network.Routes
import retrofit2.HttpException
import java.net.SocketTimeoutException

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class BasePresenter<V: BaseView>: BasePresenterIntr<V> {

    /**
     * CompositeDisposable()
     * A disposable container that can hold onto multiple other
     * disposables and offers O(1) add and removal complexity.
     * @example:
     * for disposable handling of network request
     */
    private var composite = CompositeDisposable()

    private lateinit var routes: Routes
    protected fun routes() = routes

    private lateinit var view: V

    override fun attachView(view: V) {
        this.view = view
        routes = Network.builder
    }

    override fun dettachView() {
        //Atomically clears the container, then disposes all the previously contained Disposables.
        composite.clear()
    }

    override fun subscribe(disposable: Disposable) {
        /**
         * You should use checkNotNull in order to fail fast.
         * Without it, you may pass an illegal null to another method,
         * which passes it further, and so on and so on, where it finally fails.
         * Then you can need some good luck to find out that actually
         * the very first method should have refused null.
         */
        checkNotNull(disposable)

        //then add it onto container!
        composite.add(disposable)
    }

    override fun onError(error: Throwable) = when(error) {
        is HttpException -> {
            when (error.code()) {
                //for example, unauthorized
                401 -> {
                    view.onError("retry to sign in")
                }
                //TODO(you could add manually for 40x,50x,..)
                else -> {
                    view.onError("ups! please check your connection")
                }
            }
        }
        is SocketTimeoutException -> view.onError("timeout. try again!")
        else -> {
            view.onError("ups!")
        }
    }

}
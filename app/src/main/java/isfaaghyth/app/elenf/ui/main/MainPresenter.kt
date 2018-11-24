package isfaaghyth.app.elenf.ui.main

import isfaaghyth.app.elenf.base.BasePresenter
import isfaaghyth.app.elenf.data.DataManager

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class MainPresenter(private val dataManager: DataManager): BasePresenter<MainView>(), MainPresenterIntr {

    override fun getProfile(username: String) {
        view().showLoading()
        subscribe(dataManager.profile(username)
            .subscribe(
                { res -> run {
                    view().hideLoading()
                    view().onGithubProfile(res)
                } },
                { err -> run {
                    view().hideLoading()
                    super.onError(err)
                } }
            ))
    }

}
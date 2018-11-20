package isfaaghyth.app.mvpkt.ui.main

import isfaaghyth.app.mvpkt.base.BasePresenter
import isfaaghyth.app.mvpkt.data.repository.remote.GithubRepositoryImpl

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class MainPresenter(private val repositoryImpl: GithubRepositoryImpl): BasePresenter<MainView>(), MainPresenterIntr {

    override fun getProfile(username: String) {
        view().showLoading()
        subscribe(repositoryImpl.profile(username)
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
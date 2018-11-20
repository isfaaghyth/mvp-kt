package isfaaghyth.app.mvpkt.data.repository.remote

import io.reactivex.Single
import isfaaghyth.app.mvpkt.data.entity.Profile
import isfaaghyth.app.mvpkt.data.entity.Repositories
import isfaaghyth.app.mvpkt.network.Routes
import isfaaghyth.app.mvpkt.utils.rx.SchedulerProvider

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class GithubRepository(
        private val routes: Routes,
        private val scheduler: SchedulerProvider
    ): GithubRepositoryImpl {

    override fun profile(username: String): Single<Profile> =
        routes.getProfile(username)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.mainThread())

    override fun repositories(username: String): Single<List<Repositories>> =
        routes.getGithubRepository(username)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.mainThread())
}
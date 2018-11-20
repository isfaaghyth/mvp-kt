package isfaaghyth.app.mvpkt.data.repository.remote

import io.reactivex.Single
import isfaaghyth.app.mvpkt.data.entity.Profile
import isfaaghyth.app.mvpkt.data.entity.Repositories

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
interface GithubRepositoryImpl {
    fun profile(username: String): Single<Profile>
    fun repositories(username: String): Single<List<Repositories>>
}
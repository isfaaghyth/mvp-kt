package isfaaghyth.app.mvpkt.data

import io.reactivex.Single
import isfaaghyth.app.mvpkt.data.entity.Profile
import isfaaghyth.app.mvpkt.data.entity.Repositories
import isfaaghyth.app.mvpkt.data.repository.remote.GithubRepositoryImpl

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class AppDataManager(private val repository: GithubRepositoryImpl): DataManager {

    override fun profile(username: String): Single<Profile> =
        repository.profile(username)

    override fun repositories(username: String): Single<List<Repositories>> =
        repository.repositories(username)

}
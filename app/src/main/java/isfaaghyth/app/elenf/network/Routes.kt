package isfaaghyth.app.elenf.network

import io.reactivex.Single
import isfaaghyth.app.elenf.data.entity.Profile
import isfaaghyth.app.elenf.data.entity.Repositories
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
interface Routes {

    @GET("users/{username}")
    fun getProfile(
        @Path("username") username: String
    ): Single<Profile>

    @GET("users/{username}/repos")
    fun getGithubRepository(
        @Path("username") username: String
    ): Single<List<Repositories>>

}
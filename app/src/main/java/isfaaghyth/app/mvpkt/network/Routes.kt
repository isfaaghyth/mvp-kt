package isfaaghyth.app.mvpkt.network

import io.reactivex.Single
import isfaaghyth.app.mvpkt.data.entity.GithubRepo
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
interface Routes {

    @GET("users/{username}/repos")
    fun getGithubRepository(
        @Path("username") username: String
    ): Single<List<GithubRepo>>

}
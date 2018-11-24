package isfaaghyth.app.elenf.network

import io.reactivex.Flowable
import io.reactivex.Single
import isfaaghyth.app.elenf.data.entity.Elen
import isfaaghyth.app.elenf.data.entity.Task
import retrofit2.http.*

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
interface Routes {

    @FormUrlEncoded
    @POST("cek")
    fun getTask(
        @Field("username") username: String,
        @Field("password") password: String
    ): Flowable<Elen>

}
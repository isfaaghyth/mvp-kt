package isfaaghyth.app.elenf.data.repository.remote

import io.reactivex.Flowable
import isfaaghyth.app.elenf.data.entity.Elen

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
interface ElenRepositoryImpl {
    fun tasks(username: String, password: String): Flowable<Elen>
}
package isfaaghyth.app.elenf.data

import io.reactivex.Flowable
import io.reactivex.Single
import isfaaghyth.app.elenf.data.entity.Elen
import isfaaghyth.app.elenf.data.entity.Task
import isfaaghyth.app.elenf.data.repository.remote.ElenRepositoryImpl

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class AppDataManager(private val repository: ElenRepositoryImpl): DataManager {

    override fun tasks(username: String, password: String): Flowable<Elen>
            = repository.tasks(username, password)

}
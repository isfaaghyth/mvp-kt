package isfaaghyth.app.elenf.data.repository.remote

import io.reactivex.Flowable
import io.reactivex.Single
import isfaaghyth.app.elenf.data.entity.Elen
import isfaaghyth.app.elenf.data.entity.Task
import isfaaghyth.app.elenf.network.Routes
import isfaaghyth.app.elenf.utils.rx.SchedulerProvider

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class ElenRepository(
        private val routes: Routes,
        private val scheduler: SchedulerProvider
    ): ElenRepositoryImpl {

    override fun tasks(username: String, password: String): Flowable<Elen> =
        routes.getTask(username, password)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.mainThread())
}
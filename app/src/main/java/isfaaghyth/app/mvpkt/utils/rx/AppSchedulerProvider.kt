package isfaaghyth.app.mvpkt.utils.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class AppSchedulerProvider: SchedulerProvider {
    override fun io(): Scheduler = Schedulers.io()
    override fun computation(): Scheduler = Schedulers.computation()
    override fun mainThread(): Scheduler = AndroidSchedulers.mainThread()
    override fun newThread(): Scheduler = Schedulers.newThread()
    override fun trampoline(): Scheduler = Schedulers.trampoline()
}
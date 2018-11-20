package isfaaghyth.app.mvpkt.utils.rx

import io.reactivex.Scheduler

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
interface SchedulerProvider {
    fun io(): Scheduler
    fun computation(): Scheduler
    fun mainThread(): Scheduler
    fun newThread(): Scheduler
    fun trampoline(): Scheduler
}
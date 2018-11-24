package isfaaghyth.app.mvpkt.di

import io.reactivex.disposables.CompositeDisposable
import isfaaghyth.app.mvpkt.data.AppDataManager
import isfaaghyth.app.mvpkt.data.DataManager
import isfaaghyth.app.mvpkt.data.repository.remote.GithubRepository
import isfaaghyth.app.mvpkt.data.repository.remote.GithubRepositoryImpl
import isfaaghyth.app.mvpkt.network.Network
import isfaaghyth.app.mvpkt.network.Routes
import isfaaghyth.app.mvpkt.ui.main.MainPresenter
import isfaaghyth.app.mvpkt.ui.main.fragment.MainFragmentPresenter
import isfaaghyth.app.mvpkt.utils.rx.AppSchedulerProvider
import isfaaghyth.app.mvpkt.utils.rx.SchedulerProvider
import org.koin.dsl.module.module

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */

val schedulerModule = module {
    factory { CompositeDisposable() }
    single { AppSchedulerProvider() } bind SchedulerProvider::class
}

val networkModule = module {
    single { Network().builder().create(Routes::class.java) } bind Routes::class
}

val repositoryModule = module {
    single { GithubRepository(get(), get()) } bind GithubRepositoryImpl::class
    single { AppDataManager(get()) } bind DataManager::class
}

val presenterModule = module {
    single { MainPresenter(get()) }
    single { MainFragmentPresenter(get()) }
}

val modules = listOf(
    schedulerModule,
    networkModule,
    repositoryModule,
    presenterModule)
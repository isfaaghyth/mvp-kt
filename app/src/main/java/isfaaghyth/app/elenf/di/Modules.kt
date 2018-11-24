package isfaaghyth.app.elenf.di

import io.reactivex.disposables.CompositeDisposable
import isfaaghyth.app.elenf.data.AppDataManager
import isfaaghyth.app.elenf.data.DataManager
import isfaaghyth.app.elenf.data.repository.remote.GithubRepository
import isfaaghyth.app.elenf.data.repository.remote.GithubRepositoryImpl
import isfaaghyth.app.elenf.network.Network
import isfaaghyth.app.elenf.network.Routes
import isfaaghyth.app.elenf.ui.main.MainPresenter
import isfaaghyth.app.elenf.ui.main.fragment.MainFragmentPresenter
import isfaaghyth.app.elenf.utils.rx.AppSchedulerProvider
import isfaaghyth.app.elenf.utils.rx.SchedulerProvider
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
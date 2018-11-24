package isfaaghyth.app.elenf.di

import io.reactivex.disposables.CompositeDisposable
import isfaaghyth.app.elenf.data.AppDataManager
import isfaaghyth.app.elenf.data.DataManager
import isfaaghyth.app.elenf.data.repository.remote.ElenRepository
import isfaaghyth.app.elenf.data.repository.remote.ElenRepositoryImpl
import isfaaghyth.app.elenf.network.Network
import isfaaghyth.app.elenf.network.Routes
import isfaaghyth.app.elenf.ui.main.MainPresenter
import isfaaghyth.app.elenf.ui.main.fragment.home.HomeFragmentPresenter
import isfaaghyth.app.elenf.ui.main.fragment.tasks.TaskFragmentPresenter
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
    single { ElenRepository(get(), get()) } bind ElenRepositoryImpl::class
    single { AppDataManager(get()) } bind DataManager::class
}

val presenterModule = module {
    single { MainPresenter(get()) }
    single { HomeFragmentPresenter(get()) }
    single { TaskFragmentPresenter(get()) }
}

val modules = listOf(
    schedulerModule,
    networkModule,
    repositoryModule,
    presenterModule)
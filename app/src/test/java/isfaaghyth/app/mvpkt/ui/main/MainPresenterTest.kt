package isfaaghyth.app.mvpkt.ui.main

import io.reactivex.Single
import io.reactivex.functions.Consumer
import isfaaghyth.app.mvpkt.data.DataManager
import isfaaghyth.app.mvpkt.data.entity.Profile
import isfaaghyth.app.mvpkt.di.modules
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.test.KoinTest

import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class MainPresenterTest: KoinTest {

    @Mock private lateinit var view: MainView
    @Mock private lateinit var dataManager: DataManager
    private lateinit var presenter: MainPresenter

    private lateinit var mProfile: Profile

    @Before fun setUp() {
        startKoin(modules)
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(dataManager)
    }

    @Test fun getProfile() {
        mProfile = Profile()

        val username = "isfaaghyth"
        presenter.attachView(view)

        doReturn(Single.just(mProfile))
            .`when`(dataManager)
            .profile(username)

        presenter.getProfile(username)

        verify(view).showLoading()
        verify(view).hideLoading()
    }

}
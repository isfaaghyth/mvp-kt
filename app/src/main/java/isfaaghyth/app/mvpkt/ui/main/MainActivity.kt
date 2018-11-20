package isfaaghyth.app.mvpkt.ui.main

import android.os.Bundle
import android.util.Log
import isfaaghyth.app.mvpkt.R
import isfaaghyth.app.mvpkt.base.BaseActivity
import isfaaghyth.app.mvpkt.data.entity.Profile
import org.koin.android.ext.android.inject

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class MainActivity: BaseActivity<MainPresenter>(), MainView {

    override fun contentView(): Int = R.layout.activity_main

    private val presenter by inject<MainPresenter>()
    override fun presenter() = presenter

    override fun onCreated(state: Bundle?) {
        val username = "isfaaghyth"
        presenter.getProfile(username)
    }

    override fun onGithubProfile(profile: Profile) {
        Log.d("TAG", profile.name)
        Log.d("TAG", profile.avatarUrl)
    }

}
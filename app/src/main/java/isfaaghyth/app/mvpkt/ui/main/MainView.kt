package isfaaghyth.app.mvpkt.ui.main

import isfaaghyth.app.mvpkt.base.BaseView
import isfaaghyth.app.mvpkt.data.entity.Profile

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
interface MainView: BaseView {
    fun onGithubProfile(profile: Profile)
}
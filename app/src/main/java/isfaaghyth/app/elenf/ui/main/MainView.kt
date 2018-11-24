package isfaaghyth.app.elenf.ui.main

import isfaaghyth.app.elenf.base.BaseView
import isfaaghyth.app.elenf.data.entity.Profile

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
interface MainView: BaseView {
    fun onGithubProfile(profile: Profile)
}
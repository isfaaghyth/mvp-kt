package isfaaghyth.app.mvpkt.ui.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import isfaaghyth.app.mvpkt.R
import isfaaghyth.app.mvpkt.base.BaseActivity
import isfaaghyth.app.mvpkt.data.entity.Profile
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.android.ext.android.inject
import android.opengl.ETC1.getWidth
import android.view.animation.TranslateAnimation
import com.google.android.material.tabs.TabLayout
import isfaaghyth.app.mvpkt.ui.adapter.ViewPagerAdapter
import isfaaghyth.app.mvpkt.ui.main.fragment.MainFragment
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class MainActivity: BaseActivity<MainPresenter>(), MainView {

    override fun contentView(): Int = R.layout.activity_main

    private val presenter by inject<MainPresenter>()
    override fun presenter() = presenter

    override fun onCreated(state: Bundle?) {
        presenter.attachView(this)

        setSupportActionBar(toolbar)
        txtTitle.text = "Aplikasi Pertama"
        txtSubTitle.text = "Selamat Datang!"

        tabPrepared()

        val username = "isfaaghyth"
        presenter.getProfile(username)
    }

    private fun tabPrepared() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MainFragment(), "Overview")
        adapter.addFragment(MainFragment(), "History")
        vpMain.adapter = adapter

        tabMain.setupWithViewPager(vpMain)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.mn_notification -> {
                Log.e("TAG", "Notification!")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onGithubProfile(profile: Profile) {
        Log.d("getProfile", profile.name)
        Log.d("getProfile", profile.avatarUrl)
    }

}
package isfaaghyth.app.elenf.ui.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import isfaaghyth.app.elenf.R
import isfaaghyth.app.elenf.base.BaseActivity
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.android.ext.android.inject
import isfaaghyth.app.elenf.ui.adapter.ViewPagerAdapter
import isfaaghyth.app.elenf.ui.main.fragment.home.HomeFragment
import isfaaghyth.app.elenf.ui.main.fragment.tasks.TaskFragment
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
        activityViewPrepared()
    }

    private fun activityViewPrepared() {
        //set support action bar
        setSupportActionBar(toolbar)

        //preparing tabLayout #1
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), getString(R.string.tab_home))
        adapter.addFragment(TaskFragment(), getString(R.string.tab_task))
        vpMain.adapter = adapter

        //set it (#1)!
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

}
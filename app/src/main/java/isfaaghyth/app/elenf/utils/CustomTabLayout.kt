package isfaaghyth.app.elenf.utils

import android.content.Context
import android.content.res.Resources
import com.google.android.material.tabs.TabLayout
import android.widget.TextView
import uk.co.chrisjenx.calligraphy.CalligraphyUtils
import android.view.ViewGroup
import android.util.AttributeSet
import androidx.annotation.NonNull
import isfaaghyth.app.elenf.R


/**
 * Created by isfaaghyth on 24/11/18.
 * github: @isfaaghyth
 */
class CustomTabLayout(context: Context, attrs: AttributeSet) : TabLayout(context, attrs) {

    private val fontPath: String?

    init {
        fontPath = pullFontPathFromView(context, attrs, intArrayOf(R.attr.fontPath))
    }

    override fun addTab(@NonNull tab: TabLayout.Tab, position: Int, setSelected: Boolean) {
        super.addTab(tab, position, setSelected)

        val mainView = getChildAt(0) as ViewGroup
        val tabView = mainView.getChildAt(tab.position) as ViewGroup
        val tabChildCount = tabView.childCount
        for (i in 0 until tabChildCount) {
            val tabViewChild = tabView.getChildAt(i)
            if (tabViewChild is TextView) {
                CalligraphyUtils.applyFontToTextView(context, tabViewChild, fontPath)
            }
        }
    }

    companion object {

        /**
         * Tries to pull the Custom Attribute directly from the TextView.
         *
         * @param context Activity Context
         * @param attrs View Attributes
         * @param attributeId if -1 returns null.
         * @return null if attribute is not defined or added to View
         */
        internal fun pullFontPathFromView(context: Context, attrs: AttributeSet?, attributeId: IntArray?): String? {
            if (attributeId == null || attrs == null) return null

            val attributeName: String
            try {
                attributeName = context.getResources().getResourceEntryName(attributeId[0])
            } catch (e: Resources.NotFoundException) {
                // invalid attribute ID
                return null
            }

            val stringResourceId = attrs.getAttributeResourceValue(null, attributeName, -1)
            return if (stringResourceId > 0)
                context.getString(stringResourceId)
            else
                attrs.getAttributeValue(null, attributeName)
        }
    }
}
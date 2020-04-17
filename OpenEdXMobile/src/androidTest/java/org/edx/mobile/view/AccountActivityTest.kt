package org.edx.mobile.view

import android.app.Activity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.facebook.testing.screenshot.Screenshot
import org.edx.mobile.R
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestName
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class AccountActivityTest {

    @Rule
    @JvmField
    val rule: ActivityTestRule<AccountActivity> = ActivityTestRule(AccountActivity::class.java)

    @Rule
    var testName = TestName()

    private lateinit var activity: Activity

    @Before
    fun before() {
        this.activity = rule.activity
    }

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("org.edx.mobile", appContext.packageName)
        println("useAppContext : Test Ran")
    }

    @Test
    fun checkProfileClick() {
        Espresso.onView(ViewMatchers.withId(R.id.profile_btn)).perform(ViewActions.click())
    }

    @Test
    fun checkSettingClick() {
        Espresso.onView(ViewMatchers.withId(R.id.settings_btn)).perform(ViewActions.click())
    }

    @Test
    fun checkFeedbackClick() {
        Espresso.onView(ViewMatchers.withId(R.id.feedback_btn)).perform(ViewActions.click())
    }

    @Test
    fun checkLogoutClick() {
        Espresso.onView(ViewMatchers.withId(R.id.logout_btn)).perform(ViewActions.click())
    }

    @Test
    @Throws(Throwable::class)
    fun testScreenshotRecordAccountActivity() {
        activity.runOnUiThread { Screenshot.snap(activity.findViewById(R.id.my_groups_list_container)).setName(javaClass.name + "_" + testName.methodName).record() }
    }
}
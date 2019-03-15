package com.example.testapp

import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import androidx.test.InstrumentationRegistry
import androidx.test.filters.SdkSuppress
import androidx.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
class deviceReset {

    companion object {
        const val GOOGLE_SETTING = "Google"
        const val ADS_SETTING = "広告"
        const val RESET_ADVERTISING_ID = "広告IDをリセット"
    }


    @Test
    fun resetDevice() {
        resetChromeCookie()
        closeChromeTab()
        resetAdvertisingId()
    }

    @Test
    fun resetChromeCookie() {
        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        mDevice.pressHome()

        val appsList = mDevice.findObject(UiSelector().descriptionContains("アプリのリスト"))
        appsList.click()

        val clickSettings = mDevice.findObject(By.desc("Chrome"))
        clickSettings.click()

        val clickChromeOptionButton = mDevice.findObject(UiSelector().resourceId ("com.android.chrome:id/menu_button"))
        clickChromeOptionButton.click()

        val clickChromeSetting = mDevice.findObject(UiSelector().text("設定"))
        clickChromeSetting.click()

        val appDrawer = UiScrollable(UiSelector().scrollable(true))

        appDrawer.scrollForward()
        appDrawer.scrollTextIntoView("プライバシー")

        val clickPrivacy = mDevice.findObject(UiSelector().text("プライバシー"))
        clickPrivacy.click()

        appDrawer.scrollForward()
        appDrawer.scrollTextIntoView("閲覧履歴データを消去する")

        val clickDeletePage = mDevice.findObject(UiSelector().text("閲覧履歴データを消去する"))
        clickDeletePage.click()

        val clickClear = mDevice.findObject(UiSelector().text("データを消去"))
        clickClear.click()

        val clickOk = mDevice.findObject(UiSelector().text("クリア"))
        clickOk.click()

        mDevice.pressHome()
    }


    @Test
    fun closeChromeTab() {
        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        mDevice.pressHome()

        val appsList = mDevice.findObject(UiSelector().descriptionContains("アプリのリスト"))
        appsList.click()

        val clickSettings = mDevice.findObject(By.desc("Chrome"))
        clickSettings.click()

        val clickChrometabButton = mDevice.findObject(UiSelector().resourceId ("com.android.chrome:id/tab_switcher_button"))
        clickChrometabButton.click()

        val clickChromeMenuButton = mDevice.findObject(UiSelector().resourceId("com.android.chrome:id/menu_button"))
        clickChromeMenuButton.click()

        val clickAllTabClose = mDevice.findObject(UiSelector().text("すべてのタブを閉じる"))
        clickAllTabClose.click()

        mDevice.pressHome()
    }


    @Test
    fun resetAdvertisingId() {
        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        mDevice.pressHome()

        val appsList = mDevice.findObject(UiSelector().descriptionContains("アプリのリスト"))
        appsList.click()
        //Click on Google setting
        val clickSettings = mDevice.findObject(By.desc("設定"))
        clickSettings.click()

        val appDrawer = UiScrollable(UiSelector().scrollable(true))
        appDrawer.scrollForward()
        appDrawer.scrollTextIntoView("$GOOGLE_SETTING")

        val clickGoogle = mDevice.findObject(UiSelector().text("$GOOGLE_SETTING"))
        clickGoogle.click()

        //Click on Ads setting
        appDrawer.scrollForward()
        appDrawer.scrollTextIntoView("$ADS_SETTING")

        val clickAds = mDevice.findObject(UiSelector().text("$ADS_SETTING"))
        clickAds.click()

        //Click on Reset advertising ID
        val clickResetAdvertisingID = mDevice.findObject(UiSelector().text("$RESET_ADVERTISING_ID"))
        clickResetAdvertisingID.click()

        val clickOk = mDevice.findObject(UiSelector().text("OK"))
        clickOk.click()

        mDevice.pressHome()
    }
}
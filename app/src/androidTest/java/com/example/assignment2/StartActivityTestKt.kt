package com.example.assignment2

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import androidx.test.uiautomator.UiSelector
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

private const val PACKAGE_NAME = "com.example.assignment2"
private const val TIMEOUT = 5000L // 5 seconds

@RunWith(AndroidJUnit4::class)
class StartActivityTestKt {

    private lateinit var device: UiDevice

    @Before
    fun setUp() {
        //initalize and go to homescreen
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()

        //wait for icon
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val launcherIntent = context.packageManager.getLaunchIntentForPackage(PACKAGE_NAME)
        launcherIntent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK) // Clear out any previous instances
        context.startActivity(launcherIntent)

        //wait to open
        device.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)), TIMEOUT)
    }

    @Test
    fun testStartSecondActivity() {
        //find and click button
        val startButton = device.findObject(UiSelector().text("Start activity explicitly"))
        startButton.click()

        //wait
        device.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)), TIMEOUT)

        //check for mobile software engineering challenges
        var hasChallenge: Boolean = true
        if (device.findObject(By.textContains("Device Fragmentation")) != null)
            hasChallenge = false
        if (device.findObject(By.textContains("OS Fragmentation")) != null)
            hasChallenge = false
        if (device.findObject(By.textContains("Unstable and Dynamic Environment")) != null)
            hasChallenge = false
        if (device.findObject(By.textContains("Rapid Changes")) != null)
            hasChallenge = false
        if (device.findObject(By.textContains("Tool Support")) != null)
            hasChallenge = false

        assertFalse("SecondActivity did not display the expected challenge text", hasChallenge)
    }
}

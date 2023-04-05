package com.example.tiptime

import android.icu.text.NumberFormat
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun calculate_20_percent_tip_no_roundup() {
        var amount = 10.00
        var tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(1.5)
        val actualTip = calculateTip(10.0, 15.0)
        assertEquals(expectedTip, actualTip)
    }
}
package com.example.tiptime

import android.icu.text.NumberFormat
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {



        @Test
        fun calculate_20_percent_tip_no_roundup() {
            var amount = 10.00
            var tipPercent = 20.00
            val expectedTip = NumberFormat.getCurrencyInstance().format(2)
            val actualTip = calculateTip(10.0, 20.0)
            assertEquals(expectedTip, actualTip)
        }


    }


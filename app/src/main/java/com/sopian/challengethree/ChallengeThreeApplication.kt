package com.sopian.challengethree

import android.app.Application
import com.google.android.material.color.DynamicColors

class ChallengeThreeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Apply dynamic color
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}
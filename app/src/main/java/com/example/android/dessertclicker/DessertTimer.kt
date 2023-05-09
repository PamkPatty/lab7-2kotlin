
package com.example.android.dessertclicker

import android.os.Handler
import timber.log.Timber
import android.os.Looper


class DessertTimer {

    // The number of seconds counted since the timer started
    var secondsCount = 0

    /**
     * [Handler] is a class meant to process a queue of messages (known as [android.os.Message]s)
     * or actions (known as [Runnable]s)
     */
    private var handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable


    fun startTimer() {
        // Create the runnable action, which prints out a log and increments the seconds counter
        runnable = Runnable {
            secondsCount++
            Timber.i("Timer is at : $secondsCount")
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
}

    fun stopTimer() {
        // Removes all pending posts of runnable from the handler's queue, effectively stopping the
        // timer
        handler.removeCallbacks(runnable)
    }
}
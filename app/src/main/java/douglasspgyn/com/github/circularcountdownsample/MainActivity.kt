package douglasspgyn.com.github.circularcountdownsample


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import douglasspgyn.com.github.circularcountdown.CircularCascadeCountdown
import douglasspgyn.com.github.circularcountdown.CircularCountdown
import douglasspgyn.com.github.circularcountdown.listener.CascadeListener
import douglasspgyn.com.github.circularcountdown.listener.CircularListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CircularListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startCountdowns()
    }

    private fun startCountdowns() {
        startTimeCountdown()

        withoutLoop()
        withLoop()
        withLoopDisabledBeforeRun()
        withLoopDisabledAfterRun()
        withLoopDisabledAfterThreeCycles()
        withoutLoopDisabledAfterThreeCycles()
        withoutLoopDisabledAfterThreeCycles2()
        withoutLoopDisabledAfterCyclesUpdating()
        withoutLoopDisabledAfterCyclesUpdating2()
    }

    private fun startTimeCountdown() {
        val day = 1
        val hour = 0
        val minute = 0
        val second = 5

        val remainTime = day * CircularCountdown.DAY_CONVERTER + hour * CircularCountdown.HOUR_CONVERTER + minute * CircularCountdown.MINUTE_CONVERTER + second * CircularCountdown.SECOND_CONVERTER

        CircularCascadeCountdown(remainTime, circularCountdownSeconds, circularCountdownMinutes, circularCountdownHours, circularCountdownDays)
                .listener(object : CascadeListener {
                    override fun onFinish() {
                        Log.d("Cascade", "Finish")
                    }
                }).start()
    }

    /**
     * Countdown starting after 3 and finish at 10 without loop (one cycle)
     */
    private fun withoutLoop() {
        circularCountdownWithoutLoop.create(3, 10, CircularCountdown.TYPE_SECOND).listener(this).loop(false).start()
        circularCountdownWithoutLoop.setProgressTextSize(24f)
        circularCountdownWithoutLoop.setProgressTextColor(R.color.colorPrimaryDark)
        circularCountdownWithoutLoop.setProgressForegroundColor(R.color.colorAccent)
        circularCountdownWithoutLoop.setProgressBackgroundColor(R.color.colorPrimary)
    }

    override fun onTick(progress: Int) {

    }

    override fun onFinish(newCycle: Boolean, cycleCount: Int) {
        Log.d("WithoutLoop", "Loop: $newCycle - Cycle: $cycleCount")
    }

    /**
     * Countdown starting after 0 and finish at 10 with loop (infinity cycles)
     */
    private fun withLoop() {
        circularCountdownWithInfinityLoop.create(0, 10, CircularCountdown.TYPE_SECOND).listener(object : CircularListener {
            override fun onTick(progress: Int) {

            }

            override fun onFinish(newCycle: Boolean, cycleCount: Int) {
                Log.d("WithInfinityLoop", "Loop: $newCycle - Cycle: $cycleCount")
            }
        }).start()
    }

    /**
     * Countdown starting after 5 and finish at 10 with loop (but disabled before finish the first cycle)
     */
    private fun withLoopDisabledBeforeRun() {
        circularCountdownWithLoopDisablingBefore.create(5, 10, CircularCountdown.TYPE_SECOND).listener(object : CircularListener {
            override fun onTick(progress: Int) {

            }

            override fun onFinish(newCycle: Boolean, cycleCount: Int) {
                Log.d("WithLoopDisablingBefore", "Loop: $newCycle - Cycle: $cycleCount")
            }
        }).start()
        circularCountdownWithLoopDisablingBefore.disableLoop()
        circularCountdownWithLoopDisablingBefore.setProgressTextSize(32f)
        circularCountdownWithLoopDisablingBefore.setProgressTextColor(R.color.colorPrimaryDark)
        circularCountdownWithLoopDisablingBefore.setProgressForegroundColor(R.color.colorPrimary)
        circularCountdownWithLoopDisablingBefore.setProgressBackgroundColor(R.color.colorAccent)
    }

    /**
     * Countdown starting after 7 and finish at 10 with loop (but disabled after finish the first cycle)
     */
    private fun withLoopDisabledAfterRun() {
        circularCountdownWithLoopDisablingAfter.create(7, 10, CircularCountdown.TYPE_SECOND).listener(object : CircularListener {
            override fun onTick(progress: Int) {

            }

            override fun onFinish(newCycle: Boolean, cycleCount: Int) {
                Log.d("WithLoopDisablingAfter", "Loop: $newCycle - Cycle: $cycleCount")
                circularCountdownWithLoopDisablingAfter.disableLoop()
            }
        }).start()
    }

    /**
     * Countdown starting after 9 and finish at 10 with loop (but disabled after finish three cycles)
     */
    private fun withLoopDisabledAfterThreeCycles() {
        circularCountdownWithLoopThreeCycles.create(9, 10, CircularCountdown.TYPE_SECOND).listener(object : CircularListener {
            override fun onTick(progress: Int) {

            }

            override fun onFinish(newCycle: Boolean, cycleCount: Int) {
                Log.d("WithLoopThreeCycles", "Loop: $newCycle - Cycle: $cycleCount")
            }
        }).maxCycles(3).start()
    }

    /**
     * Countdown starting after 9 and finish at 10 without loop (but disabled after finish three cycles)
     */
    private fun withoutLoopDisabledAfterThreeCycles() {
        circularCountdownWithouthLoopThreeCycles.create(9, 10, CircularCountdown.TYPE_SECOND).listener(object : CircularListener {
            override fun onTick(progress: Int) {

            }

            override fun onFinish(newCycle: Boolean, cycleCount: Int) {
                Log.d("WithoutLoopThreeCycles", "Loop: $newCycle - Cycle: $cycleCount")
            }
        }).loop(false).maxCycles(3).start()
    }

    /**
     * Countdown starting after 9 and finish at 10 without loop (but disabled after finish three cycles)
     */
    private fun withoutLoopDisabledAfterThreeCycles2() {
        circularCountdownWithouthLoopThreeCycles2.create(9, 10, CircularCountdown.TYPE_SECOND).listener(object : CircularListener {
            override fun onTick(progress: Int) {

            }

            override fun onFinish(newCycle: Boolean, cycleCount: Int) {
                Log.d("WithoutLoopThreeCycles", "Loop: $newCycle - Cycle: $cycleCount")
            }
        }).maxCycles(3).loop(false).start()
    }

    /**
     * Countdown starting after 9 and finish at 10 without loop (but disabled after finish two cycles)
     */
    private fun withoutLoopDisabledAfterCyclesUpdating() {
        withoutLoopDisabledAfterCyclesUpdating.create(9, 10, CircularCountdown.TYPE_SECOND).listener(object : CircularListener {
            override fun onTick(progress: Int) {

            }

            override fun onFinish(newCycle: Boolean, cycleCount: Int) {
                Log.d("WithoutLoopCyclesUpdate", "Loop: $newCycle - Cycle: $cycleCount")
                withoutLoopDisabledAfterCyclesUpdating.maxCycles(2)
            }
        }).maxCycles(10).start()
    }

    /**
     * Countdown starting after 9 and finish at 10 without loop (but disabled after finish two cycles)
     */
    private fun withoutLoopDisabledAfterCyclesUpdating2() {
        withoutLoopDisabledAfterCyclesUpdating2.create(9, 10, CircularCountdown.TYPE_SECOND).listener(object : CircularListener {
            override fun onTick(progress: Int) {

            }

            override fun onFinish(newCycle: Boolean, cycleCount: Int) {
                Log.d("WithoutLoopCyclesUpdat2", "Loop: $newCycle - Cycle: $cycleCount")
                if (cycleCount == 4) {
                    withoutLoopDisabledAfterCyclesUpdating.maxCycles(1)
                }
            }
        }).maxCycles(7).start()
    }
}

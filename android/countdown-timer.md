# CountDownTimer

Schedule a countdown until a time in the future, with regular notifications on intervals along the way.

```kotlin
CountDownTimer(millisInFuture: Long, countDownTimerInterval: Long)
```

## Supported Methods

- - -

```kotlin
fun CountDownTimer.start(): CountDownTimer
```

Start the countdown timer

- - -

```kotlin
fun onTick(millisUntilFinished: Long)
```

Callback fired on regular interval

- - -

```kotlin
fun onFinish()
```

Callback fired when the timer ends

- - - 

```kotlin
fun cancel()
```

Cancel the countdown timer

```kotlin
val start = 30_000
val intervals = 50_000

object: CountDownTimer(start, intervals) {
    override fun onTick(millisUntilFinished: Long){
        //seconds remaining...millisUntilFinished
    }

    override fun onFinish(){
        // Done
    }
}.start()
```
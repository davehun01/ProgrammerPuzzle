package com.example.dave.programmerpuzzle.Tools;

import android.os.CountDownTimer;

public class GameTimer {

    private CountDownTimer countDownTimer;

    private GameTimerInterface gameTimerInterface;

    public GameTimer(long time, final GameTimerInterface gameTimerInterface) {
        this.gameTimerInterface = gameTimerInterface;
        initCountDownTimer(time, 1000);
    }

    private void initCountDownTimer(long time, long tickTime) {
        countDownTimer = new CountDownTimer(time, tickTime) {

            @Override
            public void onTick(long l_) {
                gameTimerInterface.tick(l_);
            }

            @Override
            public void onFinish() {
                gameTimerInterface.end();
            }
        };
    }

    public void start() {
        countDownTimer.start();
    }

    public void stop() {
        countDownTimer.cancel();
    }
}

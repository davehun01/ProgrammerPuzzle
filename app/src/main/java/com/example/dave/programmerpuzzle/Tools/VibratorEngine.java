package com.example.dave.programmerpuzzle.Tools;

import android.content.Context;
import android.os.Vibrator;

public class VibratorEngine {

    public static final int SHORT_VIBRATION_TIME = 200;

    private Vibrator vibratorEngine;

    public VibratorEngine(Context context) {
        vibratorEngine = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    /**
     * This method vibrates the device for the time specified in the parameter.
     * @param vibrationLength The time until the device vibrates.
     */
    public void vibrate(int vibrationLength) {
        if (vibratorEngine != null) {
            vibratorEngine.vibrate(vibrationLength);
        }
    }

    public void cancel() {
        vibratorEngine.cancel();
    }
}

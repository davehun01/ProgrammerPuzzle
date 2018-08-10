package com.example.dave.programmerpuzzle.View;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import lombok.Getter;
import lombok.Setter;

public class PuzzleButton extends AppCompatButton {

    @Getter
    @Setter
    private int correctLine;
    @Getter
    @Setter
    private int actualLine;

    private boolean movable;

    public PuzzleButton(Context context) {
        super(context);
        setAllCaps(false);
    }

    public PuzzleButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        setAllCaps(false);
    }

    public PuzzleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setAllCaps(false);
    }

}

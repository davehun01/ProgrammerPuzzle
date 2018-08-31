package com.example.dave.programmerpuzzle.View;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class PuzzleButton extends AppCompatButton {

    private ArrayList<Integer> correctLines;
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

    public ArrayList<Integer> getCorrectLines() {
        return correctLines;
    }

    public void setCorrectLines(ArrayList<Integer> correctLines) {
        this.correctLines = correctLines;
    }

    public int getActualLine() {
        return actualLine;
    }

    public void setActualLine(int actualLine) {
        this.actualLine = actualLine;
    }
}

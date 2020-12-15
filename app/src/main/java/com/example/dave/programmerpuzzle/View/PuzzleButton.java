package com.example.dave.programmerpuzzle.View;

import android.content.Context;
import 	androidx.appcompat.widget.AppCompatButton;
import android.util.AttributeSet;

import java.util.ArrayList;

public class PuzzleButton extends AppCompatButton implements Comparable<PuzzleButton> {

    private ArrayList<Integer> correctLines;
    private int actualLine;

    private int originalX;
    private int originalY;

    private boolean moved = false;

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

    public int getOriginalX() {
        return originalX;
    }

    public void setOriginalX(int originalX) {
        this.originalX = originalX;
    }

    public int getOriginalY() {
        return originalY;
    }

    public void setOriginalY(int originalY) {
        this.originalY = originalY;
    }

    public int compareTo(PuzzleButton other) {
        return(this.actualLine - other.actualLine);
    }
}

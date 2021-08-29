package com.codemanship.bowling;

import java.util.Arrays;

public class Game {
    private int score = 0;
    private int remaining = 10;
    private boolean spare = false;
    private boolean strike = false;
    private int bonusRolls = 0;
    private int frames = 0;
    private int frameRolls = 0;

    public int score() {
        return score;
    }

    public void roll(int pins) {

        if(frames > 9){
            if(frameRolls >= 2){
                if(!(spare || strike)){
                    return;
                }
            }
        }

        frameRolls++;

        if(strike){
            score += pins;
            bonusRolls++;
            if(bonusRolls == 2){
                strike = false;
                bonusRolls = 0;
            }
        }

        if(spare) {
            score += pins;
            spare = false;
        }

        score += pins;
        remaining -= pins;

        strike = pins == 10 || bonusRolls > 0;
        spare = remaining == 0 && !strike;

        if(remaining == 0 || frameRolls == 2){
            remaining = 10;
            frames++;
            if(frames < 10) {
                frameRolls = 0;
            }
        }

    }

    public int getFrameCount() {
        return frames;
    }

    void rolls(int... rolls) {
        Arrays.stream(rolls).forEach((pins) -> roll(pins));
    }
}

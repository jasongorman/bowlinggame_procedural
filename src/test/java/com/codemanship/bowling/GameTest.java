package com.codemanship.bowling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void newGameHasScoreOfZero(){
        Game game = new Game();
        assertEquals(0, game.score());
    }

    @Test
    public void singleRollAddsPinsToScore(){
        Game game = new Game();
        game.roll(5);
        assertEquals(5, game.score());
    }

    @Test
    public void spareAddsBonusRollToScore(){
        Game game = new Game();
        game.rolls(5, 5, 3);
        assertEquals(16, game.score());
    }

    @Test
    public void strikeAddsTwoBonusRollsToScore(){
        Game game = new Game();
        game.rolls(10, 3, 3);
        assertEquals(22, game.score());
    }

    @Test
    public void frameHasMaxTwoRolls(){
        Game game = new Game();
        game.rolls(10, 3, 3, 5, 5, 10);
        assertEquals(4, game.getFrameCount());
        assertEquals(52, game.score());
    }

    @Test
    public void gameNotEndingOnStrikeHasTenFrames(){
        Game game  = new Game();
        game.rolls(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5);
        assertEquals(80, game.score());
    }

    @Test
    public void gameEndingOnStrikeGetsTwoExtraRolls() {
        Game game  = new Game();
        game.rolls(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 10, 5, 5, 5);
        assertEquals(102, game.score());
    }

    @Test
    public void gameEndingOnSpareGetsOneExtraRoll() {
        Game game  = new Game();
        game.rolls(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5);
        assertEquals(92, game.score());
    }

}

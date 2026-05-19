package com.startjava.lesson_2_3_4.guess;

import static com.startjava.lesson_2_3_4.guess.GuessNumber.MAX_ATTEMPTS;
import static com.startjava.lesson_2_3_4.guess.GuessNumber.MAX_HIDDEN_NUM;
import static com.startjava.lesson_2_3_4.guess.GuessNumber.MIN_HIDDEN_NUM;

import java.util.Arrays;

public class Player {
    private String name;
    private int[] nums;
    private int attemptsCount;
    private int winsCount;

    public Player(String name) {
        this.name = name;
        this.nums = new int[MAX_ATTEMPTS];
    }
    
    public String getName() {
        return name;
    }

    public void addNum(int number) {
        if (number < MIN_HIDDEN_NUM || number > MAX_HIDDEN_NUM) {
            throw new IllegalArgumentException(String.format("""
                    Число должно входить в отрезок [%d, %d].
                    Попробуйте ещё раз:\s""", MIN_HIDDEN_NUM, MAX_HIDDEN_NUM));
        }
        nums[attemptsCount++] = number;
    }

    public int[] getNums() {
        return Arrays.copyOf(nums, attemptsCount);
    }

    public void incrementWins() {
        winsCount++;
    }

    public int getWinsCount() {
        return winsCount;
    }

    public void clearWins() {
        winsCount = 0;
    }

    public void clearAttempts() {
        Arrays.fill(nums, 0, attemptsCount, 0);
        attemptsCount = 0;
    }
}
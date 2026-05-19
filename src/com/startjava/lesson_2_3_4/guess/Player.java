package com.startjava.lesson_2_3_4.guess;

import static com.startjava.lesson_2_3_4.guess.GuessNumber.MAX_ATTEMPTS;
import static com.startjava.lesson_2_3_4.guess.GuessNumber.MAX_HIDDEN_NUM;
import static com.startjava.lesson_2_3_4.guess.GuessNumber.MIN_HIDDEN_NUM;

import java.util.Arrays;

public class Player {
    private String name;
    private int[] nums = new int[MAX_ATTEMPTS];
    private int attemptsCount;

    public Player(String name) {
        this.name = name;
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

    public void clear() {
        Arrays.fill(nums, 0, attemptsCount, 0);
        attemptsCount = 0;
    }
}
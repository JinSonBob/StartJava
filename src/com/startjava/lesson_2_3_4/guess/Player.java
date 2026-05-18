package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private String name;
    private int[] nums = new int[GuessNumber.MAX_ATTEMPTS];
    private int attemptsCount;

    public Player(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void addNum(int number) {
        if (number < GuessNumber.MIN_HIDDEN_NUM || number > GuessNumber.MAX_HIDDEN_NUM) {
            throw new IllegalArgumentException(String.format("""
                    Число должно входить в отрезок [%d, %d].
                    Попробуйте ещё раз:""", GuessNumber.MIN_HIDDEN_NUM, GuessNumber.MAX_HIDDEN_NUM));
        }
        nums[attemptsCount++] = number;
    }

    public int[] getNums() {
        return Arrays.copyOf(nums, attemptsCount);
    }

    public void clear() {
        Arrays.fill(nums, 0, nums.length, 0);
        attemptsCount = 0;
    }
}
package com.xyzcorp;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Random;
import java.util.function.Supplier;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class LambdaDieTest {
    @Test
    @Category(value = {UnitTest.class})
    public void basicRoll() {
        LambdaDie die = new LambdaDie(() -> 5);
        LambdaDie rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isEqualTo(5);
    }

    @Test
    @Category(value = {IntegrationTest.class})
    public void basicIntegrationTestRoll() {
        Random random = new Random();
        LambdaDie die = new LambdaDie(() -> random.nextInt(6) + 1);
        LambdaDie rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isEqualTo(5);
    }
}

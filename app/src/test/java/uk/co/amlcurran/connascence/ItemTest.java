package uk.co.amlcurran.connascence;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ItemTest {

    @Test
    public void testAnItemReportsItsPriceCorrectly() {
        Item item = new Item(200, 0);

        assertThat(item.getPrice()).isEqualTo(200);
    }

    @Test
    public void testAnItemConvertsToEurosCorrectly() {
        Item item = new Item(300, 0);

        double euros = item.toEuros();

        assertThat(euros).isEqualTo(1.1 * item.getPrice() / 100);
    }

    @Test
    public void testAnItemStartedInEurosReportsEurosCorrectly() {
        Item item = new Item(0, 300);

        double euros = item.toEuros();

        assertThat(euros).isEqualTo(300);
    }

}
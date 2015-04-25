package uk.co.amlcurran.connascence;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ItemTest {

    @Test
    public void testAnItemReportsItsPriceCorrectly() {
        Item item = new Item(200);

        assertThat(item.getPrice()).isEqualTo(200);
    }

    @Test
    public void testAnItemConvertsToEurosCorrectly() {
        Item item = new Item(300);

        double euros = item.toEuros();

        assertThat(euros).isEqualTo(Converter.get().poundsToEuros() * item.getPrice() / 100);
    }

}
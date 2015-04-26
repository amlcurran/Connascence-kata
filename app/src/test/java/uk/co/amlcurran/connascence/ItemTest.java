package uk.co.amlcurran.connascence;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ItemTest {

    @Test
    public void testAnItemReportsItsPriceCorrectly() {
        Item item = Item.withPrice("Cola", Price.inPence(200));

        assertThat(item.getPrice().inPence()).isEqualTo(200);
    }

    @Test
    public void testAnItemConvertsToEurosCorrectly() {
        Item item = Item.withPrice("Gin", Price.inPence(300));

        double euros = item.getPrice().inEuros();

        assertThat(euros).isEqualTo(1.1 * item.getPrice().inPence() / 100);
    }

    @Test
    public void testAnItemConvertsToPoundsCorrectly() {
        Item item = Item.withPrice("Cooked Chicken", Price.inEuros(3));

        double euros = item.getPrice().inPence();

        assertThat(euros).isEqualTo((int) (100 * item.getPrice().inEuros() / 1.1));
    }

    @Test
    public void testAnItemStartedInEurosReportsEurosCorrectly() {
        Item item = Item.withPrice("Baked Beans", Price.inEuros(300));

        double euros = item.getPrice().inEuros();

        assertThat(euros).isEqualTo(300);
    }

}
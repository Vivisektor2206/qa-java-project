package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest extends BaseTest {

    @Test
    public void testSetBuns() {
        when(bunMock.getPrice()).thenReturn(100.0f);
        when(bunMock.getName()).thenReturn("test bun");

        burger.setBuns(bunMock);

        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        when(ingredientMock.getPrice()).thenReturn(50.0f);

        burger.addIngredient(ingredientMock);

        assertEquals(1, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(ingredientMock));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIngredientWithInvalidIndex() {
        burger.removeIngredient(0);
    }

    @Test
    public void testRemoveIngredient() {
        when(ingredientMock.getPrice()).thenReturn(50.0f);
        burger.addIngredient(ingredientMock);

        burger.removeIngredient(0);

        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);

        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }
}

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    @Mock
    private Ingredient ingredientMockOne;
    @Mock
    private Ingredient ingredientMockTwo;
    @Mock
    private Bun bunMock;
    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bunMock);
        Assert.assertEquals(bunMock, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientMockOne);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ingredientMockOne, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientMockOne);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientMockOne);
        burger.addIngredient(ingredientMockTwo);
        Assert.assertEquals(burger.ingredients.get(0), ingredientMockOne);
        Assert.assertEquals(burger.ingredients.get(1), ingredientMockTwo);

        burger.moveIngredient(0, 1);
        Assert.assertEquals(burger.ingredients.get(1), ingredientMockOne);
        Assert.assertEquals(burger.ingredients.get(0), ingredientMockTwo);
    }

}

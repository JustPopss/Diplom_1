import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;


@RunWith(Parameterized.class)

public class BurgerGetPriceParameterizedTest {

    @Mock
    private Ingredient ingredientMock;
    @Mock
    private Bun bunMock;
    private Burger burger;

    @Parameterized.Parameter(0)
    public float bunPrice;

    @Parameterized.Parameter(1)
    public float ingrPrice;

    @Parameterized.Parameter(2)
    public float expectedPrice;

    @Parameterized.Parameters(name = "BunPrice: {0}," +
            " IngredientPrice: {1}," +
            " ExpectedPrice: {2}")
    public static Object[][] values() {
        return new Object[][]{
                {100f, 10f, 210f},
                {150f, 30f, 330f},
                {55.55f, 12.5f, 123.6f}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();

        Mockito.when(ingredientMock.getPrice()).thenReturn(ingrPrice);
        Mockito.when(bunMock.getPrice()).thenReturn(bunPrice);
    }

    @Test
    public void getPriceAssertTest() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);

        float price = burger.getPrice();

        Assert.assertEquals(expectedPrice, price, 0.0001);
    }

    @Test
    public void getPriceBunVerifyTest() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.getPrice();

        Mockito.verify(bunMock).getPrice();
    }

    @Test
    public void getPriceIngredientVerifyTest() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.getPrice();

        Mockito.verify(ingredientMock).getPrice();
    }

}
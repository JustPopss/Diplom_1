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
import praktikum.IngredientType;

@RunWith(Parameterized.class)

public class BurgerGetReceiptParameterizedTest {
    @Mock
    private Ingredient ingredientMock;
    @Mock
    private Bun bunMock;
    private Burger burger;

    @Parameterized.Parameter(0)
    public String bunName;

    @Parameterized.Parameter(1)
    public String ingredientName;

    @Parameterized.Parameter(2)
    public IngredientType ingredientType;

    @Parameterized.Parameters(
            name = "BunName: {0}," + " IngredientName: {1}," + " IngredientType: {2}")
    public static Object[][] values() {
        return new Object[][]{
                {"black bun", "hot sauce", IngredientType.SAUCE},
                {"white bun", "chili sauce", IngredientType.SAUCE},
                {"red bun", "cutlet", IngredientType.FILLING},
                {"black bun", "sausage", IngredientType.FILLING}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
    }

    @Test
    public void getReceiptAssertTest() {

        Mockito.when(bunMock.getName()).thenReturn(bunName);
        Mockito.when(bunMock.getPrice()).thenReturn(100f);

        Mockito.when(ingredientMock.getName()).thenReturn(ingredientName);
        Mockito.when(ingredientMock.getPrice()).thenReturn(100f);
        Mockito.when(ingredientMock.getType()).thenReturn(ingredientType);

        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);

        String receipt = burger.getReceipt();

        Assert.assertTrue(receipt.contains(bunName));
        Assert.assertTrue(receipt.contains(ingredientName));
        Assert.assertTrue(receipt.contains(ingredientType.toString().toLowerCase()));
        Assert.assertTrue(receipt.contains("Price:"));

    }

    @Test
    public void getReceiptVerifyTest() {

        Mockito.when(bunMock.getName()).thenReturn(bunName);
        Mockito.when(bunMock.getPrice()).thenReturn(100f);

        Mockito.when(ingredientMock.getName()).thenReturn(ingredientName);
        Mockito.when(ingredientMock.getPrice()).thenReturn(100f);
        Mockito.when(ingredientMock.getType()).thenReturn(ingredientType);

        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);

        burger.getReceipt();

        Mockito.verify(bunMock, Mockito.times(2)).getName();
        Mockito.verify(bunMock).getPrice();
        Mockito.verify(ingredientMock).getName();
        Mockito.verify(ingredientMock).getPrice();
        Mockito.verify(ingredientMock).getType();
    }
}

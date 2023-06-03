import com.example.edashouse.model.constants.characters_data.ActionsConstants;
import com.example.edashouse.model.utils.CoordinatesCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class MovementTester {
    @ParameterizedTest
    @CsvSource({"3, 5, 2, 2, 5", "3, 5, 3, 3, 4", "3, 5, 4, 3, 6", "1, 1, 1, 2, 1", "1, 1, 4, 1, 2", "2, 8, 1, 3, 8",
    "2, 8, 2, 1, 8", "2, 8, 3, 2, 7", "2, 8, 4, 2, 9"})
    public void testFreeMovements(int currentX, int currentY, int direction, int expectedX, int expectedY) {
        int[] currentCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
        int[] expectedCoordinates = CoordinatesCounter.calculateCoordinates(expectedX, expectedY);;
        int[] outputCoordinates = CoordinatesCounter.getNextSquareFromDirection(getDirectionFromNumber(direction), currentCoordinates, false);
        Assertions.assertArrayEquals(outputCoordinates, expectedCoordinates);
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 2", "1, 1, 3", "9, 9, 1", "9, 9, 4", "9, 7, 1"})
    public void testWallHitMovements(int currentX, int currentY, int direction) {
        int[] currentCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
        int[] expectedCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);;
        int[] outputCoordinates = CoordinatesCounter.getNextSquareFromDirection(getDirectionFromNumber(direction), currentCoordinates, false);
        Assertions.assertArrayEquals(outputCoordinates, expectedCoordinates);
    }

    @ParameterizedTest
    @CsvSource({"1, 5, 3", "5, 4, 4", "8, 5, 1", "9, 4, 4", "8, 9, 1"})
    public void testObjectHitMovements(int currentX, int currentY, int direction) {
        int[] currentCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
        int[] expectedCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);;
        int[] outputCoordinates = CoordinatesCounter.getNextSquareFromDirection(getDirectionFromNumber(direction), currentCoordinates, false);
        Assertions.assertArrayEquals(outputCoordinates, expectedCoordinates);
    }

    /**
     * 1-right 2-left 3-up 4-down
     */
    private ActionsConstants getDirectionFromNumber(int number) {
        switch (number) {
            case 1 -> {
                return ActionsConstants.RIGHT_KEY_PRESSED;
            }
            case 2 -> {
                return ActionsConstants.LEFT_KEY_PRESSED;
            }
            case 3 -> {
                return ActionsConstants.UP_KEY_PRESSED;
            }
            case 4 -> {
                return ActionsConstants.DOWN_KEY_PRESSED;
            }
        }
        return null;
    }
}

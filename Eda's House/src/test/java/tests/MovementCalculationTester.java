package tests;

import com.example.edashouse.model.utils.CoordinatesCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils_for_tests.TestUtils;


public class MovementCalculationTester {
    @ParameterizedTest
    @CsvSource({"3, 5, 2, 2, 5", "3, 5, 3, 3, 4", "3, 5, 4, 3, 6", "1, 1, 1, 2, 1", "1, 1, 4, 1, 2", "2, 8, 1, 3, 8",
    "2, 8, 2, 1, 8", "2, 8, 3, 2, 7", "2, 8, 4, 2, 9"})
    public void testFreeMovementsCalculation(int currentX, int currentY, int directionNumber, int expectedX, int expectedY) {
        int[] currentCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
        int[] expectedCoordinates = CoordinatesCounter.calculateCoordinates(expectedX, expectedY);
        int[] outputCoordinates = CoordinatesCounter.getNextSquareFromDirection(TestUtils.getDirectionFromNumber(directionNumber), currentCoordinates, false);
        Assertions.assertArrayEquals(outputCoordinates, expectedCoordinates);
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 2", "1, 1, 3", "9, 9, 1", "9, 9, 4", "9, 7, 1"})
    public void testWallHitMovementsCalculation(int currentX, int currentY, int direction) {
        int[] currentCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
        int[] expectedCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
        int[] outputCoordinates = CoordinatesCounter.getNextSquareFromDirection(TestUtils.getDirectionFromNumber(direction), currentCoordinates, false);
        Assertions.assertArrayEquals(outputCoordinates, expectedCoordinates);
    }

    @ParameterizedTest
    @CsvSource({"1, 5, 3", "5, 4, 4", "8, 5, 1", "9, 4, 4", "8, 9, 1"})
    public void testObjectHitMovementsCalculation(int currentX, int currentY, int directionNumber) {
        int[] currentCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
        int[] expectedCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);;
        int[] outputCoordinates = CoordinatesCounter.getNextSquareFromDirection(TestUtils.getDirectionFromNumber(directionNumber), currentCoordinates, false);
        Assertions.assertArrayEquals(outputCoordinates, expectedCoordinates);
    }


}

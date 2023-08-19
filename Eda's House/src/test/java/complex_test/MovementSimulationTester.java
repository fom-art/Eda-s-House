package complex_test;

import com.example.edashouse.controller.MovementActions;
import com.example.edashouse.model.utils.CoordinatesCounter;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.view.Layout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

public class MovementSimulationTester {
    @Mock
    private Layout mockedLayout;
    @Mock
    private MovementActions mockedMovementActions;
    @Mock
    private GameLogicHandler mockedGameLogicHandler;

    @BeforeEach
    private void init() {
        mockedMovementActions = mock(MovementActions.class);
    }

    @ParameterizedTest
    @CsvSource({"3, 5, 2, 2, 5", "3, 5, 3, 3, 4", "3, 5, 4, 3, 6", "1, 1, 1, 2, 1", "1, 1, 4, 1, 2", "2, 8, 1, 3, 8",
            "2, 8, 2, 1, 8", "2, 8, 3, 2, 7", "2, 8, 4, 2, 9"})
    public void testFreeMovementsCalculation(int currentX, int currentY, int direction, int expectedX, int expectedY) {
        int[] currentCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
        int[] expectedCoordinates = CoordinatesCounter.calculateCoordinates(expectedX, expectedY);

    }

    @ParameterizedTest
    @CsvSource({"1, 1, 2", "1, 1, 3", "9, 9, 1", "9, 9, 4", "9, 7, 1"})
    public void testWallHitMovementsCalculation(int currentX, int currentY, int direction) {
        int[] currentCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
        int[] expectedCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
    }

    @ParameterizedTest
    @CsvSource({"1, 5, 3", "5, 4, 4", "8, 5, 1", "9, 4, 4", "8, 9, 1"})
    public void testObjectHitMovementsCalculation(int currentX, int currentY, int direction) {
        int[] currentCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
        int[] expectedCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
    }


}

package tests.integration_tests;

import com.example.edashouse.controller.GameController;
import com.example.edashouse.controller.MovementActions;
import com.example.edashouse.model.utils.CoordinatesCounter;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.view.Layout;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils_for_tests.TestUtils;

/**
 * Integration tests for simulating character movements.
 */
public class MovementSimulationTester {

    private GameController gameController;

    @Mock
    private Stage stage;

    @Mock
    private Scene scene;

    private Layout layout;
    private MovementActions movementActions;

    /**
     * Initializes the necessary objects before each test.
     */
    @BeforeEach
    private void init() {
        MockitoAnnotations.openMocks(this);

        gameController = new GameController();
        gameController.startForTest(stage, scene, new GameLogicHandler());
        layout = gameController.getLayout();
        movementActions = gameController.getSceneListenersSetter().getMovementActions();
    }

    /**
     * Tests the calculation of free movements.
     *
     * @param currentX     the current X-coordinate of the character
     * @param currentY     the current Y-coordinate of the character
     * @param direction    the direction of movement
     * @param expectedX    the expected X-coordinate after movement
     * @param expectedY    the expected Y-coordinate after movement
     */
    @ParameterizedTest
    @CsvSource({"3, 5, 2, 2, 5", "3, 5, 3, 3, 4", "3, 5, 4, 3, 6", "1, 1, 1, 2, 1", "1, 1, 4, 1, 2", "2, 8, 1, 3, 8",
            "2, 8, 2, 1, 8", "2, 8, 3, 2, 7", "2, 8, 4, 2, 9"})
    public void testFreeMovementsCalculation(int currentX, int currentY, int direction, int expectedX, int expectedY) {
        int[] currentCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
        int[] expectedCoordinates = CoordinatesCounter.calculateCoordinates(expectedX, expectedY);

        simulateWitchPosition(currentCoordinates);
        movementActions.receiveAction(TestUtils.getDirectionFromNumber(direction), true);
        Assertions.assertArrayEquals(expectedCoordinates, layout.getWitch().getCoordinates());
    }

    /**
     * Tests the calculation of movements when hitting a wall.
     *
     * @param currentX  the current X-coordinate of the character
     * @param currentY  the current Y-coordinate of the character
     * @param direction the direction of movement
     */
    @ParameterizedTest
    @CsvSource({"1, 1, 2", "1, 1, 3", "9, 9, 1", "9, 9, 4", "9, 7, 1"})
    public void testWallHitMovementsCalculation(int currentX, int currentY, int direction) {
        int[] currentCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);

        simulateWitchPosition(currentCoordinates);
        movementActions.receiveAction(TestUtils.getDirectionFromNumber(direction), true);
        Assertions.assertArrayEquals(currentCoordinates, layout.getWitch().getCoordinates());
    }

    /**
     * Tests the calculation of movements when hitting an object.
     *
     * @param currentX  the current X-coordinate of the character
     * @param currentY  the current Y-coordinate of the character
     * @param direction the direction of movement
     */
    @ParameterizedTest
    @CsvSource({"1, 5, 3", "5, 4, 4", "8, 5, 1", "9, 4, 4", "8, 9, 1"})
    public void testObjectHitMovementsCalculation(int currentX, int currentY, int direction) {
        int[] currentCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);

        simulateWitchPosition(currentCoordinates);
        movementActions.receiveAction(TestUtils.getDirectionFromNumber(direction), true);
        Assertions.assertArrayEquals(currentCoordinates, layout.getWitch().getCoordinates());
    }

    private void simulateWitchPosition(int[] coordinates) {
        layout.getWitch().setCoordinates(coordinates);
    }
}

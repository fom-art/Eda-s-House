package com.example.edashouse.view;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.utils.Constants;
import com.example.edashouse.model.constants.utils.ImageURL;
import com.example.edashouse.model.constants.characters_data.CharactersIdentity;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Utility class responsible for activating and updating the view of the picked item.
 */
public class ItemsPickedActivator {
    private Layout layout;

    /**
     * Constructs an ItemsPickedActivator object.
     *
     * @param layout  the game layout
     * @param isTest  whether the code is running in a test environment
     */
    public ItemsPickedActivator(Layout layout, boolean isTest) {
        this.layout = layout;
        setUpPickedItemView(isTest);
    }

    /**
     * Sets up the view for the picked item.
     *
     * @param isTest  whether the code is running in a test environment
     */
    private void setUpPickedItemView(boolean isTest) {
        // Initialize the image
        ImageView pickedItemView;
        if (!isTest) {
            Image image = new Image(ImageURL.SNAKES_SKIN.getURL());
            pickedItemView = new ImageView(image);
        } else {
            pickedItemView = new ImageView();
        }
        // Set sizes
        pickedItemView.setFitWidth(Constants.GRID_CELL_SIZE.getValue());
        pickedItemView.setFitHeight(Constants.GRID_CELL_SIZE.getValue());
        // Set coordinates
        pickedItemView.setLayoutX(Characters.PICKED_ITEM.getCoordinates()[0]);
        pickedItemView.setLayoutY(Characters.PICKED_ITEM.getCoordinates()[1]);
        // Add to Pane
        ObservableList<Node> children = layout.getPane().getChildren();
        children.add(Characters.PICKED_ITEM.getIndex(), pickedItemView);
    }

    /**
     * Updates the position of the picked item view.
     *
     * @param newCoordinates the new coordinates of the picked item
     */
    private void updatePickedItemViewPosition(int[] newCoordinates) {
        // TODO: Implement the logic to update the position of the picked item view
    }

    /**
     * Updates the image of the picked item view based on the NPC identity.
     *
     * @param npcId the NPC identity
     */
    private void updatePickedItemViewImage(CharactersIdentity npcId) {
        // TODO: Implement the logic to update the image of the picked item view based on the NPC identity
    }
}

package com.lisnykov.ui.game;

import com.lisnykov.model.entity.GameData;
import com.lisnykov.service.showalldata.ShowAllGameDataService;
import com.lisnykov.ui.views.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.button.ConfirmButton;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MTextField;

import java.util.List;


/**
 * Created by pasha on 2/4/17.
 */
@org.springframework.stereotype.Component
public class ShowAllGameDataLayoutFactory implements UIComponentBuilder {

    private List<GameData> gameDataList;
    private BeanItemContainer<GameData> container;


    private class ShowAllGameDataLayout extends VerticalLayout {

        private Grid gameDataTable;


        public ShowAllGameDataLayout init() {
            setMargin(true);


            container = new BeanItemContainer<>(GameData.class, gameDataList);


            gameDataTable = new Grid(container);
            gameDataTable.setWidth("100%");
            gameDataTable.setColumnOrder("name", "question", "type", "points", "answer");
            gameDataTable.removeColumn("id");
            gameDataTable.removeColumn("date");
            gameDataTable.setImmediate(true);

            return this;
        }

        private TextField filterByName = new MTextField()
                .withInputPrompt("Filter by name");
        private Button edit = new MButton(FontAwesome.PENCIL_SQUARE_O, this::edit);
        private Button delete = new ConfirmButton(FontAwesome.TRASH_O,
                "Are you sure you want to delete the entry?", this::remove);


        protected void adjustActionButtonState() {
            boolean hasSelection = gameDataTable.getColumns() != null;
            edit.setEnabled(hasSelection);
            delete.setEnabled(hasSelection);
        }


        public ShowAllGameDataLayout load() {
            gameDataList = showAllGameDataService.getAllGameData();
            return this;
        }

        public ShowAllGameDataLayout layout() {
            addComponent(gameDataTable);
            return this;
        }

        public void edit(Button.ClickEvent e) {
        }

        public void remove(Button.ClickEvent e) {

        }
    }

    public void refreshTable() {
        gameDataList = showAllGameDataService.getAllGameData();
        container.removeAllItems();
        container.addAll(gameDataList);
    }

    @Autowired
    private ShowAllGameDataService showAllGameDataService;

    @Override
    public Component createComponent() {
        return new ShowAllGameDataLayout().load().init().layout();
    }
}

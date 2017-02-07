package com.lisnykov.ui.game;

import com.lisnykov.model.entity.GameData;
import com.lisnykov.service.remove.RemoveGameDataService;
import com.lisnykov.service.showalldata.ShowAllGameDataService;
import com.lisnykov.ui.views.UIComponentBuilder;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    private TextField filterByName;
    private Button edit;
    private Button delete;

    @Autowired
    private RemoveGameDataService removeGameDataService;

    private class ShowAllGameDataLayout extends VerticalLayout implements Button.ClickListener {


        private Grid gameDataTable;


        public ShowAllGameDataLayout init() {


            delete = new Button(FontAwesome.TRASH_O);
            filterByName = new MTextField()
                    .withInputPrompt("Filter by name");
            edit = new MButton(FontAwesome.PENCIL_SQUARE_O, this::edit);

            delete.addClickListener(this);

            setMargin(true);

            container = new BeanItemContainer<>(GameData.class, gameDataList);

            gameDataTable = new Grid(container);
            gameDataTable.setWidth("100%");
            gameDataTable.setColumnOrder("name", "question", "type", "points", "answer");
            gameDataTable.removeColumn("id");
            gameDataTable.removeColumn("date");
            gameDataTable.setEditorEnabled(true);

//            gameDataTable.getEditorFieldGroup().addCommitHandler(new FieldGroup.CommitHandler() {
//                @Override
//                public void preCommit(FieldGroup.CommitEvent commitEvent) throws FieldGroup.CommitException {
//                    BeanItem item = (BeanItem) commitEvent.getFieldBinder().getItemDataSource();
//                    GameData gameData = (GameData) item.getBean();
//
//                    System.out.println("Pre commit: " + gameData.toString());
//
//                }
//
//                @Override
//                public void postCommit(FieldGroup.CommitEvent commitEvent) throws FieldGroup.CommitException {
//                    BeanItem item = (BeanItem) commitEvent.getFieldBinder().getItemDataSource();
//                    GameData bean = (GameData) item.getBean();
//
//
//                    System.out.println("Post commit: " + bean.toString());
//
//                    Notification.show("Changed saved");
//                }
//            });

            gameDataTable.setImmediate(true);
            gameDataTable.setSelectionMode(Grid.SelectionMode.MULTI);

            return this;
        }


        public ShowAllGameDataLayout load() {
            gameDataList = showAllGameDataService.getAllGameData();
            return this;
        }

        public ShowAllGameDataLayout layout() {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            horizontalLayout.addComponents(filterByName, edit, delete);
            addComponent(horizontalLayout);
            addComponent(gameDataTable);
            return this;
        }


        public void edit(Button.ClickEvent e) {
        }

        @Override
        public void buttonClick(Button.ClickEvent clickEvent) {

            Grid.MultiSelectionModel selectionModel = (Grid.MultiSelectionModel) gameDataTable.getSelectionModel();

            for (Object selectedItem : selectionModel.getSelectedRows()) {
                GameData gameData = (GameData) selectedItem;
                gameDataTable.getContainerDataSource().removeItem(gameData);
                removeGameDataService.removeGameData(gameData);
            }

            gameDataTable.getSelectionModel().reset();

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

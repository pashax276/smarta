package com.lisnykov.ui.game;

import com.lisnykov.model.entity.GameData;
import com.lisnykov.service.addgamedata.AddGameDataService;
import com.lisnykov.utils.GameDataUtils;
import com.lisnykov.utils.NotificationMessages;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pasha on 2/4/17.
 */
@org.springframework.stereotype.Component
public class AddGameDataLayoutFactory {

    private class AddGameDataLayout extends VerticalLayout implements Button.ClickListener {

        private TextField name;

        private TextArea question;

        private ComboBox type;

        private TextField points;

        private TextField answer;

        private Button saveButton;
        private Button clearButton;

        private BeanFieldGroup<GameData> fieldGameGroup;

        private GameData gameData;

        private GameDataSavedListener gameDataSavedListener;

        public AddGameDataLayout(GameDataSavedListener gameDataSavedListener) {
            this.gameDataSavedListener = gameDataSavedListener;
        }

        public AddGameDataLayout init() {

            fieldGameGroup = new BeanFieldGroup<>(GameData.class);
            gameData = new GameData();

            name = new TextField(GameDataUtils.QUESTION_NAME.getString());
            question = new TextArea(GameDataUtils.QUESTION.getString());
            type = new ComboBox(GameDataUtils.QUESTION_TYPE.getString());
            points = new TextField(GameDataUtils.QUESTION_POINTS.getString());
            answer = new TextField(GameDataUtils.QUESTION_ANSWER.getString());

            saveButton = new Button(GameDataUtils.SAVE_BUTTON.getString());
            clearButton = new Button(GameDataUtils.CLEAR_BUTTON.getString());

            saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
            clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);

            return this;
        }


        public AddGameDataLayout bind() {
            fieldGameGroup.bindMemberFields(this);

            fieldGameGroup.setItemDataSource(gameData);

            return this;
        }

        public com.vaadin.ui.Component layout() {

            type.setNullSelectionAllowed(false);
            type.setRequired(true);
            type.setNewItemsAllowed(true);
            type.setImmediate(true);

            question.setWidth("100%");

            GridLayout gridLayout = new GridLayout(2, 10);
            gridLayout.setSpacing(true);
            gridLayout.setSizeUndefined();

            gridLayout.addComponent(name, 0, 0);
            gridLayout.addComponent(type, 1, 0);
            gridLayout.addComponent(question, 0, 1, 1, 1);

            gridLayout.addComponent(points, 0, 2);
            gridLayout.addComponent(answer, 1, 2);

            gridLayout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 3);

            saveButton.addClickListener(this);
            clearButton.addClickListener(this);

            return gridLayout;
        }

        @Override
        public void buttonClick(Button.ClickEvent clickEvent) {

            if (clickEvent.getSource() == this.saveButton) {
                save();
            } else {
                clearField();
            }

        }

        private void clearField() {

            name.setValue(null);
            question.setValue(null);
            points.setValue(null);
            answer.setValue(null);
        }

        private void save() {

            try {
                fieldGameGroup.commit();
            } catch (FieldGroup.CommitException e) {
                Notification.show(NotificationMessages.RESUME_SAVE_VALIDATION_ERROR_TITLE.getString(),
                        NotificationMessages.RESUME_SAVE_VALIDATION_ERROR_DESCRIPTION.getString(),
                        Notification.Type.ERROR_MESSAGE);

                return;
            }

            Notification notification = new Notification(NotificationMessages.RESUME_SAVE_VALIDATION_SUCCES.getString());
            notification
                    .setDescription("<span>This application is not real, it only demonstrates an application built with the <a href=\"https://vaadin.com\">Vaadin framework</a>.</span> <span>No username or password is required, just click the <b>Sign In</b> button to continue.</span>");
            notification.setHtmlContentAllowed(true);
            notification.setStyleName("tray dark small closable login-help");
            notification.setPosition(Position.BOTTOM_CENTER);
            notification.setDelayMsec(20000);
            notification.show(Page.getCurrent());
            notification.setStyleName(ValoTheme.NOTIFICATION_SUCCESS);


            System.out.println(gameData);
            addGameDataService.saveGameData(gameData);
            gameDataSavedListener.gameDataSaved();


            clearField();
        }

    }

    @Autowired
    private AddGameDataService addGameDataService;

    public Component createComponent(GameDataSavedListener gameDataSavedListener) {
        return new AddGameDataLayout(gameDataSavedListener).init().bind().layout();
    }
}

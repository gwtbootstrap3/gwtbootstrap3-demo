package org.gwtbootstrap3.demo.client.application.extras;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.shared.event.HideEvent;
import org.gwtbootstrap3.client.shared.event.HideHandler;
import org.gwtbootstrap3.client.shared.event.ShowEvent;
import org.gwtbootstrap3.client.shared.event.ShowHandler;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.html.Div;
import org.gwtbootstrap3.client.ui.html.Paragraph;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.DateTimePicker;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.DateTimePickerDayOfWeek;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.events.*;

import java.util.Date;

/**
 * @author Joshua Godi
 */
public class DateTimePickerView extends ViewImpl implements DateTimePickerPresenter.MyView {
    @UiField(provided = true)
    DateTimePicker eventDateTimePicker;
    @UiField
    FlowPanel logRow;
    @UiField
    Button endDate;
    @UiField
    Button clearLogButton;
    @UiField
    DateTimePicker methods;
    @UiField
    Button startDate;
    @UiField
    Button disableSundays;
    @UiField
    Button editable;
    @UiField
    Button readonly;
    @UiField
    Button disable;
    @UiField
    Button enable;
    @UiField
    Button getValue;
    @UiField
    Button enableSundays;
    @UiField
    Button show;
    @UiField
    Button hide;
    @UiField
    Button setValue;
    @UiField
    Button addRemove;
    @UiField
    Div eventDateTimePickerDiv;
    @UiField
    Button setFormat;

    @Inject
    DateTimePickerView(final Binder uiBinder) {
        eventDateTimePicker = new DateTimePicker();
        eventDateTimePicker.setValue(new Date());

        initWidget(uiBinder.createAndBindUi(this));

        eventDateTimePicker.addChangeDateHandler(new ChangeDateHandler() {
            @Override
            public void onChangeDate(final ChangeDateEvent evt) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Changed Date Event Fired! (" + eventDateTimePicker.getValue().toString() + ")");
                logRow.add(logEntry);
            }
        });

        eventDateTimePicker.addChangeMonthHandler(new ChangeMonthHandler() {
            @Override
            public void onChangeMonth(final ChangeMonthEvent evt) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Changed Month Event Fired! (" + eventDateTimePicker.getValue().toString() + ")");
                logRow.add(logEntry);
            }
        });

        eventDateTimePicker.addChangeYearHandler(new ChangeYearHandler() {
            @Override
            public void onChangeYear(final ChangeYearEvent evt) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Changed Year Event Fired! (" + eventDateTimePicker.getValue().toString() + ")");
                logRow.add(logEntry);
            }
        });

        eventDateTimePicker.addOutOfRangeHandler(new OutOfRangeHandler() {
            @Override
            public void onOutOfRange(final OutOfRangeEvent evt) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Out of Range Event Fired! (" + eventDateTimePicker.getValue().toString() + ")");
                logRow.add(logEntry);
            }
        });

        eventDateTimePicker.addShowHandler(new ShowHandler() {
            @Override
            public void onShow(final ShowEvent showEvent) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Show Event Fired");
                logRow.add(logEntry);
            }
        });

        eventDateTimePicker.addHideHandler(new HideHandler() {
            @Override
            public void onHide(final HideEvent hideEvent) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Hide Event Fired");
                logRow.add(logEntry);
            }
        });
    }

    @UiHandler("addRemove")
    public void handleAddRemove(final ClickEvent event) {
        if (eventDateTimePicker.isAttached()) {
            eventDateTimePicker.removeFromParent();
        } else {
            eventDateTimePickerDiv.add(eventDateTimePicker);
        }
    }

    @UiHandler("clearLogButton")
    public void handleClearLog(final ClickEvent event) {
        logRow.clear();
    }

    @UiHandler("endDate")
    public void handleEndDate(final ClickEvent event) {
        methods.setEndDate("2015-01-27");
    }

    @UiHandler("startDate")
    public void handleStartDate(final ClickEvent event) {
        methods.setStartDate("2015-01-10");
    }

    @UiHandler("getValue")
    public void handleGetValue(final ClickEvent event) {
        Window.alert(methods.getValue().toString());
    }

    @UiHandler("setValue")
    public void handleSetValue(final ClickEvent event) {
        methods.setValue(new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24 * 3)));
    }

    @UiHandler("enable")
    public void handleEnable(final ClickEvent event) {
        methods.setEnabled(true);
    }

    @UiHandler("disable")
    public void handledisable(final ClickEvent event) {
        methods.setEnabled(false);
    }

    @UiHandler("readonly")
    public void handleReadOnly(final ClickEvent event) {
        methods.setReadOnly(true);
    }

    @UiHandler("editable")
    public void handleEditable(final ClickEvent event) {
        methods.setReadOnly(false);
    }

    @UiHandler("disableSundays")
    public void handleDisableSundays(final ClickEvent event) {
        methods.setDaysOfWeekDisabled(DateTimePickerDayOfWeek.SUNDAY);
    }

    @UiHandler("enableSundays")
    public void handleEnableSundays(final ClickEvent event) {
        methods.setDaysOfWeekDisabled();
    }

    @UiHandler("hide")
    public void handleHide(final ClickEvent event) {
        methods.hide();
    }

    @UiHandler("show")
    public void handleShow(final ClickEvent event) {
        methods.show();
    }

    @UiHandler("setFormat")
    public void handleSetFormat(final ClickEvent event) {
        methods.setFormat("dd.mm.yyyy");
        methods.reload();
    }

    interface Binder extends UiBinder<Widget, DateTimePickerView> {
    }
}

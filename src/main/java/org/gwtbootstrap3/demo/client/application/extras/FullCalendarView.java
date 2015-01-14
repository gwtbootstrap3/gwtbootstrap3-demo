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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.CalendarUtil;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;
import org.gwtbootstrap3.extras.fullcalendar.client.ui.*;

import java.util.Date;

/**
 * @author Jeff Isenhart
 */
public class FullCalendarView extends ViewImpl implements FullCalendarPresenter.MyView {

    @UiField
    Button configuring;
    @UiField
    FlowPanel configuringPanel;
    private FullCalendar configuringCalendar;

    @UiField
    Button localization;
    @UiField
    FlowPanel localizationPanel;
    private FullCalendar localizationCalendar;

    interface Binder extends UiBinder<Widget, FullCalendarView> {
    }

    @Inject
    FullCalendarView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @UiHandler("localization")
    public void localization(final ClickEvent event) {
        if (localizationCalendar != null) {
            return;
        }
        CalendarConfig config = new CalendarConfig();
        config.setLangauge(Language.Spanish);

        localizationCalendar = new FullCalendar("" + System.currentTimeMillis(), ViewOption.agendaWeek, config, true);
        localizationCalendar.addLoadHandler(new LoadHandler() {

            @Override
            public void onLoad(LoadEvent event) {
                addEvents(localizationCalendar);
            }
        });
        localizationPanel.add(localizationCalendar);
    }
    
    @UiHandler("configuring")
    public void configuring(final ClickEvent event) {
        if (configuringCalendar != null) {
            return;
        }
        CalendarConfig config = new CalendarConfig();
        ClickAndHoverConfig clickHover = new ClickAndHoverConfig(new ClickAndHoverEventCallback() {

            @Override
            public void eventMouseover(JavaScriptObject calendarEvent, NativeEvent event, JavaScriptObject viewObject) {
            }

            @Override
            public void eventMouseout(JavaScriptObject calendarEvent, NativeEvent event, JavaScriptObject viewObject) {
            }

            @Override
            public void eventClick(JavaScriptObject calendarEvent, NativeEvent event, JavaScriptObject viewObject) {
                Event calEvent = new Event(calendarEvent);
                System.out.println("id " + calEvent.getId() + " start: " + calEvent.getStart() + " end: " + calEvent.getEnd() + " all day: "
                        + calEvent.isAllDay());
                Window.alert(calEvent.getTitle());
            }

            @Override
            public void dayClick(JavaScriptObject moment, NativeEvent event, JavaScriptObject viewObject) {
                // TODO Auto-generated method stub

            }
        });

        config.setClickHoverConfig(clickHover);
        DragAndResizeConfig dr = new DragAndResizeConfig(new DragAndResizeCallback() {

            @Override
            public void eventResizeStop(JavaScriptObject calendarEvent, NativeEvent nativeEvent) {
                // System.out.println("eventResizeStop");
            }

            @Override
            public void eventResizeStart(JavaScriptObject calendarEvent, NativeEvent nativeEvent) {
                // System.out.println("eventResizeStart");
            }

            @Override
            public void eventResize(JavaScriptObject calendarEvent, JavaScriptObject revertFunction, NativeEvent nativeEvent) {
                // System.out.println("eventResize");
            }

            @Override
            public void eventDrop(JavaScriptObject calendarEvent, JavaScriptObject revertFunction, NativeEvent nativeEvent) {
                // System.out.println("eventDrop");
                Event evt = new Event(calendarEvent);
                System.out.println("eventDrop: " + evt.getStartFromYearMonthDay());
            }

            @Override
            public void eventDragStop(JavaScriptObject calendarEvent, NativeEvent nativeEvent) {
                // System.out.println("eventDragStop");
            }

            @Override
            public void eventDragStart(JavaScriptObject calendarEvent, NativeEvent nativeEvent) {
                // System.out.println("eventDragStart");
            }
        });
        config.setDragResizeConfig(dr);
        GeneralDisplay gd = new GeneralDisplay();
        config.setGeneralDisplay(gd);

        configuringCalendar = new FullCalendar("" + System.currentTimeMillis(), ViewOption.agendaWeek, config, true);
        configuringCalendar.addLoadHandler(new LoadHandler() {

            @Override
            public void onLoad(LoadEvent event) {
                addEvents(configuringCalendar);
            }
        });
        configuringPanel.add(configuringCalendar);
    }

    protected void addEvents(FullCalendar fc) {
        for (int i = 0; i < 15; i++) {
            long milis = System.currentTimeMillis();
            Event calEvent = new Event("" + i, "This is Event: " + i);
            int day = Random.nextInt(10);
            Date start = new Date();
            CalendarUtil.addDaysToDate(start, -1 * day);
            calEvent.setStart(start);
            if (day % 3 == 0) {
                calEvent.setAllDay(true);
            } else {
                Date d = new Date(start.getTime());
                d.setHours(d.getHours() + 1);
                calEvent.setEnd(d);
            }
            fc.addEvent(calEvent);
        }
    }
  
}

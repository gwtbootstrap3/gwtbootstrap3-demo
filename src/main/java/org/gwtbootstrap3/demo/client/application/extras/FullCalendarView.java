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
    
    @UiField
    Button backgroundEvents;
    @UiField
    FlowPanel backgroundEventsPanel;
    private FullCalendar backgroundEventsCalendar;

    interface Binder extends UiBinder<Widget, FullCalendarView> {
    }

    @Inject
    FullCalendarView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @UiHandler("backgroundEvents")
    public void backgroundEvents(final ClickEvent event) {
        if (backgroundEventsCalendar != null) {
            return;
        }
        CalendarConfig config = new CalendarConfig();
        Header header = new Header();
        header.setLeft("prev,next today");
        header.setCenter("title");
        header.setRight("month,agendaWeek,agendaDay");        
        GeneralDisplay gd = new GeneralDisplay();
        gd.setHeader(header);
        gd.setBusinessHours(true);
        config.setGeneralDisplay(gd);
        config.setSelectHelper(false);

        backgroundEventsCalendar = new FullCalendar("" + System.currentTimeMillis(), ViewOption.month, config, true);
        backgroundEventsCalendar.addLoadHandler(new LoadHandler() {

            @Override
            public void onLoad(LoadEvent event) {
                addBackgroundEvents(backgroundEventsCalendar);
            }
        });
        backgroundEventsPanel.add(backgroundEventsCalendar);
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
                if (Window.confirm("Delete '" + calEvent.getTitle() + "'?"))
                    configuringCalendar.removeEvent(calEvent.getId());
            }

            @Override
            public void dayClick(JavaScriptObject moment, NativeEvent event, JavaScriptObject viewObject) {
                // TODO Auto-generated method stub

            }
        });

        config.setClickHoverConfig(clickHover);
        SelectConfig selectConfig = new SelectConfig(new SelectEventCallback() {

            @Override
            public void select(JavaScriptObject start, JavaScriptObject end, NativeEvent event, JavaScriptObject viewObject) {
                Event tempEvent = new Event("" + System.currentTimeMillis(), "New event");
                tempEvent.setStart(start);
                tempEvent.setEnd(end);
                if (tempEvent.getEnd().getHours() == tempEvent.getStart().getHours() && tempEvent.getEnd().getMinutes() == tempEvent.getStart().getMinutes())
                    tempEvent.setAllDay(true);
                if (Window.confirm("Create event?")) {
                    configuringCalendar.unselect();
                    configuringCalendar.addEvent(tempEvent);
                }
            }

            @Override
            public void unselect(JavaScriptObject viewObject, NativeEvent event) {
                // System.out.println("unselect");
            }
        });
        config.setSelectConfig(selectConfig);
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
        config.setSelectable(true);
        config.setSelectHelper(true);
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

    @SuppressWarnings("deprecation")
    protected void addEvents(FullCalendar fc) {
        for (int i = 0; i < 15; i++) {
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
    
    @SuppressWarnings("deprecation")
    protected void addBackgroundEvents(FullCalendar fc) {
        Date start = new Date();
        start.setMinutes(0);
        start.setHours(9);
        CalendarUtil.addDaysToDate(start, -start.getDay()-1);
        for (int i = 1; i < 28; i++) {
            CalendarUtil.addDaysToDate(start, 1);
            if (i == 3) {
                Event lunch = new Event("" + i, "Business lunch");
                lunch.setStart(new Date(start.getTime() + 1000*60*60*4));
                lunch.setConstraint("businessHours");
                fc.addEvent(lunch);
            } if (i == 11 || i == 13) {
                Event available = new Event("availableForMeeting", "");
                available.setStart(start);
                available.setEnd(new Date(start.getTime() + 1000*60*60*8));
                available.setRendering("background");
                available.setBackgroundColor("#8FDF82");
                fc.addEvent(available);
                if (i == 13) {
                    Event meeting = new Event("" + i, "Meeting");
                    meeting.setStart(new Date(start.getTime() + Random.nextInt(7) * 1000*60*60));
                    meeting.setEnd(new Date(start.getTime() + 1000*60*60));
                    meeting.setBackgroundColor("#257e4a");
                    meeting.setConstraint("availableForMeeting");
                    fc.addEvent(meeting);
                }
            } else if (i == 6 || i == 7 || i > 23) {
                Event blocked = new Event("" + i, "");
                blocked.setStart(start);
                blocked.setAllDay(true);
                blocked.setOverlap(false);
                blocked.setRendering("background");
                blocked.setBackgroundColor("#ff9f89");
                fc.addEvent(blocked);
            } else if (i == 10) {
            Event conference = new Event("" + i, "Conference");
                conference.setStart(start);
                conference.setEnd(new Date(start.getTime() + 1000*60*60*48));
                conference.setAllDay(true);
                fc.addEvent(conference);
            } 
        }
    }
  
}

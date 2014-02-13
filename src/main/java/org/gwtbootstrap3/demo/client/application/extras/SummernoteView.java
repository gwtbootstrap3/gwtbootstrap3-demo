package org.gwtbootstrap3.demo.client.application.extras;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
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
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Paragraph;
import org.gwtbootstrap3.extras.summernote.client.event.*;
import org.gwtbootstrap3.extras.summernote.client.ui.Summernote;
import org.gwtbootstrap3.extras.summernote.client.ui.base.Toolbar;

/**
 * @author godi
 */
public class SummernoteView extends ViewImpl implements SummernotePresenter.MyView {

    @UiField(provided = true)
    Summernote customToolbar;
    @UiField(provided = true)
    Summernote getSetCode;
    @UiField
    Button getCode;
    @UiField
    Summernote events;
    @UiField
    Button clearLogButton;
    @UiField
    FlowPanel logRow;

    @UiHandler("getCode")
    public void handleClick(ClickEvent event) {
        Window.alert(getSetCode.getCode());
    }

    @UiHandler("clearLogButton")
    public void handleClearLog(final ClickEvent event) {
        logRow.clear();
    }

    interface Binder extends UiBinder<Widget, SummernoteView> {
    }

    @Inject
    SummernoteView(Binder uiBinder) {
        // Setting up the custom summernotes
        customToolbar = new Summernote();
        customToolbar.setHeight(200);
        customToolbar.setToolbar(new Toolbar()
                .setShowBoldButton(true));

        getSetCode = new Summernote();
        getSetCode.setCode("<b>This is custom code</b><u>OH YA</u>");

        initWidget(uiBinder.createAndBindUi(this));

        events.addInitializedHandler(new SummernoteInitializedHandler() {
            @Override
            public void onInitialize(SummernoteInitializedEvent event) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Initialized Event Fired!");
                logRow.add(logEntry);
            }
        });

        events.addEnterHandler(new SummernoteOnEnterHandler() {
            @Override
            public void onEnter(SummernoteOnEnterEvent event) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Enter Event Fired!");
                logRow.add(logEntry);
            }
        });

        events.addFocusHandler(new SummernoteOnFocusHandler() {
            @Override
            public void onFocus(SummernoteOnFocusEvent event) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Focus Event Fired!");
                logRow.add(logEntry);
            }
        });

        events.addBlurHandler(new SummernoteOnBlurHandler() {
            @Override
            public void onBlur(SummernoteOnBlurEvent event) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Blur Event Fired!");
                logRow.add(logEntry);
            }
        });

        events.addKeyUpHandler(new SummernoteOnKeyUpHandler() {
            @Override
            public void onKeyUp(SummernoteOnKeyUpEvent event) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Key Up Event Fired!");
                logRow.add(logEntry);
            }
        });

        events.addKeyDownHandler(new SummernoteOnKeyDownHandler() {
            @Override
            public void onKeyDown(SummernoteOnKeyDownEvent event) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Key Down Event Fired!");
                logRow.add(logEntry);
            }
        });

        events.addImageUploadHandler(new SummernoteOnImageUploadHandler() {
            @Override
            public void onImageUpload(SummernoteOnImageUploadEvent event) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Image Upload Event Fired!");
                logRow.add(logEntry);
            }
        });
    }
}
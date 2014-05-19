package org.gwtbootstrap3.demo.client.application.components;

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

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.RadioButton;
import org.gwtbootstrap3.client.ui.html.Paragraph;

/**
 * @author Joshua Godi
 */
public class ButtonGroupView extends ViewImpl implements ButtonGroupPresenter.MyView {

    interface Binder extends UiBinder<Widget, ButtonGroupView> {
    }

    @UiField
    RadioButton button1;

    @UiField
    RadioButton button2;

    @UiField
    RadioButton button3;

    @UiField
    FlowPanel log;

    @Inject
    ButtonGroupView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        button1.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(final ValueChangeEvent<Boolean> event) {
                log("Value of button1 changed to: " + event.getValue().toString());
            }
        });

        button2.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(final ValueChangeEvent<Boolean> event) {
                log("Value of button2 changed to: " + event.getValue().toString());
            }
        });

        button3.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(final ValueChangeEvent<Boolean> event) {
                log("Value of button3 changed to: " + event.getValue().toString());
            }
        });
    }

    private void log(final String msg) {
        final Paragraph p = new Paragraph();
        p.setText(msg);
        log.add(p);
    }
}
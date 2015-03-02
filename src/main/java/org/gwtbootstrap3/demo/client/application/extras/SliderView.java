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

import org.gwtbootstrap3.extras.slider.client.ui.Range;
import org.gwtbootstrap3.extras.slider.client.ui.RangeSlider;
import org.gwtbootstrap3.extras.slider.client.ui.Slider;
import org.gwtbootstrap3.extras.slider.client.ui.base.FormatterCallback;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * @author Xiaodong SUN
 */
public class SliderView extends ViewImpl implements SliderPresenter.MyView {

    @UiField Slider basicExample;
    @UiField RangeSlider rangeExample;
    @UiField Slider formatterExample;

    interface Binder extends UiBinder<Widget, SliderView> {}

    @Inject
    SliderView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        formatterExample.setFormatter(new FormatterCallback() {
            @Override
            public String formatTooltip(final double value) {
                return "Current value: " + value;
            }
        });
    }

    @UiHandler("enable")
    void onEnable(ClickEvent event) {
        basicExample.setEnabled(true);
    }

    @UiHandler("disable")
    void onDisable(ClickEvent event) {
        basicExample.setEnabled(false);
    }

    @UiHandler("toggle")
    void onToggle(ClickEvent event) {
        basicExample.toggle();
    }

    @UiHandler("isEnabled")
    void onIsEnabled(ClickEvent event) {
        basicExample.isEnabled();
    }

    @UiHandler("getValue")
    void onGetValue(ClickEvent event) {
        Window.alert(basicExample.getValue().toString());
    }

    @UiHandler("setValue")
    void onSetValue(ClickEvent event) {
        basicExample.setValue(10D);
    }

    @UiHandler("rangeEnable")
    void onRangeDisableEnable(ClickEvent event) {
        rangeExample.setEnabled(true);
    }

    @UiHandler("rangeDisable")
    void onRangeDisableDisable(ClickEvent event) {
        rangeExample.setEnabled(false);
    }

    @UiHandler("rangeToggle")
    void onRangeToggle(ClickEvent event) {
        rangeExample.toggle();
    }

    @UiHandler("rangeIsEnabled")
    void onRangeIsEnabled(ClickEvent event) {
        rangeExample.isEnabled();
    }

    @UiHandler("rangeGetValue")
    void onRangeGetValue(ClickEvent event) {
        Window.alert(rangeExample.getValue().toString());
    }

    @UiHandler("rangeSetValue")
    void onRangeSetValue(ClickEvent event) {
        rangeExample.setValue(new Range(400, 700));
    }
}

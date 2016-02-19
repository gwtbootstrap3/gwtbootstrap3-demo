package org.gwtbootstrap3.demo.client.application.extras;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2016 GwtBootstrap3
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

import java.util.Arrays;
import java.util.List;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.html.Paragraph;
import org.gwtbootstrap3.extras.select.client.ui.MultipleSelect;
import org.gwtbootstrap3.extras.select.client.ui.Select;
import org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers;
import org.gwtbootstrap3.extras.select.client.ui.event.HiddenEvent;
import org.gwtbootstrap3.extras.select.client.ui.event.HideEvent;
import org.gwtbootstrap3.extras.select.client.ui.event.LoadedEvent;
import org.gwtbootstrap3.extras.select.client.ui.event.RefreshedEvent;
import org.gwtbootstrap3.extras.select.client.ui.event.RenderedEvent;
import org.gwtbootstrap3.extras.select.client.ui.event.ShowEvent;
import org.gwtbootstrap3.extras.select.client.ui.event.ShownEvent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * @author godi
 */
public class BootstrapSelectView extends ViewImpl implements BootstrapSelectPresenter.MyView {

    @UiField Select simpleSelect;
    @UiField MultipleSelect multiSelect;
    @UiField Button setValueSimple;
    @UiField Button setValueMultiple;
    @UiField Button deselectAll;
    @UiField Button showHideSimple;
    @UiField Button showHideMultiple;
    @UiField Button disableEnableSimple;
    @UiField Button disableEnableMultiple;
    @UiField FlowPanel logRow;

    interface Binder extends UiBinder<Widget, BootstrapSelectView> {
    }

    @Inject
    BootstrapSelectView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("disableEnableSimple")
    void onClickDisableEnableSimple(ClickEvent event) {
        disableEnableSimple.setText(simpleSelect.isEnabled() ? "Enable" : "Disable");
        simpleSelect.setEnabled(!simpleSelect.isEnabled());
    }

    @UiHandler("showHideSimple")
    void onClickShowHideSimple(ClickEvent event) {
        showHideSimple.setText(simpleSelect.isVisible() ? "Show" : "Hide");
        simpleSelect.setVisible(!simpleSelect.isVisible());
    }

    @UiHandler("toggleSimple")
    void onClickToggleSimple(ClickEvent event) {
        simpleSelect.toggle();
    }

    @UiHandler("getValueSimple")
    void onClickGetValueSimple(ClickEvent event) {
        Window.alert("Simple select value: " + simpleSelect.getValue());
    }

    @UiHandler("setValueSimple")
    void onClickSetValueSimple(ClickEvent event) {
        simpleSelect.setValue("2", true);
    }

    @UiHandler("renderedSimple")
    void onClickRenderedSimple(ClickEvent event) {
        simpleSelect.render();
    }

    @UiHandler("refreshSimple")
    void onClickRefreshSimple(ClickEvent event) {
        simpleSelect.refresh();
    }

    @UiHandler("simpleSelect")
    void onLoadedSimpleSelect(LoadedEvent event) {
        addEventLog(true, HasAllSelectHandlers.LOADED_EVENT, "");
    }

    @UiHandler("simpleSelect")
    void onValueChangeSimple(ValueChangeEvent<String> event) {
        addEventLog(true, HasAllSelectHandlers.CHANGED_EVENT, "New value: " + event.getValue());
    }

    @UiHandler("simpleSelect")
    void onShowSimple(ShowEvent event) {
        addEventLog(true, HasAllSelectHandlers.SHOW_EVENT, "");
    }

    @UiHandler("simpleSelect")
    void onShownSimple(ShownEvent event) {
        addEventLog(true, HasAllSelectHandlers.SHOWN_EVENT, "");
    }

    @UiHandler("simpleSelect")
    void onHideSimple(HideEvent event) {
        addEventLog(true, HasAllSelectHandlers.HIDE_EVENT, "");
    }

    @UiHandler("simpleSelect")
    void onHiddenSimple(HiddenEvent event) {
        addEventLog(true, HasAllSelectHandlers.HIDDEN_EVENT, "");
    }

    @UiHandler("simpleSelect")
    void onRenderSimple(RenderedEvent event) {
        addEventLog(true, HasAllSelectHandlers.RENDERED_EVENT, "");
    }

    @UiHandler("simpleSelect")
    void onRefrechSimple(RefreshedEvent event) {
        addEventLog(true, HasAllSelectHandlers.REFRESHED_EVENT, "");
    }

    @UiHandler("disableEnableMultiple")
    void onClickDisableEnableMultiple(ClickEvent event) {
        disableEnableMultiple.setText(multiSelect.isEnabled() ? "Enable" : "Disable");
        multiSelect.setEnabled(!multiSelect.isEnabled());
    }

    @UiHandler("showHideMultiple")
    void onClickShowHideMultiple(ClickEvent event) {
        showHideMultiple.setText(multiSelect.isVisible() ? "Show" : "Hide");
        multiSelect.setVisible(!multiSelect.isVisible());
    }

    @UiHandler("toggleMultiple")
    void onClickToggleMultiple(ClickEvent event) {
        multiSelect.toggle();
    }

    @UiHandler("getValueMultiple")
    void onClickGetValueMultiple(ClickEvent event) {
        Window.alert("Multiple select value: " + multiSelect.getValue());
    }

    @UiHandler("setValueMultiple")
    void onClickSetValueMultiple(ClickEvent event) {
        multiSelect.setValue(Arrays.asList("2", "Relish"), true);
    }

    @UiHandler("renderMultiple")
    void onClickRenderMultiple(ClickEvent event) {
        multiSelect.render();
    }

    @UiHandler("refreshMultiple")
    void onClickrRefreshMultiple(ClickEvent event) {
        multiSelect.refresh();
    }

    @UiHandler("selectAll")
    void onClickSelectAll(ClickEvent event) {
        multiSelect.selectAll();
    }

    @UiHandler("deselectAll")
    void onClickDeselectAll(ClickEvent event) {
        multiSelect.deselectAll();
    }

    @UiHandler("multiSelect")
    void onLoadedMultiple(LoadedEvent event) {
        addEventLog(false, HasAllSelectHandlers.LOADED_EVENT, "");
    }

    @UiHandler("multiSelect")
    void onValueChangeMultiple(ValueChangeEvent<List<String>> event) {
        addEventLog(false, HasAllSelectHandlers.CHANGED_EVENT, "New value: " + event.getValue());
    }

    @UiHandler("multiSelect")
    void onShowMultiple(ShowEvent event) {
        addEventLog(false, HasAllSelectHandlers.SHOW_EVENT, "");
    }

    @UiHandler("multiSelect")
    void onShownMultiple(ShownEvent event) {
        addEventLog(false, HasAllSelectHandlers.SHOWN_EVENT, "");
    }

    @UiHandler("multiSelect")
    void onHideMultiple(HideEvent event) {
        addEventLog(false, HasAllSelectHandlers.HIDE_EVENT, "");
    }

    @UiHandler("multiSelect")
    void onHiddenMultiple(HiddenEvent event) {
        addEventLog(false, HasAllSelectHandlers.HIDDEN_EVENT, "");
    }

    @UiHandler("multiSelect")
    void onRenderMultiple(RenderedEvent event) {
        addEventLog(false, HasAllSelectHandlers.RENDERED_EVENT, "");
    }

    @UiHandler("multiSelect")
    void onRefreshMultiple(RefreshedEvent event) {
        addEventLog(false, HasAllSelectHandlers.REFRESHED_EVENT, "");
    }

    private void addEventLog(boolean simple, String eventName, String logSuffix) {
        final Paragraph logEntry = new Paragraph();
        logEntry.setHTML("<b>" + eventName + "</b> event fired on <b>"
                + (simple ? "simple" : "multiple") + "</b> select! " + logSuffix);
        logRow.add(logEntry);
    }

    @UiHandler("clearLogButton")
    void onClickclearLogButton(ClickEvent event) {
        logRow.clear();
    }
}
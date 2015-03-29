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
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.extras.bootbox.client.Bootbox;
import org.gwtbootstrap3.extras.bootbox.client.callback.AlertCallback;
import org.gwtbootstrap3.extras.bootbox.client.callback.ConfirmCallback;
import org.gwtbootstrap3.extras.bootbox.client.callback.PromptCallback;

/**
 * @author lyhcode
 */
public class BootboxJSView extends ViewImpl implements BootboxJSPresenter.MyView {

    @UiField
    Button alertButton;
    @UiField
    Button alertCallbackButton;
    @UiField
    Button confirmButton;
    @UiField
    Button promptButton;

    @UiHandler("alertButton")
    public void handleAlertButton(final ClickEvent event) {
        Bootbox.alert("Hello World");
    }

    @UiHandler("alertCallbackButton")
    public void handleAlertCallbackButton(final ClickEvent event) {
        Bootbox.alert("Hello World", new AlertCallback() {
            @Override
            public void callback() {
                Window.alert("Hello World Callback");
            }
        });
    }

    @UiHandler("confirmButton")
    public void handleConfirmButton(final ClickEvent event) {
        Bootbox.confirm("Hello World", new ConfirmCallback() {
            @Override
            public void callback(final boolean result) {
                Window.alert("Return: " + result);
            }
        });
    }

    @UiHandler("promptButton")
    public void handlePromptButton(final ClickEvent event) {
        Bootbox.prompt("Hello World", new PromptCallback() {
            @Override
            public void callback(final String result) {
                Window.alert("Return: " + result);
            }
        });
    }

    @UiHandler("dialogButton")
    public void handleButton(ClickEvent event) {
        Bootbox.Dialog.create()
            .setMessage("Dialog message!")
            .setCloseButton(false)
            .setTitle("<i class=\"fa fa-info-circle fa-3x text-info\" style=\"vertical-align: middle; padding-right:10px;\"></i>Dialog title")
            .addButton("OK", "btn-primary", new AlertCallback() {
                @Override
                public void callback() {
                    Window.alert("Ok button selected");
                }})
            .addButton("Cancel", "btn-danger")
            .show();
    }

    interface Binder extends UiBinder<Widget, BootboxJSView> {
    }

    @Inject
    BootboxJSView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}

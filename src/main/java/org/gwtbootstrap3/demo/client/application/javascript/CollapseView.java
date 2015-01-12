package org.gwtbootstrap3.demo.client.application.javascript;

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

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.shared.event.HideEvent;
import org.gwtbootstrap3.client.shared.event.HideHandler;
import org.gwtbootstrap3.client.shared.event.ShowEvent;
import org.gwtbootstrap3.client.shared.event.ShowHandler;
import org.gwtbootstrap3.client.ui.PanelCollapse;

/**
 * @author Joshua Godi
 */
public class CollapseView extends ViewImpl implements CollapsePresenter.MyView {
    interface Binder extends UiBinder<Widget, CollapseView> {
    }

    @UiField
    PanelCollapse collapseOne;

    @Inject
    CollapseView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        // Add handlers
        collapseOne.addShowHandler(new ShowHandler() {
            @Override
            public void onShow(ShowEvent showEvent) {
                Window.alert("SHOW ONE");
            }
        });

        collapseOne.addHideHandler(new HideHandler() {
            @Override
            public void onHide(HideEvent hideEvent) {
                Window.alert("HIDE ONE");
            }
        });
    }
}
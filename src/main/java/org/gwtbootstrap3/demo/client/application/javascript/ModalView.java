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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.shared.event.*;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.ModalBody;
import org.gwtbootstrap3.client.ui.ModalFooter;
import org.gwtbootstrap3.client.ui.html.Paragraph;
import org.gwtbootstrap3.client.ui.html.Span;

/**
 * @author Joshua Godi
 */
public class ModalView extends ViewImpl implements ModalPresenter.MyView {
    @UiField
    Modal eventModal;
    @UiField
    Button clearLogButton;
    @UiField
    FlowPanel logRow;
    @UiField
    Button createModal;

    interface Binder extends UiBinder<Widget, ModalView> {
    }

    @Inject
    ModalView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        clearLogButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                logRow.clear();
            }
        });

        eventModal.addHideHandler(new ModalHideHandler() {
            @Override
            public void onHide(final ModalHideEvent evt) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Hide event fired! (UiBinder Modal)");
                logRow.add(logEntry);
            }
        });

        eventModal.addHiddenHandler(new ModalHiddenHandler() {
            @Override
            public void onHidden(final ModalHiddenEvent evt) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Hidden event fired! (UiBinder Modal)");
                logRow.add(logEntry);
            }
        });

        eventModal.addShowHandler(new ModalShowHandler() {
            @Override
            public void onShow(final ModalShowEvent evt) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Show event fired! (UiBinder Modal)");
                logRow.add(logEntry);
            }
        });

        eventModal.addShownHandler(new ModalShownHandler() {
            @Override
            public void onShown(final ModalShownEvent evt) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Shown event fired! (UiBinder Modal)");
                logRow.add(logEntry);
            }
        });

        createModal.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                final Modal modal = new Modal();
                modal.setTitle("Java Created Modal");
                modal.setClosable(true);
                modal.setRemoveOnHide(true);

                modal.addHideHandler(new ModalHideHandler() {
                    @Override
                    public void onHide(final ModalHideEvent evt) {
                        final Paragraph logEntry = new Paragraph();
                        logEntry.setText("Hide event fired! (Java Created Modal)");
                        logRow.add(logEntry);
                    }
                });

                modal.addHiddenHandler(new ModalHiddenHandler() {
                    @Override
                    public void onHidden(final ModalHiddenEvent evt) {
                        final Paragraph logEntry = new Paragraph();
                        logEntry.setText("Hidden event fired! (Java Created Modal)");
                        logRow.add(logEntry);
                    }
                });

                modal.addShowHandler(new ModalShowHandler() {
                    @Override
                    public void onShow(final ModalShowEvent evt) {
                        final Paragraph logEntry = new Paragraph();
                        logEntry.setText("Show event fired! (Java Created Modal)");
                        logRow.add(logEntry);
                    }
                });

                modal.addShownHandler(new ModalShownHandler() {
                    @Override
                    public void onShown(final ModalShownEvent evt) {
                        final Paragraph logEntry = new Paragraph();
                        logEntry.setText("Shown event fired! (Java Created Modal)");
                        logRow.add(logEntry);
                    }
                });

                final ModalBody modalBody = new ModalBody();
                modalBody.add(new Span("Create in Java Code!"));

                final ModalFooter modalFooter = new ModalFooter();
                modalFooter.add(new Button("Click ME!", new ClickHandler() {
                    @Override
                    public void onClick(final ClickEvent event) {
                        final Paragraph logEntry = new Paragraph();
                        logEntry.setText("Click Event from Modal! (Java Created Modal)");
                        logRow.add(logEntry);
                    }
                }));

                modal.add(modalBody);
                modal.add(modalFooter);

                modal.show();
            }
        });
    }
}
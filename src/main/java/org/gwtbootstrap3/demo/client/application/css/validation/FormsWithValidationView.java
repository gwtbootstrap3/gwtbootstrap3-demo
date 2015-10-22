package org.gwtbootstrap3.demo.client.application.css.validation;

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
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.gwtbootstrap3.client.ui.Form;
import org.gwtbootstrap3.client.ui.PanelBody;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.form.error.BasicEditorError;
import org.gwtbootstrap3.extras.toggleswitch.client.ui.ToggleSwitch;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * @author Steven Jardine
 */
public class FormsWithValidationView extends ViewImpl implements FormsWithValidationPresenter.MyView {

    interface Binder extends UiBinder<Widget, FormsWithValidationView> {
    }

    interface CredentialDriver extends SimpleBeanEditorDriver<Credentials, CredentialsEditor> {
    }

    private static final CredentialDriver DRIVER = GWT.create(CredentialDriver.class);

    @Ignore
    @UiField
    protected TextBox allowBlankTextBox;

    @Ignore
    @UiField
    protected PanelBody body;

    @Ignore
    @UiField
    protected Form form;

    @Ignore
    @UiField
    protected DivElement result;

    @Ignore
    @UiField
    protected ToggleSwitch submitOnEnterToggle;

    @Ignore
    @UiField
    protected ToggleSwitch validateOnBlurToggle;

    @Ignore
    @UiField
    protected TextBox yesNoTextBox;

    @Inject
    FormsWithValidationView(final Binder uiBinder, CredentialsEditor editor) {
        initWidget(uiBinder.createAndBindUi(this));
        body.add(editor);
        DRIVER.initialize(editor);
        form.setSubmitOnEnter(true);
        submitOnEnterToggle.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                boolean on = event.getValue();
                form.setSubmitOnEnter(on);
            }
        });
        validateOnBlurToggle.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                boolean on = event.getValue();
                allowBlankTextBox.setValidateOnBlur(on);
                yesNoTextBox.setValidateOnBlur(on);
            }
        });

        yesNoTextBox.addValidator(new org.gwtbootstrap3.client.ui.form.validator.Validator<String>() {

            @Override
            public int getPriority() {
                return Priority.MEDIUM;
            }

            @Override
            public List<EditorError> validate(Editor<String> editor, String value) {
                List<EditorError> result = new ArrayList<EditorError>();
                String valueStr = value == null ? "" : value;
                if (!("Yes".equalsIgnoreCase(valueStr) || "No".equalsIgnoreCase(valueStr))) {
                    result.add(new BasicEditorError(yesNoTextBox, value, "Must be \"Yes\" or \"No\""));
                }
                return result;
            }
        });
    }

    /** {@inheritDoc} */
    @Override
    protected void onAttach() {
        super.onAttach();
        DRIVER.edit(new Credentials());
    }

    @UiHandler("formResetButton")
    public void onFormResetClick(ClickEvent event) {
        form.reset();
    }

    @UiHandler("formValidateButton")
    public void onFormValidateClick(ClickEvent event) {
        form.validate();
    }

    @UiHandler("loginButton")
    public void onLoginClick(ClickEvent event) {
        Credentials creds = DRIVER.flush();

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Credentials>> violations = validator.validate(creds, Default.class);
        if (violations.size() > 0) {
            DRIVER.setConstraintViolations(new ArrayList<ConstraintViolation<?>>(violations));
        }

        if (!DRIVER.hasErrors()) {
            result.setInnerText(creds.toString());
        }
    }

    @UiHandler("resetButton")
    public void onResetClick(ClickEvent event) {
        DRIVER.edit(new Credentials());
        result.removeAllChildren();
    }

}

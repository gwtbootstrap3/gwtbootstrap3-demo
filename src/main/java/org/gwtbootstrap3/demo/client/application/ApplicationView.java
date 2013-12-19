package org.gwtbootstrap3.demo.client.application;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * @author Joshua Godi
 */
public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {

    @UiField
    SimplePanel contentContainer;

    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @Inject
    ApplicationView(Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }

    @Override
    public void setInSlot(Object slot, final IsWidget content) {
        if (slot == ApplicationPresenter.TYPE_SetMainContent) {
            contentContainer.setWidget(content);
        } else {
            super.setInSlot(slot, content);
        }
    }
}
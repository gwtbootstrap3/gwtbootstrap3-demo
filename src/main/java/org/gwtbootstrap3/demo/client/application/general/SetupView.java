package org.gwtbootstrap3.demo.client.application.general;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class SetupView extends ViewImpl implements SetupPresenter.MyView {
    interface Binder extends UiBinder<Widget, SetupView> {
    }

    @Inject
    SetupView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}

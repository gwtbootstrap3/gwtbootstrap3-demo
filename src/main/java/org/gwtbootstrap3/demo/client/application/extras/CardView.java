package org.gwtbootstrap3.demo.client.application.extras;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * @author Joshua Godi
 */
public class CardView extends ViewImpl implements CardPresenter.MyView {

    interface Binder extends UiBinder<Widget, CardView> {
    }

    @Inject
    CardView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
package org.gwtbootstrap3.demo.client.application.extras;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.extras.select.client.ui.Option;
import org.gwtbootstrap3.extras.select.client.ui.Select;

/**
 * @author godi
 */
public class BootstrapSelectView extends ViewImpl implements BootstrapSelectPresenter.MyView {

    @UiField
    Select select;
    @UiField
    Option two;
    @UiField
    Option three;
    @UiField
    Button setValue;
    @UiField
    Button getValue;

    interface Binder extends UiBinder<Widget, BootstrapSelectView> {
    }

    @Inject
    BootstrapSelectView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        setValue.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                select.setValues(two, three);
                select.refresh();
            }
        });

        getValue.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.alert(select.getAllSelectedValues().toString());
            }
        });
    }
}
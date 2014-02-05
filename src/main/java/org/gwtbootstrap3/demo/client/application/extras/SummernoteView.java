package org.gwtbootstrap3.demo.client.application.extras;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.extras.summernote.client.ui.Summernote;
import org.gwtbootstrap3.extras.summernote.client.ui.base.Toolbar;

/**
 * @author godi
 */
public class SummernoteView extends ViewImpl implements SummernotePresenter.MyView {

    @UiField(provided = true)
    Summernote customToolbar;
    @UiField(provided = true)
    Summernote getSetCode;
    @UiField
    Button getCode;

    @UiHandler("getCode")
    public void handleClick(ClickEvent event) {
        Window.alert(getSetCode.getCode());
    }

    interface Binder extends UiBinder<Widget, SummernoteView> {
    }

    @Inject
    SummernoteView(Binder uiBinder) {
        // Setting up the custom summernotes
        customToolbar = new Summernote();
        customToolbar.setHeight(200);
        customToolbar.setToolbar(new Toolbar()
                .setShowBoldButton(true));

        getSetCode = new Summernote();
        getSetCode.setCode("<b>This is custom code</b><u>OH YA</u>");

        initWidget(uiBinder.createAndBindUi(this));
    }
}
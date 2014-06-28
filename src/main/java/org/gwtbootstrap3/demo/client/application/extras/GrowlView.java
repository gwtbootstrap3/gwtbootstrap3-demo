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
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.extras.growl.client.ui.*;

/**
 * @author Jeff Isenhart
 */
public class GrowlView extends ViewImpl implements GrowlPresenter.MyView {

    @UiField
    Button basicGrowl;
    @UiField
    Button basicGrowlWithTitle;
    @UiField
    Button basicGrowlWithTitleIcon;
    @UiField
    Button changeBackgroundAndDismiss;
    @UiField
    Button positionAndFormatting;

    @UiHandler("basicGrowl")
    public void handleBasicGrowl(final ClickEvent event) {
        Growl.growl("Message");
    }

    @UiHandler("basicGrowlWithTitle")
    public void handleBasicGrowlWithTitle(final ClickEvent event) {
    	Growl.growl("Title","Message");
    }

    @UiHandler("basicGrowlWithTitleIcon")
    public void handleBasicGrowlWithTitleIcon(final ClickEvent event) {
    	 Growl.growl("Title","Message",Styles.FONT_AWESOME_BASE + " " + IconType.SMILE_O.getCssName());
    }

    @UiHandler("changeBackgroundAndDismiss")
    public void handleChangeBackgroundAndDismiss(final ClickEvent event) {
    	GrowlOptions go = GrowlHelper.getNewOptions();
        go.setSuccessType();
        go.setAllowDismiss(false);
        Growl.growl("Title","Message",Styles.FONT_AWESOME_BASE + " " + IconType.SMILE_O.getCssName(),go);
    }

    @UiHandler("positionAndFormatting")
    public void handlePositionAndFormatting(final ClickEvent event) {
    	GrowlOptions go = GrowlHelper.getNewOptions();
        go.setWarningType();
        go.setAllowDismiss(false);

        GrowlPosition gp = GrowlHelper.getNewPosition();
        gp.setTop(false);
        gp.setCenter();
//        go.setPositionObject(gp);

        GrowlTemplate gt = GrowlHelper.getNewTemplate();
        gt.setTitleDivider("<hr>");

        go.setTemplateObject(gt);

        Growl.growl("Title","Message",Styles.FONT_AWESOME_BASE + " " + IconType.SMILE_O.getCssName(),go);
    }


    interface Binder extends UiBinder<Widget, GrowlView> {
    }

    @Inject
    GrowlView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}

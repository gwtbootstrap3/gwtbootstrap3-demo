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
import org.gwtbootstrap3.extras.animate.client.ui.constants.Animation;
import org.gwtbootstrap3.extras.growl.client.ui.*;

/**
 * @author Jeff Isenhart
 * @author Pavel Zlámal
 */
public class GrowlView extends ViewImpl implements GrowlPresenter.MyView {

    @UiField
    Button basicGrowl;
    @UiField
    Button basicGrowlWithTitleIcon;
    @UiField
    Button changeBackgroundAndDismiss;
    @UiField
    Button positionAndLink;
    @UiField
    Button animationAndOffset;
    @UiField
    Button template;

    @UiHandler("basicGrowl")
    public void handleBasicGrowl(final ClickEvent event) {
        Growl.growl("Message");
    }

    @UiHandler("basicGrowlWithTitleIcon")
    public void handleBasicGrowlWithTitleIcon(final ClickEvent event) {
        Growl.growl("Title", "Message", IconType.SMILE_O);
    }

    @UiHandler("changeBackgroundAndDismiss")
    public void handleChangeBackgroundAndDismiss(final ClickEvent event) {
        GrowlOptions go = new GrowlOptions();
        go.setType(GrowlType.SUCCESS);
        go.setAllowDismiss(false);
        Growl.growl("Title", "Message", IconType.SMILE_O, go);
    }

    @UiHandler("positionAndLink")
    public void handlePositionAndFormatting(final ClickEvent event) {

        GrowlOptions go = new GrowlOptions();
        go.setPosition(GrowlPosition.TOP_CENTER);

        Growl.growl("Title", "Message", IconType.SMILE_O, "https://github.com/gwtbootstrap3/gwtbootstrap3", go);

    }

    @UiHandler("animationAndOffset")
    public void handleAnimationAndOffset(final ClickEvent event) {

        GrowlOptions go = new GrowlOptions();
        go.setAnimation(Animation.TADA, Animation.LIGHTSPEED_OUT);
        go.setOffset(200, 140);

        Growl.growl("Title", "Message", IconType.SMILE_O, go);

    }

    @UiHandler("template")
    public void handleTemplate(final ClickEvent event) {

        GrowlOptions go = new GrowlOptions();
        go.setTemplate("<div data-growl=\"container\" class=\"alert\" role=\"alert\">\n" +
                "\t\t<button type=\"button\" class=\"close\" data-growl=\"dismiss\">\n" +
                "\t\t\t<span aria-hidden=\"true\">×</span>\n" +
                "\t\t\t<span class=\"sr-only\">Close</span>\n" +
                "\t\t</button>\n" +
                "\t\t<span data-growl=\"icon\"></span>\n" +
                "\t\t<b><span data-growl=\"title\"></span></b>\n" +
                "\t\t<span data-growl=\"message\"></span>\n" +
                "\t\t<a href=\"#\" data-growl=\"url\"></a>\n" +
                "\t</div>");

        go.makeDefault();

        Growl.growl("Title", "Message", IconType.SMILE_O);

    }

    interface Binder extends UiBinder<Widget, GrowlView> {
    }

    @Inject
    GrowlView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
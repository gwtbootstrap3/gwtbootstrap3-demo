package org.gwtbootstrap3.demo.client.application.extras;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2015 GwtBootstrap3
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

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.extras.animate.client.ui.constants.Animation;
import org.gwtbootstrap3.extras.notify.client.constants.NotifyPlacement;
import org.gwtbootstrap3.extras.notify.client.constants.NotifyType;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;
import org.gwtbootstrap3.extras.notify.client.ui.NotifySettings;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * @author Xiaodong SUN
 */
public class NotifyView extends ViewImpl implements NotifyPresenter.MyView {

    @UiField
    Button basicNotify;
    @UiField
    Button basicNotifyWithTitleIcon;
    @UiField
    Button changeBackgroundAndDismiss;
    @UiField
    Button positionAndLink;
    @UiField
    Button animationAndOffset;
    @UiField
    Button template;

    @UiHandler("basicNotify")
    public void handleBasicNotify(final ClickEvent event) {
        Notify.notify("Message");
    }

    @UiHandler("basicNotifyWithTitleIcon")
    public void handleBasicNotifyWithTitleIcon(final ClickEvent event) {
        Notify.notify("Title", "Message", IconType.SMILE_O);
    }

    @UiHandler("showProgressbar")
    public void handleShowProgressbar(final ClickEvent event) {
        NotifySettings settings = NotifySettings.newSettings();
        settings.setShowProgressbar(true);
        settings.setPauseOnMouseOver(true);
        Notify.notify("Title", "Message", IconType.SMILE_O, settings);
    }

    @UiHandler("changeBackgroundAndDismiss")
    public void handleChangeBackgroundAndDismiss(final ClickEvent event) {
        NotifySettings settings = NotifySettings.newSettings();
        settings.setType(NotifyType.SUCCESS);
        settings.setAllowDismiss(false);
        Notify.notify("Title", "Message", IconType.SMILE_O, settings);
    }

    @UiHandler("positionAndLink")
    public void handlePositionAndFormatting(final ClickEvent event) {
        NotifySettings settings = NotifySettings.newSettings();
        settings.setPlacement(NotifyPlacement.TOP_CENTER);
        Notify.notify("Title", "Message", IconType.SMILE_O, "https://github.com/gwtbootstrap3/gwtbootstrap3", settings);
    }

    @UiHandler("animationAndOffset")
    public void handleAnimationAndOffset(final ClickEvent event) {
        NotifySettings settings = NotifySettings.newSettings();
        settings.setAnimation(Animation.TADA, Animation.LIGHTSPEED_OUT);
        settings.setOffset(200, 140);
        Notify.notify("Title", "Message", IconType.SMILE_O, settings);
    }

    @UiHandler("template")
    public void handleTemplate(final ClickEvent event) {
        NotifySettings settings = NotifySettings.newSettings();
        settings.setTemplate("<div data-notify=\"container\" class=\"alert\" role=\"alert\">\n" +
                "\t\t<button type=\"button\" class=\"close\" data-notify=\"dismiss\">\n" +
                "\t\t\t<span aria-hidden=\"true\">×</span>\n" +
                "\t\t\t<span class=\"sr-only\">Close</span>\n" +
                "\t\t</button>\n" +
                "\t\t<span data-notify=\"icon\"></span>\n" +
                "\t\t<b><span data-notify=\"title\"></span></b>\n" +
                "\t\t<span data-notify=\"message\"></span>\n" +
                "\t\t<a href=\"#\" data-notify=\"url\"></a>\n" +
                "\t</div>");
        settings.makeDefault();
        Notify.notify("Title", "Message", IconType.SMILE_O);
    }

    interface Binder extends UiBinder<Widget, NotifyView> {
    }

    @Inject
    NotifyView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}

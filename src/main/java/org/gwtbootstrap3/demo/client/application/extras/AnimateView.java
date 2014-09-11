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
import org.gwtbootstrap3.extras.animate.client.ui.Animate;
import org.gwtbootstrap3.extras.animate.client.ui.constants.Animation;

/**
 * @author Pavel Zlámal
 */
public class AnimateView extends ViewImpl implements AnimatePresenter.MyView {

    interface Binder extends UiBinder<Widget, AnimateView> {
    }

    @Inject
    AnimateView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        Animate.animate(animated, Animation.RUBBER_BAND);
    }

    @UiField
    Button animated;

    @UiField
    Button run;

    @UiHandler("animated")
    public void onClickAnim(ClickEvent event) {
        Animate.animate(animated, Animation.RUBBER_BAND);
    }

    @UiHandler("run")
    public void onClick(ClickEvent event) {
        Animate.animate(run, Animation.RUBBER_BAND, 2, 4000);
    }

}

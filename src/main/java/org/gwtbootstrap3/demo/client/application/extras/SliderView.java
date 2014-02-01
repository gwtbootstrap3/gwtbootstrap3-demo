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

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.extras.slider.client.ui.Slider;
import org.gwtbootstrap3.extras.slider.client.ui.base.FormatterCallback;

/**
 * @author lyhcode
 */
public class SliderView extends ViewImpl implements SliderPresenter.MyView {

    @UiField
    Slider customSlider;

    interface Binder extends UiBinder<Widget, SliderView> {
    }

    @Inject
    SliderView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        customSlider.setFormatter(new FormatterCallback() {
            @Override
            public String toolTipMsg(double value) {
                int b = (int) (value * 10);
                return b + " blocks";
            }
        });
    }
}

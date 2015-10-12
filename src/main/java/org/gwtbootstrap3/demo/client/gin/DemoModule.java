package org.gwtbootstrap3.demo.client.gin;

import org.gwtbootstrap3.demo.client.application.ApplicationModule;
import org.gwtbootstrap3.demo.client.place.NameTokens;

import com.arcbees.analytics.client.AnalyticsModule;

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

import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

/**
 * @author Joshua Godi
 */
public class DemoModule extends AbstractPresenterModule {
    private static final String ANALYTICS_ACCOUNT = "UA-46636703-1";

    @Override
    protected void configure() {
        install(new DefaultModule());
        install(new ApplicationModule());
        install(new AnalyticsModule.Builder(ANALYTICS_ACCOUNT).build());
        
        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.HOME);
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.HOME);
        bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.HOME);
    }
}

package org.gwtbootstrap3.demo.client.application;

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

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.NavigationEvent;
import com.gwtplatform.mvp.client.proxy.NavigationHandler;
import com.gwtplatform.mvp.client.proxy.Proxy;
import org.gwtbootstrap3.client.ui.NavbarCollapse;

/**
 * @author Joshua Godi
 */
public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {

    @ProxyStandard
    public interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    public interface MyView extends View {
        NavbarCollapse getNavbarCollapse();
    }

    /**
     * Use this in leaf presenters, inside their {@link #revealInParent} method.
     */
    public static final NestedSlot TYPE_SetMainContent = new NestedSlot();

    @Inject
    ApplicationPresenter(final EventBus eventBus,
                         final MyView view,
                         final MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);

        // need to reset display because display is not reloaded every time (like conventional web site)
        eventBus.addHandler(NavigationEvent.getType(), new NavigationHandler() {
            @Override
            public void onNavigation(NavigationEvent navigationEvent) {
                Scheduler.get().scheduleDeferred(new Command() {
                    @Override
                    public void execute() {
                        // Making the window scroll to top on every page change
                        Window.scrollTo(0, 0);
                        // and collapse any nav menus
                        hideNavbarCollapse();
                    }
                });
            }
        });
    }

    private void hideNavbarCollapse() {
        NavbarCollapse navbarCollapse = getView().getNavbarCollapse();
        String ariaExpanded = navbarCollapse.getElement().getAttribute("aria-expanded");
        if (Boolean.parseBoolean(ariaExpanded)) {
            navbarCollapse.toggle();
        }
    }
}
package org.gwtbootstrap3.demo.client.application;

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

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import org.gwtbootstrap3.demo.client.application.components.*;
import org.gwtbootstrap3.demo.client.application.css.*;
import org.gwtbootstrap3.demo.client.application.css.validation.FormsWithValidationPresenter;
import org.gwtbootstrap3.demo.client.application.css.validation.FormsWithValidationView;
import org.gwtbootstrap3.demo.client.application.extras.*;
import org.gwtbootstrap3.demo.client.application.general.HomePresenter;
import org.gwtbootstrap3.demo.client.application.general.HomeView;
import org.gwtbootstrap3.demo.client.application.general.SetupPresenter;
import org.gwtbootstrap3.demo.client.application.general.SetupView;
import org.gwtbootstrap3.demo.client.application.javascript.*;

/**
 * @author Joshua Godi
 */
public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        // Main Application View
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class, ApplicationPresenter.MyProxy.class);

        // General Views
        bindPresenter(HomePresenter.class, HomePresenter.MyView.class, HomeView.class, HomePresenter.MyProxy.class);
        bindPresenter(SetupPresenter.class, SetupPresenter.MyView.class, SetupView.class, SetupPresenter.MyProxy.class);

        // CSS Views
        bindPresenter(GridSystemPresenter.class, GridSystemPresenter.MyView.class, GridSystemView.class, GridSystemPresenter.MyProxy.class);
        bindPresenter(TypographyPresenter.class, TypographyPresenter.MyView.class, TypographyView.class, TypographyPresenter.MyProxy.class);
        bindPresenter(CodePresenter.class, CodePresenter.MyView.class, CodeView.class, CodePresenter.MyProxy.class);
        bindPresenter(TablesPresenter.class, TablesPresenter.MyView.class, TablesView.class, TablesPresenter.MyProxy.class);
        bindPresenter(FormsPresenter.class, FormsPresenter.MyView.class, FormsView.class, FormsPresenter.MyProxy.class);
        bindPresenter(FormsWithValidationPresenter.class, FormsWithValidationPresenter.MyView.class, FormsWithValidationView.class, FormsWithValidationPresenter.MyProxy.class);
        bindPresenter(ButtonsPresenter.class, ButtonsPresenter.MyView.class, ButtonsView.class, ButtonsPresenter.MyProxy.class);
        bindPresenter(ImagesPresenter.class, ImagesPresenter.MyView.class, ImagesView.class, ImagesPresenter.MyProxy.class);
        bindPresenter(ResponsiveUtilitiesPresenter.class, ResponsiveUtilitiesPresenter.MyView.class, ResponsiveUtilitiesView.class, ResponsiveUtilitiesPresenter.MyProxy.class);

        // Component Views
        bindPresenter(AlertPresenter.class, AlertPresenter.MyView.class, AlertView.class, AlertPresenter.MyProxy.class);
        bindPresenter(BadgePresenter.class, BadgePresenter.MyView.class, BadgeView.class, BadgePresenter.MyProxy.class);
        bindPresenter(BreadcrumbPresenter.class, BreadcrumbPresenter.MyView.class, BreadcrumbView.class, BreadcrumbPresenter.MyProxy.class);
        bindPresenter(ButtonDropdownPresenter.class, ButtonDropdownPresenter.MyView.class, ButtonDropdownView.class, ButtonDropdownPresenter.MyProxy.class);
        bindPresenter(ButtonGroupPresenter.class, ButtonGroupPresenter.MyView.class, ButtonGroupView.class, ButtonGroupPresenter.MyProxy.class);
        bindPresenter(DropdownPresenter.class, DropdownPresenter.MyView.class, DropdownView.class, DropdownPresenter.MyProxy.class);
        bindPresenter(IconPresenter.class, IconPresenter.MyView.class, IconView.class, IconPresenter.MyProxy.class);
        bindPresenter(InputGroupPresenter.class, InputGroupPresenter.MyView.class, InputGroupView.class, InputGroupPresenter.MyProxy.class);
        bindPresenter(JumbotronPresenter.class, JumbotronPresenter.MyView.class, JumbotronView.class, JumbotronPresenter.MyProxy.class);
        bindPresenter(LabelPresenter.class, LabelPresenter.MyView.class, LabelView.class, LabelPresenter.MyProxy.class);
        bindPresenter(ListGroupPresenter.class, ListGroupPresenter.MyView.class, ListGroupView.class, ListGroupPresenter.MyProxy.class);
        bindPresenter(MediaObjectPresenter.class, MediaObjectPresenter.MyView.class, MediaObjectView.class, MediaObjectPresenter.MyProxy.class);
        bindPresenter(NavbarPresenter.class, NavbarPresenter.MyView.class, NavbarView.class, NavbarPresenter.MyProxy.class);
        bindPresenter(NavPresenter.class, NavPresenter.MyView.class, NavView.class, NavPresenter.MyProxy.class);
        bindPresenter(PageHeaderPresenter.class, PageHeaderPresenter.MyView.class, PageHeaderView.class, PageHeaderPresenter.MyProxy.class);
        bindPresenter(PaginationPresenter.class, PaginationPresenter.MyView.class, PaginationView.class, PaginationPresenter.MyProxy.class);
        bindPresenter(PanelPresenter.class, PanelPresenter.MyView.class, PanelView.class, PanelPresenter.MyProxy.class);
        bindPresenter(ProgressBarPresenter.class, ProgressBarPresenter.MyView.class, ProgressBarView.class, ProgressBarPresenter.MyProxy.class);
        bindPresenter(SuggestBoxPresenter.class, SuggestBoxPresenter.MyView.class, SuggestBoxView.class, SuggestBoxPresenter.MyProxy.class);
        bindPresenter(ThumbnailPresenter.class, ThumbnailPresenter.MyView.class, ThumbnailView.class, ThumbnailPresenter.MyProxy.class);
        bindPresenter(WellPresenter.class, WellPresenter.MyView.class, WellView.class, WellPresenter.MyProxy.class);

        // JavaScript Views
        bindPresenter(AffixPresenter.class, AffixPresenter.MyView.class, AffixView.class, AffixPresenter.MyProxy.class);
        bindPresenter(CarouselPresenter.class, CarouselPresenter.MyView.class, CarouselView.class, CarouselPresenter.MyProxy.class);
        bindPresenter(CollapsePresenter.class, CollapsePresenter.MyView.class, CollapseView.class, CollapsePresenter.MyProxy.class);
        bindPresenter(ModalPresenter.class, ModalPresenter.MyView.class, ModalView.class, ModalPresenter.MyProxy.class);
        bindPresenter(PopoverPresenter.class, PopoverPresenter.MyView.class, PopoverView.class, PopoverPresenter.MyProxy.class);
        bindPresenter(TooltipPresenter.class, TooltipPresenter.MyView.class, TooltipView.class, TooltipPresenter.MyProxy.class);
        bindPresenter(TabPresenter.class, TabPresenter.MyView.class, TabView.class, TabPresenter.MyProxy.class);

        // Extra Views
        bindPresenter(DateTimePickerPresenter.class, DateTimePickerPresenter.MyView.class, DateTimePickerView.class, DateTimePickerPresenter.MyProxy.class);
        bindPresenter(DatePickerPresenter.class, DatePickerPresenter.MyView.class, DatePickerView.class, DatePickerPresenter.MyProxy.class);
        bindPresenter(BootboxJSPresenter.class, BootboxJSPresenter.MyView.class, BootboxJSView.class, BootboxJSPresenter.MyProxy.class);
        bindPresenter(CardPresenter.class, CardPresenter.MyView.class, CardView.class, CardPresenter.MyProxy.class);
        bindPresenter(SliderPresenter.class, SliderPresenter.MyView.class, SliderView.class, SliderPresenter.MyProxy.class);
        bindPresenter(SummernotePresenter.class, SummernotePresenter.MyView.class, SummernoteView.class, SummernotePresenter.MyProxy.class);
        bindPresenter(BootstrapSelectPresenter.class, BootstrapSelectPresenter.MyView.class, BootstrapSelectView.class, BootstrapSelectPresenter.MyProxy.class);
        bindPresenter(ToggleSwitchPresenter.class, ToggleSwitchPresenter.MyView.class, ToggleSwitchView.class, ToggleSwitchPresenter.MyProxy.class);
        bindPresenter(TypeaheadPresenter.class, TypeaheadPresenter.MyView.class, TypeaheadView.class, TypeaheadPresenter.MyProxy.class);
        bindPresenter(OfflinePresenter.class, OfflinePresenter.MyView.class, OfflineView.class, OfflinePresenter.MyProxy.class);
        bindPresenter(NotifyPresenter.class, NotifyPresenter.MyView.class, NotifyView.class, NotifyPresenter.MyProxy.class);
        bindPresenter(FullCalendarPresenter.class, FullCalendarPresenter.MyView.class, FullCalendarView.class, FullCalendarPresenter.MyProxy.class);
        bindPresenter(AnimatePresenter.class, AnimatePresenter.MyView.class, AnimateView.class, AnimatePresenter.MyProxy.class);
        bindPresenter(GalleryPresenter.class, GalleryPresenter.MyView.class, GalleryView.class, GalleryPresenter.MyProxy.class);
    }
}

package org.gwtbootstrap3.demo.client.gin;

import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.GaAccount;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import org.gwtbootstrap3.demo.client.application.ApplicationModule;
import org.gwtbootstrap3.demo.client.place.NameTokens;

/**
 * @author Joshua Godi
 */
public class DemoModule extends AbstractPresenterModule {
    private static final String ANALYTICS_ACCOUNT = "UA-46636703-1";

    @Override
    protected void configure() {
        install(new DefaultModule());
        install(new ApplicationModule());

        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.HOME);
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.HOME);
        bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.HOME);

        // Google Analytics
        bindConstant().annotatedWith(GaAccount.class).to(ANALYTICS_ACCOUNT);
    }
}

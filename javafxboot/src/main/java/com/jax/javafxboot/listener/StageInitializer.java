package com.jax.javafxboot.listener;

import com.jax.javafxboot.GuiApplication;
import com.jax.javafxboot.service.MainService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<GuiApplication.StageReadyEvent> {

    private final MainService mainService;
    private String applicationTitle;
    private ApplicationContext applicationContext;

    public StageInitializer(MainService mainService,
                            @Value("${application.title}") String applicationTitle,
                            ApplicationContext applicationContext){
        this.mainService = mainService;
        this.applicationTitle = applicationTitle;
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(GuiApplication.StageReadyEvent event) {
        mainService.setStage(event.getStage());
        mainService.showViews();
    }
}

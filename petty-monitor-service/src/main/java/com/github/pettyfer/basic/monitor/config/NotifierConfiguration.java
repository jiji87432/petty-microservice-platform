package com.github.pettyfer.basic.monitor.config;

import com.github.pettyfer.basic.monitor.notifier.ServiceStatusNotifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * @author Petty
 */
@Configuration
@EnableScheduling
public class NotifierConfiguration {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Bean
    @Primary
    public RemindingNotifier remindingNotifier() {
        RemindingNotifier remindingNotifier = new RemindingNotifier(serviceStatusNotifier());
        remindingNotifier.setReminderPeriod(TimeUnit.MINUTES.toMillis(1));
        return remindingNotifier;
    }

    @Bean
    public ServiceStatusNotifier serviceStatusNotifier() {
        return new ServiceStatusNotifier(rabbitTemplate);
    }

    @Scheduled(fixedRate = 60_000L)
    public void remind() {
        remindingNotifier().sendReminders();
    }

}

package com.dtelec.icmes.information.controller.context.annotation;

import org.springframework.context.annotation.Import;
import com.dtelec.icmes.information.config.ContextTransmitterAutoConfig;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({ContextTransmitterAutoConfig.class})
public @interface EnableUserInfoTransmitter {
	// do nothing
}
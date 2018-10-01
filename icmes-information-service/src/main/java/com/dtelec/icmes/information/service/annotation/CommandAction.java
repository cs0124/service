package com.dtelec.icmes.information.service.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.axonframework.commandhandling.CommandHandler;

@Documented
@Retention(RUNTIME)
@Target({METHOD, CONSTRUCTOR, ANNOTATION_TYPE})
@CommandHandler
public @interface CommandAction {
    // do nothing
}

package com.dtelec.icmes.information.service.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.axonframework.queryhandling.QueryHandler;

@Documented
@Retention(RUNTIME)
@Target({METHOD, ANNOTATION_TYPE})
@QueryHandler
public @interface QueryAction {
    // do nothing
}

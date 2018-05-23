package bel.sigursoft.hammock.example;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.inject.Qualifier;

@Qualifier
@Target({FIELD, PARAMETER, METHOD})
@Retention(RUNTIME)
@Documented
public @interface SmallCache {}

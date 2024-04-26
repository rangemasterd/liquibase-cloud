package it.rangemaster.liquibase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class SecretsTest {

    @ParameterizedTest
    @NullSource
    @EmptySource
    void givenInvalidUrlValue_whenConstruct_thenThrowException(String url) {
        Exception exception = assertThrows(
            Exception.class,
             () -> new Secrets(url, "username", "password")
        );

        assertEquals("Url must not be null nor empty", exception.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    void givenInvalidUserValue_whenConstruct_thenThrowException(String user) {
        Exception exception = assertThrows(
            Exception.class,
             () -> new Secrets("url", user, "password")
        );

        assertEquals("Username must not be null nor empty", exception.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    void givenInvalidPasswordValue_whenConstruct_thenThrowException(String password) {
        Exception exception = assertThrows(
            Exception.class,
             () -> new Secrets("url", "username", password)
        );

        assertEquals("Password must not be null nor empty", exception.getMessage());
    }
}

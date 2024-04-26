package it.rangemaster.liquibase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class SecretPathTest {

    @ParameterizedTest
    @NullSource
    @EmptySource
    void givenInvalidUrlPathValue_whenConstruct_thenThrowException(String pathValue) {
        Exception exception = assertThrows(
            Exception.class,
             () -> new SecretPath(pathValue)
        );

        assertEquals("Secret path must not be null nor empty", exception.getMessage());
    }
}

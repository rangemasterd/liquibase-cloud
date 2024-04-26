package it.rangemaster.liquibase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SecretsPrinterTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    private SecretsAccessor secretsAccessorMock;

    private SecretsPrinter SUT;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        SUT = new SecretsPrinter(secretsAccessorMock);
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void givenNotEnaoughParameters_whenPrintToStdOut_thenThrowException() {
        String[] args = new String[] {"a", "b"};

        Exception exception = assertThrows(
            Exception.class,
            () -> SUT.toStandardOutput(args)
        );

        assertEquals("Required 3 arguments, but found 2", exception.getMessage());
    }

    @Test
    void givenMoreNeededParameters_whenPrintToStdOut_thenThrowException() {
        String[] args = new String[] {"a", "b", "c", "d"};

        Exception exception = assertThrows(
            Exception.class,
            () -> SUT.toStandardOutput(args)
        );

        assertEquals("Required 3 arguments, but found 4", exception.getMessage());
    }

    @Test
    void givenSecretAccessorException_whenPrintToStdOut_thenThrowException() throws IOException {
        String[] args = new String[] {"a", "b", "c"};

        when(
            secretsAccessorMock.retrieve(
                any(SecretPath.class),
                any(SecretPath.class),
                any(SecretPath.class)
            )
        )
        .thenThrow(IOException.class);

        assertThrows(
            IOException.class,
            () -> SUT.toStandardOutput(args)
        );
    }

    @Test
    void whenPrintToStdOutput_thenDoIt() throws IOException {
        String[] args = new String[] {"urlPath", "userPath", "passwordPath"};

        Secrets secretsMock = mock(Secrets.class);
        when(secretsMock.url()).thenReturn("url");
        when(secretsMock.username()).thenReturn("user");
        when(secretsMock.password()).thenReturn("password");

        when(
            secretsAccessorMock.retrieve(
                any(SecretPath.class),
                any(SecretPath.class),
                any(SecretPath.class)
            )
        )
        .thenReturn(secretsMock);

        SUT.toStandardOutput(args);

        assertEquals("url user password", outputStreamCaptor.toString());
    }
}

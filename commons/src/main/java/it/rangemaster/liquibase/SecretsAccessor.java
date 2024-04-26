package it.rangemaster.liquibase;

import java.io.IOException;

/**
 * This interface defines a contract for classes that retrieve secrets based on specified paths.
 */
public interface SecretsAccessor {

    /**
     * Retrieves secrets based on the provided paths.
     *
     * @param url the url secret path
     * @param username the username secret path
     * @param password the password secret path
     * @return The secrets retrieved based on the specified paths.
     * @throws IOException If an I/O error occurs while retrieving the secrets.
     */
    Secrets retrieve(SecretPath url, SecretPath username, SecretPath password) throws IOException;
}

package it.rangemaster.liquicloud;

import java.io.IOException;

/**
 * This interface defines a contract for classes that retrieve secrets based on specified paths.
 */
public interface SecretsAccessor {

    /**
     * Retrieves secrets based on the provided paths.
     *
     * @param urlPath the url secret path
     * @param usernamePath the username secret path
     * @param passwordPath the password secret path
     * @return The secrets retrieved based on the specified paths.
     * @throws IOException If an I/O error occurs while retrieving the secrets.
     */
    Secrets retrieve(SecretPath urlPath, SecretPath usernamePath, SecretPath passwordPath) throws IOException;
}

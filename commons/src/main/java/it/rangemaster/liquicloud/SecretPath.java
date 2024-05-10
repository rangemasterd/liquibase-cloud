package it.rangemaster.liquicloud;

/**
 * The SecretPath record represents a path to a secret, such as a URL, username, or password.
 * It encapsulates the path value and provides argument validation in the constructor.
 */
public record SecretPath(String value) {

    /**
     * Constructs a SecretPath object with the specified path value.
     *
     * @param value The secret path value.
     * @throws IllegalArgumentException If the path value is null or empty.
     */
    public SecretPath {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Secret path must not be null nor empty");
        }
    }
}

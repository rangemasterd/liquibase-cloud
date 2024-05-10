package it.rangemaster.liquicloud;

/**
 * Represents sensitive information for accessing the DB
 */
public record Secrets(String url, String username, String password) {

    /**
     * Constructor for the Secrets class.
     *
     * @param url       The URL being connected to.
     * @param username  The username for authentication.
     * @param password  The password for authentication.
     * @throws IllegalArgumentException If the URL, username, or password is null or empty.
     */
    public Secrets {
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("Url must not be null nor empty");
        }
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username must not be null nor empty");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password must not be null nor empty");
        }
    }
}

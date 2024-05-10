package it.rangemaster.liquicloud.gcp;

import java.io.IOException;

import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;

import it.rangemaster.liquicloud.SecretPath;
import it.rangemaster.liquicloud.Secrets;
import it.rangemaster.liquicloud.SecretsAccessor;

public class GcpSecretAccessor implements SecretsAccessor {

    @Override
    public Secrets retrieve(SecretPath urlPath, SecretPath usernamePath, SecretPath passwordPath) throws IOException {
        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {

            AccessSecretVersionResponse urlSecret = client.accessSecretVersion(urlPath.value());
            AccessSecretVersionResponse usernameSecret = client.accessSecretVersion(usernamePath.value());
            AccessSecretVersionResponse passwordSecret = client.accessSecretVersion(passwordPath.value());

            return new Secrets(
                urlSecret.getPayload().getData().toStringUtf8(),
                usernameSecret.getPayload().getData().toStringUtf8(),
                passwordSecret.getPayload().getData().toStringUtf8()
            );
        }
    }
}

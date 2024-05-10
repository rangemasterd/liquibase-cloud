package it.rangemaster.liquicloud.gcp;

import java.io.IOException;

import it.rangemaster.liquicloud.SecretsPrinter;

public class GCP {
    
    public static void main(String[] args) throws IOException {
        GcpSecretAccessor secretAccessor = new GcpSecretAccessor();

        SecretsPrinter secretsPrinter = new SecretsPrinter(secretAccessor);

        secretsPrinter.toStandardOutput(args);
    }
}
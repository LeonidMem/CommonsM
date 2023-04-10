package ru.leonidm.commons.net;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class RResponse {

    private final int code;
    private final InputStream inputStream;

    RResponse(int code, @NotNull InputStream inputStream) {
        this.code = code;
        this.inputStream = inputStream;
    }

    public byte @NotNull [] getResponse() {
        try {
            byte[] out = inputStream.readAllBytes();
            inputStream.close();
            return out;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @NotNull
    public String getResponseAsString() {
        try {
            StringBuilder out = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line).append('\n');
            }

            return out.toString();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public int getCode() {
        return code;
    }
}

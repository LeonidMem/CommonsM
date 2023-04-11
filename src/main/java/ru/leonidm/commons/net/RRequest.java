package ru.leonidm.commons.net;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public final class RRequest implements Cloneable {

    private final String url;
    private final Map<String, String> parameters = new HashMap<>();
    private final Map<String, String> headers = new HashMap<>();

    private RRequest(String url) {
        this.url = url;
    }

    @NotNull
    public static RRequest of(@NotNull String url) {
        return new RRequest(url);
    }

    @NotNull
    public RRequest addHeader(@NotNull String key, @NotNull String value) {
        headers.put(key, value);
        return this;
    }

    /**
     * @param keysAndValues Keys and values, like "Content-type", "application/json"
     * @throws IllegalArgumentException If input array has odd amount of values
     *                                  (there isn't a value for last key)
     */
    public RRequest addHeaders(@NotNull String @NotNull ... keysAndValues) {
        if (keysAndValues.length % 2 == 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < keysAndValues.length; i += 2) {
            headers.put(keysAndValues[i], keysAndValues[i + 1]);
        }
        return this;
    }

    public RRequest addParameter(@NotNull String key, @NotNull String value) {
        parameters.put(key, value);
        return this;
    }

    public RRequest addParameters(@NotNull String @NotNull ... keysAndValues) {
        if (keysAndValues.length % 2 == 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < keysAndValues.length; i += 2) {
            parameters.put(keysAndValues[i], keysAndValues[i + 1]);
        }
        return this;
    }

    @Override
    public RRequest clone() {
        try {
            return (RRequest) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @NotNull
    public RResponse send(@NotNull Method method) {
        return send(method, (byte[]) null);
    }

    @NotNull
    public RResponse send(@NotNull Method method, @NotNull String body) {
        return send(method, body.getBytes());
    }

    @NotNull
    public RResponse send(@NotNull Method method, byte @Nullable [] body) {
        try {

            StringBuilder urlBuilder = new StringBuilder(url);

            if (parameters.size() != 0) {
                urlBuilder.append('?');
                for (Map.Entry<String, String> parameter : parameters.entrySet()) {
                    urlBuilder.append(parameter.getKey()).append('=').append(parameter.getValue()).append('&');
                }

                urlBuilder.replace(urlBuilder.length() - 1, urlBuilder.length(), "");
            }

            URL url = new URL(urlBuilder.toString());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method.toString());
            connection.setDoOutput(true);

            method.consumer.accept(connection, body);

            for (Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getValue(), header.getKey());
            }

            connection.setRequestProperty("keepAlive", "false");

            int responseCode = connection.getResponseCode();
            InputStream responseInputStream = connection.getInputStream();

            return new RResponse(responseCode, responseInputStream);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public enum Method {
        GET,
        POST((connection, bytes) -> {
            try {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        private final BiConsumer<HttpURLConnection, byte[]> consumer;

        Method() {
            this.consumer = (connection, bytes) -> {
            };
        }

        Method(@NotNull BiConsumer<HttpURLConnection, byte[]> consumer) {
            this.consumer = consumer;
        }
    }
}

package ru.leonidm.commons.functions;

public class UncheckedException extends IllegalStateException {

    UncheckedException(Throwable cause) {
        super(cause);
    }
}

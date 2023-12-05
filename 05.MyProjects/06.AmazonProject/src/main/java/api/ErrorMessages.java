package api;

import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_OK;

public class ErrorMessages {

    public static final String ERROR_MESSAGE_STATUS_CODE = format("Incorrect status code. Expected %s.", SC_OK);

}

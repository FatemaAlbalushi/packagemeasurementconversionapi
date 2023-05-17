package PackageMeasurementConversionapi.com.packagemeasurementconversionapi.Service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class MeasurementValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeasurementValidator.class);


    public static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            String errorMessage = "Input cannot be empty.";

            throw new IllegalArgumentException(errorMessage);
        }
        if (!input.matches("[a-zA-Z_]+")) {
            String errorMessage = "Invalid input format. Only alphabetic characters and underscore are allowed.";

            throw new IllegalArgumentException(errorMessage);
        }
    }
}

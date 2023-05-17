package PackageMeasurementConversionapi.com.packagemeasurementconversionapi.Service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The MeasurementValidator class provides methods to validate measurement inputs.
 * It checks if the input is empty or contains invalid characters.
 */
@Component
public class MeasurementValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeasurementValidator.class);

    /**
     * Validates the measurement input.
     * @param input The measurement input string to be validated.
     * @throws IllegalArgumentException If the input is empty or contains invalid characters.
     */
    public static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            String errorMessage = "Input cannot be empty.";
            LOGGER.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        if (!input.matches("[a-zA-Z_]+")) {
            String errorMessage = "Invalid input format. Only alphabetic characters and underscore are allowed.";
            LOGGER.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }
}

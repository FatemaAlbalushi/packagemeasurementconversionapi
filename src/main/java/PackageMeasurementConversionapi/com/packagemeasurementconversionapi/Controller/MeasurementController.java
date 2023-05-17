package PackageMeasurementConversionapi.com.packagemeasurementconversionapi.Controller;

import PackageMeasurementConversionapi.com.packagemeasurementconversionapi.Model.MeasurementRequest;
import PackageMeasurementConversionapi.com.packagemeasurementconversionapi.Service.MeasurementService;
import PackageMeasurementConversionapi.com.packagemeasurementconversionapi.Service.MeasurementValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The MeasurementController class handles requests related to measurement conversions.
 * It is responsible for validating the input, converting measurements, and returning the converted result.
 */
@RestController
public class MeasurementController {

    private final MeasurementService measurementService;
    private final MeasurementValidator measurementValidator;
    private static final Logger LOGGER = LoggerFactory.getLogger(MeasurementController.class);

    /**
     * Constructs a new instance of MeasurementController.
     *
     * @param measurementService   The measurement service to handle measurement conversions.
     * @param measurementValidator The validator to validate the measurement input.
     */
    @Autowired
    public MeasurementController(MeasurementService measurementService, MeasurementValidator measurementValidator) {
        this.measurementService = measurementService;
        this.measurementValidator = measurementValidator;
    }

    /**
     * Handles the GET request for measurement conversion.
     *
     * @param request The MeasurementRequest object containing the measurement input.
     * @return The MeasurementResponse object containing the converted measurements.
     * @throws IllegalArgumentException If the input is invalid or not supported.
     */
    @GetMapping("/convert-measurements")
    public List<Integer> convertMeasurements(@ModelAttribute MeasurementRequest request) {
        String input = request.getInput();
        LOGGER.info("Received measurement conversion request: {}", input);
        try {
            measurementValidator.validateInput(input); // Validate the input
            List<Integer> result = measurementService.convertMeasurements(input);
            List<Integer> output = measurementService.processMeasurements(result);
            LOGGER.info("Converted measurements: {}", output);
            return output;
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Invalid input: {}", ex.getMessage());
            throw ex;
        }
    }

    /**
     * Handles the exception thrown when an invalid input is received.
     *
     * @param ex The IllegalArgumentException thrown.
     * @return The ResponseEntity with a BAD_REQUEST status and the error message.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        LOGGER.error("Invalid input: {}", ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

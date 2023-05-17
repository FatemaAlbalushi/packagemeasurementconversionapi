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


@RestController
public class MeasurementController {

    private final MeasurementService measurementService;
    private final MeasurementValidator measurementValidator;
    private static final Logger LOGGER = LoggerFactory.getLogger(MeasurementController.class);


    @Autowired
    public MeasurementController(MeasurementService measurementService, MeasurementValidator measurementValidator) {
        this.measurementService = measurementService;
        this.measurementValidator = measurementValidator;
    }

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


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        LOGGER.error("Invalid input: {}", ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

package PackageMeasurementConversionapi.com.packagemeasurementconversionapi.Model;



/**
 * The MeasurementRequest class represents a request for measurement conversion.
 */
public class MeasurementRequest {
    private String input;

    /**
     * Constructs an empty MeasurementRequest object.
     */
    public MeasurementRequest() {
    }

    /**
     * Constructs a MeasurementRequest object with the specified input.
     * @param input The measurement input to be converted.
     */
    public MeasurementRequest(String input) {
        this.input = input;
    }

    /**
     * Retrieves the measurement input.
     * @return The measurement input.
     */
    public String getInput() {
        return input;
    }

    /**
     * Sets the measurement input.
     * @param input The measurement input to be set.
     */
    public void setInput(String input) {
        this.input = input;
    }
}

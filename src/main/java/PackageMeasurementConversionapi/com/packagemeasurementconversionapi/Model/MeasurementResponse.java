package PackageMeasurementConversionapi.com.packagemeasurementconversionapi.Model;

import java.util.List;

/**
 * The MeasurementResponse class represents the response containing converted measurements.
 */
public class MeasurementResponse {
    private List<Integer> measurements;

    /**
     * Constructs a MeasurementResponse object with the specified measurements.
     * @param measurements The list of converted measurements.
     */
    public MeasurementResponse(List<Integer> measurements) {
        this.measurements = measurements;
    }

    /**
     * Retrieves the list of converted measurements.
     * @return The list of converted measurements.
     */
    public List<Integer> getMeasurements() {
        return measurements;
    }

    /**
     * Sets the list of converted measurements.
     * @param measurements The list of converted measurements to be set.
     */
    public void setMeasurements(List<Integer> measurements) {
        this.measurements = measurements;
    }
}



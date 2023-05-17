package PackageMeasurementConversionapi.com.packagemeasurementconversionapi.Model;

import java.util.List;


public class MeasurementResponse {
    private List<Integer> measurements;


    public MeasurementResponse(List<Integer> measurements) {
        this.measurements = measurements;
    }


    public List<Integer> getMeasurements() {
        return measurements;
    }


    public void setMeasurements(List<Integer> measurements) {
        this.measurements = measurements;
    }
}



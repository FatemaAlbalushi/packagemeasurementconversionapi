package PackageMeasurementConversionapi.com.packagemeasurementconversionapi.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeasurementService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeasurementService.class);


    public static List<Integer> convertMeasurements(String input) {
        try {
            // Validate input using the MeasurementValidator class
            MeasurementValidator.validateInput(input);
            // Initialize variables
            List<Integer> result = new ArrayList<>();
            int count = 0;
            int value = 0;
            boolean Zcombination = false;

            // Check if input is empty or equals to "_"
            if (input.isEmpty()) {
                return result;
            }
            if (input.equals("_")) {
                result.add(0);
                return result;
            }

            // Loop through each character in the input string
            for (int i = 0; i < input.length(); i++) {
                // If character is "z"
                if (input.charAt(i) == 'z') {
                    // Check if the next character is not "z"
                    if (i + 1 < input.length() && input.charAt(i + 1) != 'z') {
                        Zcombination = true;
                    }
                    count++;
                } else {
                    // If there is a z-combination
                    if (count > 0 && Zcombination) {
                        // If the next character is "_"
                        if (input.charAt(i) == '_') {
                            value = count * 26 + 0;
                            result.add(value);
                            i = i + 1;
                            count = 0;
                            Zcombination = false;
                        } else {
                            value = count * 26 + (input.charAt(i) - 'a' + 1);
                            result.add(value);
                            i = i + 1;
                            count = 0;
                            Zcombination = false;
                        }
                    } else if (count > 0) {
                        value = count * 26;
                        result.add(value);
                        count = 0;
                    }
                    // If the character is "_"
                    if (input.charAt(i) == '_') {
                        value = 0;
                        result.add(value);

                    }
                    // If the character is alphabetic
                    if (Character.isAlphabetic(input.charAt(i))) {
                        value = input.charAt(i) - 'a' + 1;
                        result.add(value);
                    }
                }
            }
            return result;
        } catch (IllegalArgumentException e) {

            throw e;
        } catch (Exception e) {

            throw new RuntimeException("Error occurred during measurement conversion.", e);
        }
    }


    public List<Integer> processMeasurements(List<Integer> measurements) {
        try {
            // Initialize variables
            List<Integer> result = new ArrayList<>();
            int i = 0;

            // Iterate through the measurements list
            while (i < measurements.size()) {
                int count = measurements.get(i);
                // If count is greater than 0, perform summing operation
                if (count > 0) {
                    int sum = 0;
                    int j = i + 1;

                    // Iterate through the following measurements and calculate the sum
                    while (j < measurements.size() && count > 0) {
                        sum += measurements.get(j);
                        count--;
                        j++;
                    }

                    result.add(sum);
                }
                i += (measurements.get(i) + 1);
            }

            return result;
        } catch (Exception e) {


            throw new RuntimeException("Error occurred during measurement processing.", e);
        }
    }
}


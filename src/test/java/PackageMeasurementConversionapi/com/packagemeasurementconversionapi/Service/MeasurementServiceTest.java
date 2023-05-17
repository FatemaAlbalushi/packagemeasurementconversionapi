package PackageMeasurementConversionapi.com.packagemeasurementconversionapi.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * The MeasurementServiceTest class is responsible for testing the functionalities of the MeasurementService class.
 * It contains test cases to verify the conversion and processing of measurements.
 */
class MeasurementServiceTest {
    private MeasurementService measurementService;

    /**
     * Initializes the MeasurementService object before each test case.
     */
    @BeforeEach
    public void setUp() {
        measurementService = new MeasurementService();
    }

    /**
     * Test case to verify the conversion and processing of measurements for the input "aa".
     * It asserts that the expected output matches the actual output.
     */
    @Test
    public void testConvertMeasurements_test1() {
        // Arrange
        String input = "aa";
        List<Integer> expected = List.of(1);

        // Act
        List<Integer> result = measurementService.convertMeasurements(input);
        List<Integer> output = measurementService.processMeasurements(result);

        // Assert
        assertEquals(expected, output);
    }

    /**
     * Test case to verify the conversion and processing of measurements for the input "abbcc".
     * It asserts that the expected output matches the actual output.
     */
    @Test
    public void testConvertMeasurements_test2() {
        // Arrange
        String input = "abbcc";
        List<Integer> expected = List.of(2,6);

        // Act
        List<Integer> result = measurementService.convertMeasurements(input);
        List<Integer> output = measurementService.processMeasurements(result);

        // Assert
        assertEquals(expected, output);
    }

    /**
     * Test case to verify the conversion and processing of measurements for the input "dz_a_aazzaaa".
     * It asserts that the expected output matches the actual output.
     */
    @Test
    public void testConvertMeasurements_test3() {
        // Arrange
        String input = "dz_a_aazzaaa";
        List<Integer> expected = List.of(28,53,1);

        // Act
        List<Integer> result = measurementService.convertMeasurements(input);
        List<Integer> output = measurementService.processMeasurements(result);

        // Assert
        assertEquals(expected, output);
    }

    /**
     * Test case to verify the conversion and processing of measurements for the input "a_".
     * It asserts that the expected output matches the actual output.
     */
    @Test
    public void testConvertMeasurements_test5() {
        // Arrange
        String input = "a_";
        List<Integer> expected = List.of(0);

        // Act
        List<Integer> result = measurementService.convertMeasurements(input);
        List<Integer> output = measurementService.processMeasurements(result);

        // Assert
        assertEquals(expected, output);
    }

    /**
     * Test case to verify the conversion and processing of measurements for the input "abcdabcdab".
     * It asserts that the expected output matches the actual output.
     */
    @Test
    public void testConvertMeasurements_test6() {
        // Arrange
        String input = "abcdabcdab";
        List<Integer> expected = List.of(2,7,7);

        // Act
        List<Integer> result = measurementService.convertMeasurements(input);
        List<Integer> output = measurementService.processMeasurements(result);

        // Assert
        assertEquals(expected, output);
    }

    /**
     * Test case to verify the conversion and processing of measurements for the input "zdaaaaaaaabaaaaaaaabaaaaaaaabbaa".
     * It asserts that the expected output matches the actual output.
     */
    @Test
    public void testConvertMeasurements_test8() {
        // Arrange
        String input = "zdaaaaaaaabaaaaaaaabaaaaaaaabbaa";
        List<Integer> expected = List.of(34);

        // Act
        List<Integer> result = measurementService.convertMeasurements(input);
        List<Integer> output = measurementService.processMeasurements(result);

        // Assert
        assertEquals(expected, output);
    }

    /**
     * Test case to verify the conversion and processing of measurements for the input "zza_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_".
     * It asserts that the expected output matches the actual output.
     */
    @Test
    public void testConvertMeasurements_test9() {
        // Arrange
        String input = "zza_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_";
        List<Integer> expected = List.of(26);

        // Act
        List<Integer> result = measurementService.convertMeasurements(input);
        List<Integer> output = measurementService.processMeasurements(result);

        // Assert
        assertEquals(expected, output);
    }

    /**
     * Test case to verify the conversion and processing of measurements for the input "za_a_a_a_a_a_a_a_a_a_a_a_a_azaaa".
     * It asserts that the expected output matches the actual output.
     */
    @Test
    public void testConvertMeasurements_test10() {
        // Arrange
        String input = "za_a_a_a_a_a_a_a_a_a_a_a_a_azaaa";
        List<Integer> expected = List.of(40,1);

        // Act
        List<Integer> result = measurementService.convertMeasurements(input);
        List<Integer> output = measurementService.processMeasurements(result);

        // Assert
        assertEquals(expected, output);
    }

}

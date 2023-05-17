package PackageMeasurementConversionapi.com.packagemeasurementconversionapi.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class MeasurementServiceTest {
    private MeasurementService measurementService;

    @BeforeEach
    public void setUp() {
        measurementService = new MeasurementService();
    }

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

import ReadOperations.ReadOperations;
import Exception.StateSensorAnalysisException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateSensorAnalyzerTest {
    ReadOperations readObj = new ReadOperations();
    String fileName = "StateCensusData";

    /***********************************************************************************************************
     *
     * Purpose : Given the States Census CSV file
     *           Check to ensure the Number of Record matches
     *
     **********************************************************************************************************/

    @Test
    public void givenStateCensusCSVFileCorrect_EnsureNumberOfRecordsMatch() throws StateSensorAnalysisException {
        String filePathRead = "D:\\New Batch\\BridgeLabz_Java_IndianState_Census_Analyzer\\IndianState_Census_Analyzer\\src\\main\\java\\ReadOperations\\StateCensusData.csv";
        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assert.assertEquals(29, count);
        } catch (StateSensorAnalysisException e) {
            e.printStackTrace();
        }
    }

    /***********************************************************************************************************
     *
     * Purpose : Given the State Census CSV File if incorrect
     *           Return a Custom Exception
     *
     **********************************************************************************************************/

    @Test
    public void givenStateCensusCSVFile_WhenFileNameIncorrectShouldThrowException()  {
        String filePathRead = "D:\\New Batch\\BridgeLabz_Java_IndianState_Census_Analyzer\\IndianState_Census_Analyzer\\src\\main\\java\\ReadOperations\\StateCnsusData";

        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assert.assertEquals(29, count);
        } catch (StateSensorAnalysisException e) {
            e.printStackTrace();
        }
    }

    /***********************************************************************************************************
     *
     * Purpose : Given the State Census CSV File when correct but type incorrect
     *           Return a Custom Exception
     *
     **********************************************************************************************************/

    @Test
    public void givenStateCensusCSVFile_WhenFileTypeIncorrectShouldThrowException()  {
        String filePathRead = "D:\\New Batch\\BridgeLabz_Java_IndianState_Census_Analyzer\\IndianState_Census_Analyzer\\src\\main\\java\\ReadOperations\\StateCensusData.pdf";

        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assert.assertEquals(29, count);
        }  catch (StateSensorAnalysisException e) {
            e.printStackTrace();
        }
    }

    /***********************************************************************************************************
     *
     * Purpose : Given the State Census CSV File when correct but delimiter incorrect
     *           Return a Custom Exception
     *
     **********************************************************************************************************/

    @Test
    public void givenStateCensusCSVFileCorrect_ButDelimiterIncorrectShouldThrowException() {
        String filePathRead = "D:\\New Batch\\BridgeLabz_Java_IndianState_Census_Analyzer\\IndianState_Census_Analyzer\\src\\main\\java\\ReadOperations\\StateCensusData.csv";
        String delimiter = ".";
        try {
            if(delimiter.equals(","))
                Assert.assertTrue(readObj.readDelimiter(filePathRead, delimiter));
            else
                Assert.assertFalse(readObj.readDelimiter(filePathRead, delimiter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***********************************************************************************************************
     *
     * Purpose : Given the State Census CSV File when correct but csv header incorrect
     *           Returns a Custom Exception
     *
     **********************************************************************************************************/

    @Test
    public void givenStateCensusCSVFileCorrect_ButHeaderIncorrectShouldThowException() {
        List<String> stringName = new ArrayList<>();
        String filePathRead = "D:\\New Batch\\BridgeLabz_Java_IndianState_Census_Analyzer\\IndianState_Census_Analyzer\\src\\main\\java\\ReadOperations\\StateCensusData.csv";
        stringName.add("State");
        stringName.add("Population");
        stringName.add("AreaInSqKm");
        stringName.add("Density");

        try {
            boolean flag = readObj.readHeader(filePathRead, stringName);
            if(flag == true)
                Assert.assertTrue(flag);
            else
                Assert.assertFalse(flag);
        } catch (IOException | StateSensorAnalysisException e) {
            e.printStackTrace();
        }
    }
}

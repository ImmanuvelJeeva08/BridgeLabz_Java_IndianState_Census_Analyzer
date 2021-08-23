/**
 * Ability for the analyser to load the Indian States Census Information from a .csv file
 * Create a StateCensusAnalyser Class to load the State Census CSV Data
 * Use Iterator to load the data
 * Check with StateCensusAnalyser to ensure number of record matches
 *
 * @author : Immanuvel Jeeva
 * @since  : 22.08.2021
 *
 */

package Controller;

import ReadOperations.ReadOperations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateCensusAnalyser {

    public static void main(String[] args) throws StateSensorAnalysisException, IOException {
        String filePathRead = "D:\\New Batch\\BridgeLabz_Java_IndianState_Census_Analyzer\\IndianState_Census_Analyzer\\src\\main\\java\\ReadOperations\\StateCensusData.csv";
        String fileName = "StateCensusData";
        String delimiter =",";
        List<String> stringName = new ArrayList<>();
        stringName.add("State");
        stringName.add("Population");
        stringName.add("AreaInSqKm");
        stringName.add("DensityPerSqKm");

        ReadOperations readObj = new ReadOperations();
        int count = readObj.readDataCount(filePathRead, fileName);
        System.out.println(count);

        readObj.readDelimiter(filePathRead, delimiter);
        readObj.readHeader(filePathRead, stringName);
    }
}

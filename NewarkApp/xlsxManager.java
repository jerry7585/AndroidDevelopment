package com.example.ese343finalproject.Newark;

import android.content.Context;
import android.util.Log;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class xlsxManager{
    private String CATEGORIZED_ASIAN_PERCENT_PATH = "/Users/alan/Senior-Design/externalFiles/categorizedAsianRace/?_asianPercent.xlsx";
    private String CATEGORIZED_AMERICAN_INDIAN_PATH = "/Users/alan/Senior-Design/externalFiles/categorizedAmericanIndianRace/?_americanIndianPercent.xlsx";
    private String CATEGORIZED_WHITE_PERCENT_PATH = "/Users/alan/Senior-Design/externalFiles/categorizedWhiteRace/?_whitePercent.xlsx";
    private String CATEGORIZED_BLACK_PERCENT_PATH = "/Users/alan/Senior-Design/externalFiles/categorizedBlackRace/?_blackPercent.xlsx";
    private String CATEGORIZED_ASIAN_FAIRNESS_PATH = "/Users/alan/Senior-Design/externalFiles/asianRaceFairness/?_asianFairness.xlsx";
    private String CATEGORIZED_AMERICAN_INDIAN_FAIRNESS_PATH = "/Users/alan/Senior-Design/externalFiles/americanIndianRaceFairness/?_americanIndianFairness.xlsx";
    private String CATEGORIZED_WHITE_FAIRNESS_PATH = "/Users/alan/Senior-Design/externalFiles/whiteRaceFairness/?_whiteFairness.xlsx";
    private String CATEGORIZED_BLACK_FAIRNESS_PATH = "/Users/alan/Senior-Design/externalFiles/blackRaceFairness/?_blackFairness.xlsx";
    private Map<String, List<xlsxIssueObj>> storeXlsx = new HashMap<String, List<xlsxIssueObj>>();
    private String xlsxCategorizedIssuesFilePathName = "/mnt/sdcard/Download/?_issues.xlsx";
    private String xlsxFairnessPathName = "/Users/alan/Senior-Design/externalFiles/categorizedFairness/?_fairness.xlsx";
    private final String CENSUS_INCOME_PATH = "/Users/alan/Senior-Design/externalFiles/census/census_income.xlsx";
    private final String CENSUS_RACE_PATH = "/Users/alan/Senior-Design/externalFiles/census/census_tract_race.xlsx";
    private final String ABANDONED_PROPERTY_PATH = "/mnt/sdcard/Download/abandonedpropertyissues.xlsx";
    private final String ANIMAL_COMPLAINTS_PATH = "/mnt/sdcard/Download/animalComplaint_issues.xlsx";
    private final String BUSINESS_COMPLAINTS_PATH = "/mnt/sdcard/Download/businessComplaints_issues.xlsx";

    public String getXlsxFairnessPathName(){ return xlsxFairnessPathName;}
    public String getCategorizedAsianFairnessPath() { return CATEGORIZED_ASIAN_FAIRNESS_PATH;}
    public String getCategorizedAmericanIndianFairnessPath(){ return CATEGORIZED_AMERICAN_INDIAN_FAIRNESS_PATH;}
    public String getCategorizedWhiteFairnessPath(){ return CATEGORIZED_WHITE_FAIRNESS_PATH;}
    public String getCategorizedBlackFairnessPath(){ return CATEGORIZED_BLACK_FAIRNESS_PATH;}
    public String getCategorizedAsianPercentPath(){ return CATEGORIZED_ASIAN_PERCENT_PATH;}
    public String getCategorizedAmericanIndianPath(){ return CATEGORIZED_AMERICAN_INDIAN_PATH;}
    public String getCategorizedWhitePercentPath() { return CATEGORIZED_WHITE_PERCENT_PATH;}
    public String getCategorizedBlackPercentPath() {return CATEGORIZED_BLACK_PERCENT_PATH;}
    public String getAnimalComplaintsPath() {
        return ANIMAL_COMPLAINTS_PATH;
    }

    public String getBusinessComplaints() {
        return BUSINESS_COMPLAINTS_PATH;
    }

    public String getDamagedSidewalkPath() {
        return DAMAGED_SIDEWALK_PATH;
    }

    public String getEnvironmentalComplaintPath() {
        return ENVIRONMENTAL_COMPLAINT_PATH;
    }

    public String getFireCodeViolationPath() {
        return FIRE_CODE_VIOLATION_PATH;
    }

    public String getGraffitiIssuePath() {
        return GRAFFITI_ISSUE_PATH;
    }

    public String getHeatIssuePath() {
        return HEAT_ISSUE_PATH;
    }

    public String getHomeInspectionPath() {
        return HOME_INSPECTION_PATH;
    }

    public String getIllegalActivityPath() {
        return ILLEGAL_ACTIVITY_PATH;
    }

    public String getIllegalConstructionPath() {
        return ILLEGAL_CONSTRUCTION_PATH;
    }

    public String getIllegalDumpingPath() {
        return ILLEGAL_DUMPING_PATH;
    }

    public String getLeadServicePath() {
        return LEAD_SERVICE_PATH;
    }

    public String getManholeIssuePath() {
        return MANHOLE_ISSUE_PATH;
    }

    public String getMissedPickupIssuePath() {
        return MISSED_PICKUP_ISSUE_PATH;
    }

    public String getNoiseIssuePath() {
        return NOISE_ISSUE_PATH;
    }

    public String getOpenHydrantIssuePath() {
        return OPEN_HYDRANT_ISSUE_PATH;
    }

    public String getOtherIssuePath() {
        return OTHER_ISSUE_PATH;
    }

    public String getParkingViolationPath() {
        return PARKING_VIOLATION_PATH;
    }

    public String getParkStructurePath() {
        return PARK_STRUCTURE_PATH;
    }

    public String getPotholeIssuesPath() {
        return POTHOLE_ISSUES_PATH;
    }

    public String getRodentInfestationPath() {
        return RODENT_INFESTATION_PATH;
    }

    public String getSewerIssuesPath() {
        return SEWER_ISSUES_PATH;
    }

    public String getStreetCleanupPath() {
        return STREET_CLEANUP_PATH;
    }

    public String getTrafficIssuePath() {
        return TRAFFIC_ISSUE_PATH;
    }

    public String getTreeRemovalIssuePath() {
        return TREE_REMOVAL_ISSUE_PATH;
    }

    public String getWaterIssuesPath() {
        return WATER_ISSUES;
    }

    private final String DAMAGED_SIDEWALK_PATH = "/mnt/sdcard/Download/damagedSidewalk_issues.xlsx";
    private final String ENVIRONMENTAL_COMPLAINT_PATH = "/mnt/sdcard/Download/environmentalComplaint_issues.xlsx";
    private final String FIRE_CODE_VIOLATION_PATH = "/mnt/sdcard/Download/fireCodeVio_issues.xlsx";
    private final String GRAFFITI_ISSUE_PATH = "/mnt/sdcard/Download/graffiti_issues.xlsx";
    private final String HEAT_ISSUE_PATH = "/mnt/sdcard/Download/heat_issues.xlsx";
    private final String HOME_INSPECTION_PATH = "/mnt/sdcard/Download/homeInspection_issues.xlsx";
    private final String ILLEGAL_ACTIVITY_PATH = "/mnt/sdcard/Download/illegalActivity_issues.xlsx";
    private final String ILLEGAL_CONSTRUCTION_PATH = "/mnt/sdcard/Download/illegalConstruction_issues.xlsx";
    private final String ILLEGAL_DUMPING_PATH = "/mnt/sdcard/Download/illegalDumping_issues.xlsx";
    private final String LEAD_SERVICE_PATH = "/mnt/sdcard/Download/leadService_issues.xlsx";
    private final String MANHOLE_ISSUE_PATH = "/mnt/sdcard/Download/manhole_issues.xlsx";
    private final String MISSED_PICKUP_ISSUE_PATH = "/mnt/sdcard/Download/missedPickup_issues.xlsx";
    private final String NOISE_ISSUE_PATH = "/mnt/sdcard/Download/noise_issues.xlsx";
    private final String OPEN_HYDRANT_ISSUE_PATH = "/mnt/sdcard/Download/openHydrant_issues.xlsx";
    private final String OTHER_ISSUE_PATH = "/mnt/sdcard/Download/other_issues.xlsx";
    private final String PARKING_VIOLATION_PATH = "/mnt/sdcard/Download/parkingVio_issues.xlsx";
    private final String PARK_STRUCTURE_PATH = "/mnt/sdcard/Download/parkStructure_issues.xlsx";
    private final String POTHOLE_ISSUES_PATH = "/mnt/sdcard/Download/pothole_issues.xlsx";
    private final String RODENT_INFESTATION_PATH = "/mnt/sdcard/Download/rodentInfestation_issues.xlsx";
    private final String SEWER_ISSUES_PATH = "/mnt/sdcard/Download/sewer_issues.xlsx";
    private final String STREET_CLEANUP_PATH = "/mnt/sdcard/Download/streetCleanUp_issues.xlsx";
    private final String TRAFFIC_ISSUE_PATH = "/mnt/sdcard/Download/traffic_issues.xlsx";
    private final String TREE_REMOVAL_ISSUE_PATH = "/mnt/sdcard/Download/treeRemoval_issues.xlsx";
    private final String WATER_ISSUES = "/mnt/sdcard/Download/water_issues.xlsx";


    //Other
    private List<xlsxIssueObj> otherIssues = new ArrayList<>();
    //Parking Violations (non-hazardous)
    private List<xlsxIssueObj> parkingViolationIssues = new ArrayList<>();
    //Water Issues
    private List<xlsxIssueObj> waterIssues = new ArrayList<>();
    //Animal Complaint
    private List<xlsxIssueObj> animalComplaintIssues = new ArrayList<>();
    //Sewer/ Catch Basin
    private List<xlsxIssueObj> sewerIssues = new ArrayList<>();
    //Pothole Complaint
    private List<xlsxIssueObj> potholeIssues = new ArrayList<>();
    //Missed Pick-Up Complaint (Recycling/ Garbage/ Bulk)
    private List<xlsxIssueObj> missedPickupIssues = new ArrayList<>();
    //Rodent Infestation (Exterior Only)
    private List<xlsxIssueObj> rodentIssues = new ArrayList<>();
    //Open Fire Hydrant Complaint
    private List<xlsxIssueObj> fireHydrantIssues = new ArrayList<>();
    //Lead Service Line Request
    private List<xlsxIssueObj> leadServiceIssues = new ArrayList<>();
    //Graffiti Removal Request
    private List<xlsxIssueObj> graffitiIssues = new ArrayList<>();
    //Tree Trim Removal Request
    private  List<xlsxIssueObj> treeIssues = new ArrayList<>();
    //Traffic: Signal, Signage, Light Pole and Striping Maintenance Issues
    private List<xlsxIssueObj> trafficIssues = new ArrayList<>();
    //Environmental Complaint (Garbage & Debris, Weeds/ Vegetation, etc.)
    private  List<xlsxIssueObj> environmentIssues = new ArrayList<>();
    //Illegal Dumping Complaint
    private List<xlsxIssueObj> illegalDumpingIssues = new ArrayList<>();
    //Manhole
    private List<xlsxIssueObj> manholeIssues = new ArrayList<>();
    //Home Inspection Request (INTERIOR ONLY- Mold, Damaged Ceilings, Rodent Infestation, etc.)
    private List<xlsxIssueObj> homeInspectionIssues = new ArrayList<>();
    //Street Clean-Up Request
    private List<xlsxIssueObj> streetCleanupIssues = new ArrayList<>();
    //Heat/ Hot Water
    private List<xlsxIssueObj> heatIssues = new ArrayList<>();
    //Abandoned Property
    private List<xlsxIssueObj> abandonedPropertyIssues = new ArrayList<>();
    //Illegal Construction
    private  List<xlsxIssueObj> illegalConstructionIssues = new ArrayList<>();
    //Illegal Activity
    private List<xlsxIssueObj> illegalActivityIssues = new ArrayList<>();
    //Damaged Sidewalk
    private List<xlsxIssueObj> damagedSidewalkIssues = new ArrayList<>();
    //Fire Code Violations
    private List<xlsxIssueObj> fireCodeIssues = new ArrayList<>();
    //Business Complaints
    private List<xlsxIssueObj> businessComplaintIssues = new ArrayList<>();
    //Parks- Structural Deficiencies (Broken Benches, Hole in Ground/ Sidewalk)
    private List<xlsxIssueObj> parkStructureIssues = new ArrayList<>();
    //Noise Disturbance
    private List<xlsxIssueObj> noiseDisturbanceIssues = new ArrayList<>();

    public List<xlsxIssueObj> getOtherIssues() {
        return otherIssues;
    }

    public List<xlsxIssueObj> getParkingViolationIssues() {
        return parkingViolationIssues;
    }

    public List<xlsxIssueObj> getWaterIssues() {
        return waterIssues;
    }

    public List<xlsxIssueObj> getAnimalComplaintIssues() {
        return animalComplaintIssues;
    }

    public List<xlsxIssueObj> getSewerIssues() {
        return sewerIssues;
    }

    public List<xlsxIssueObj> getPotholeIssues() {
        return potholeIssues;
    }

    public List<xlsxIssueObj> getMissedPickupIssues() {
        return missedPickupIssues;
    }

    public List<xlsxIssueObj> getRodentIssues() {
        return rodentIssues;
    }

    public List<xlsxIssueObj> getFireHydrantIssues() {
        return fireHydrantIssues;
    }

    public List<xlsxIssueObj> getLeadServiceIssues() {
        return leadServiceIssues;
    }

    public List<xlsxIssueObj> getGraffitiIssues() {
        return graffitiIssues;
    }

    public List<xlsxIssueObj> getTreeIssues() {
        return treeIssues;
    }

    public List<xlsxIssueObj> getTrafficIssues() {
        return trafficIssues;
    }

    public List<xlsxIssueObj> getEnvironmentIssues() {
        return environmentIssues;
    }

    public List<xlsxIssueObj> getIllegalDumpingIssues() {
        return illegalDumpingIssues;
    }

    public List<xlsxIssueObj> getManholeIssues() {
        return manholeIssues;
    }

    public List<xlsxIssueObj> getHomeInspectionIssues() {
        return homeInspectionIssues;
    }

    public List<xlsxIssueObj> getStreetCleanupIssues() {
        return streetCleanupIssues;
    }

    public List<xlsxIssueObj> getHeatIssues() {
        return heatIssues;
    }

    public List<xlsxIssueObj> getAbandonedPropertyIssues() {
        return abandonedPropertyIssues;
    }

    public List<xlsxIssueObj> getIllegalConstructionIssues() {
        return illegalConstructionIssues;
    }

    public List<xlsxIssueObj> getIllegalActivityIssues() {
        return illegalActivityIssues;
    }

    public List<xlsxIssueObj> getDamagedSidewalkIssues() {
        return damagedSidewalkIssues;
    }

    public List<xlsxIssueObj> getFireCodeIssues() {
        return fireCodeIssues;
    }

    public List<xlsxIssueObj> getBusinessComplaintIssues() {
        return businessComplaintIssues;
    }

    public List<xlsxIssueObj> getParkStructureIssues() {
        return parkStructureIssues;
    }

    public List<xlsxIssueObj> getNoiseDisturbanceIssues() {
        return noiseDisturbanceIssues;
    }

    public xlsxManager(){
    }

    public String getAbandonedPropertyPath(){
        return  ABANDONED_PROPERTY_PATH;
    }

    public Map<Double, Double> parseRaceXlsx(String raceString) throws IOException {
        Map<Double, Double> censusPopulationPercent = new HashMap<>();
        FileInputStream issueReader = new FileInputStream(CENSUS_RACE_PATH);
        XSSFWorkbook xlsxWorkbook = new XSSFWorkbook(issueReader);
        XSSFSheet issueSheet = xlsxWorkbook.getSheetAt(0);

        int raceIndex = 0;
        switch (raceString){
            case "Not Hispanic or Latino: - White alone": raceIndex = 5; break;
            case "Not Hispanic or Latino: - Black or African American alone": raceIndex = 6; break;
            case "Not Hispanic or Latino: - American Indian and Alaska Native alone": raceIndex = 7; break;
            case "Not Hispanic or Latino: - Asian alone": raceIndex = 8; break;
        }

        for (int i = 2; i < issueSheet.getPhysicalNumberOfRows(); i++) {
            String censusTract = issueSheet.getRow(i).getCell(2).getStringCellValue();
            String[] splitTractString = censusTract.split(" ");
            String tractWithComma = splitTractString[2];
            censusTract = tractWithComma.substring(0, tractWithComma.length() - 1);
            Double censusTractDouble = Double.parseDouble(censusTract);

            double totalPop = issueSheet.getRow(i).getCell(3).getNumericCellValue();
            double racePop = issueSheet.getRow(i).getCell(raceIndex).getNumericCellValue();
            double racePercent = racePop / totalPop;
            censusPopulationPercent.put(censusTractDouble, racePercent);
        }


        return censusPopulationPercent;
    }

    public Map<Double, Double> parseCensusIncomeXlsx() throws IOException {
        Map<Double, Double> censusIncome = new HashMap<>();
        FileInputStream issueReader = new FileInputStream(CENSUS_INCOME_PATH);
        XSSFWorkbook xlsxWorkbook = new XSSFWorkbook(issueReader);

        XSSFSheet issueSheet = xlsxWorkbook.getSheetAt(0);
        for (int j = 0; j < issueSheet.getPhysicalNumberOfRows(); j++) {
            String censusTract = issueSheet.getRow(j).getCell(1).getStringCellValue();
            double income = issueSheet.getRow(j).getCell(2).getNumericCellValue();

            String[] splitTractString = censusTract.split(" ");
            String tractWithComma = splitTractString[2];
            censusTract = tractWithComma.substring(0, tractWithComma.length() - 1);
            Double censusTractDouble = Double.parseDouble(censusTract);
            censusIncome.put(censusTractDouble, income);
        }
        return censusIncome;
    }


    public List<xlsxIssueObj> parseSpecificXlsx(String file) throws IOException {
        FileInputStream issueReader = new FileInputStream(file);
        XSSFWorkbook xlsxWorkbook = new XSSFWorkbook(issueReader);
        Log.d("Inside parsing", "Made it inside");
        List<xlsxIssueObj> objList = new ArrayList<>();
        String tractNum = "";
        XSSFSheet issueSheet = xlsxWorkbook.getSheetAt(0);
        for (int j = 1; j < issueSheet.getPhysicalNumberOfRows(); j++) {
            double latitude = 0, longitude = 0;
            double issueNumber = 0, rating = 0, agencyID = 0, requestTypeID = 0, slaHours = 0, agentID = 0, minutesAcknowledged = 0, minutesToClosed = 0;
            String status = "", summary = "", address = "", description = "", agencyName = "", exportedTags = "", requestType = "";
            String updatedAtLocal = "", createdAtLocal = "", acknowledgedAtLocal = "", reopenedAtLocal = "", closedAtLocal = "";
            String assigneeName = "", streetAddress = "", category = "", slaExpiresAtLocal = "", agentName = "", reportMethod = "";
            String reporterName = "", dueAtLocal = "", reportSoruce = "", reportMethodCode = "";
            boolean createdByMember = false;
            for (int i = 0; i < issueSheet.getRow(0).getPhysicalNumberOfCells(); i++) {
                switch (i) {
                    case 0:
                        issueNumber = issueSheet.getRow(j).getCell(i).getNumericCellValue();
                        break;
                    case 1:
                        status = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 2:
                        summary = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 3:
                        rating = issueSheet.getRow(j).getCell(i).getNumericCellValue();
                        break;
                    case 4:
                        address = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 5:
                        description = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 6:
                        agencyName = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 7:
                        agencyID = issueSheet.getRow(j).getCell(i).getNumericCellValue();
                        break;
                    case 8:
                        requestTypeID = issueSheet.getRow(j).getCell(i).getNumericCellValue();
                        break;
                    case 9:
                        latitude = issueSheet.getRow(j).getCell(i).getNumericCellValue();
                        break;
                    case 10:
                        longitude = issueSheet.getRow(j).getCell(i).getNumericCellValue();
                        break;
                    case 11:
                        exportedTags = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 12:
                        requestType = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 13:
                        updatedAtLocal = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 14:
                        createdAtLocal = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 15:
                        acknowledgedAtLocal = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 16:
                        reopenedAtLocal = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 17:
                        if (issueSheet.getRow(j).getCell(i) != null)
                            closedAtLocal = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 18:
                        if (issueSheet.getRow(j).getCell(i) != null)
                            minutesAcknowledged = issueSheet.getRow(j).getCell(i).getNumericCellValue();
                        break;
                    case 19:
                        if (issueSheet.getRow(j).getCell(i) != null)
                            minutesToClosed = issueSheet.getRow(j).getCell(i).getNumericCellValue();
                        break;
                    case 20:
                        if (issueSheet.getRow(j).getCell(i) != null)
                            assigneeName = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 21:
                        if (issueSheet.getRow(j).getCell(i).getCellTypeEnum() == CellType.STRING)
                            streetAddress = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        else {
                        }
                        break;
                    case 22:
                        category = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 23:
                        slaHours = issueSheet.getRow(j).getCell(i).getNumericCellValue();
                        break;
                    case 24:
                        slaExpiresAtLocal = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 25:
                        if (issueSheet.getRow(j).getCell(i) != null)
                            agentName = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 26:
                        if (issueSheet.getRow(j).getCell(i) != null)
                            agentID = issueSheet.getRow(j).getCell(i).getNumericCellValue();
                        break;
                    case 27:
                        reportMethodCode = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 28:
                        if (issueSheet.getRow(j).getCell(i) != null)
                            reportMethod = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 29:
                        reporterName = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 30:
                        if (issueSheet.getRow(j).getCell(i) != null)
                            dueAtLocal = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 31:
                        if (issueSheet.getRow(j).getCell(i) != null)
                            reportSoruce = issueSheet.getRow(j).getCell(i).getStringCellValue();
                        break;
                    case 32:
                        createdByMember = issueSheet.getRow(j).getCell(i).getBooleanCellValue();
                        break;
                    case 33:
                        tractNum = issueSheet.getRow(j).getCell(i).getStringCellValue();
                    default:
                        break;
                }
            }
            xlsxIssueObj obj = new xlsxIssueObj(issueNumber, status, summary, rating, address, description,
                    agencyName, agencyID, requestTypeID, latitude, longitude, exportedTags, requestType, updatedAtLocal, createdAtLocal,
                    acknowledgedAtLocal, reopenedAtLocal, closedAtLocal, minutesAcknowledged, minutesToClosed, assigneeName, streetAddress,
                    category, slaHours, slaExpiresAtLocal, agentName, agentID, reportMethodCode, reportMethod, reporterName, dueAtLocal,
                    reportSoruce, createdByMember, tractNum);
            objList.add(obj);
        }
        return objList;
    }

}

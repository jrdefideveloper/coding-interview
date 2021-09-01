import java.util.*;

public class LowestCommonManager {

    // O(n) time | O(d) space
    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager;
    }

    public static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
        int numImportantReports = 0;

        for (OrgChart report : manager.directReports) {
            OrgInfo orgInfo = getOrgInfo(report, reportOne, reportTwo);
            if (orgInfo.lowestCommonManager != null)
                return orgInfo;
            numImportantReports += orgInfo.numImportantReports; // *Percolate the important reports count
        }

        if (manager == reportOne || manager == reportTwo) {
            numImportantReports++;
        }
        OrgChart lowestCommonManager = (numImportantReports == 2) ? manager : null;

        return new OrgInfo(numImportantReports, lowestCommonManager);
    }

    static class OrgInfo {
        int numImportantReports;
        OrgChart lowestCommonManager;

        public OrgInfo(int numImportantReports, OrgChart lowestCommonManager) {
            this.numImportantReports = numImportantReports;
            this.lowestCommonManager = lowestCommonManager;
        }
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }

    public static void main(String[] args) {

    }

}

public class DeathCauseStatistics {
    private String ICDCode;
    private int[] deathCount;

    public DeathCauseStatistics(int[] deathCount, String ICDCode) {
        this.deathCount = deathCount;
        this.ICDCode = ICDCode;
    }

    public String getICDCode() {
        return ICDCode;
    }

    public static DeathCauseStatistics fromCsvLine(String line) {
        String[] splittedLine = line.split(",");
        String ICD = splittedLine[0].trim();
        int[] deaths = new int[20];
        for (int i = 0; i < 20; i++) {
            if (splittedLine[i + 2].equals("-")) {
                deaths[i] = 0;
            } else {
                deaths[i] = Integer.parseInt(splittedLine[i + 2]);
            }
        }
        return new DeathCauseStatistics(deaths, ICD);
    }
}
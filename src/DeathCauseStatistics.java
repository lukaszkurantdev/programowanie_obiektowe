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

    public class AgeBracketDeaths {
        public final int young, old, deathCount;

        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }
    }

    public AgeBracketDeaths bracketDeaths(int age) {
        int young = age/5 * 5;
        int old;
        if(young >= 95) {
            old = Integer.MAX_VALUE;
        } else {
            old = age + 4;
        }
        int deathCount = this.deathCount[age/5];
        return new AgeBracketDeaths(young, old, deathCount);
    }
}
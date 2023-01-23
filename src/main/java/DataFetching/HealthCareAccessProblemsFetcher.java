package DataFetching;


public class HealthCareAccessProblemsFetcher extends AbstractFetcherFactory {
    public HealthCareAccessProblemsFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorID = "SH.ACS.MONY.Q1.ZS";
    }
    public String getLabel(){return "HealthcareAccessProblems";}
}
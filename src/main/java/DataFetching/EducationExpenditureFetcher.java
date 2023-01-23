package DataFetching;


public class EducationExpenditureFetcher extends AbstractFetcherFactory {
    public EducationExpenditureFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorID = "SE.XPD.TOTL.GB.ZS";
    }
    public String getLabel(){return "EducationExpenditure";}
}
package DataFetching;


public class HealthExpenditureFetcher extends AbstractFetcherFactory {
    public HealthExpenditureFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorID = "SH.XPD.CHEX.GD.ZS";
    }
    public String getLabel(){return "HealthExpenditure";}
}
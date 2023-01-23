package DataFetching;


public class MortalityRateFetcher extends AbstractFetcherFactory {
    public MortalityRateFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorID = "SH.STA.MMRT";
    }
    public String getLabel(){return "MortalityRate";}
}
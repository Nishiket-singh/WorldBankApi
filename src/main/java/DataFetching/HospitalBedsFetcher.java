package DataFetching;


public class HospitalBedsFetcher extends AbstractFetcherFactory {
    public HospitalBedsFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorID = "SH.MED.BEDS.ZS";
    }
    public String getLabel(){return "HospitalBeds";}
}
package DataFetching;


public class AirPollutionFetcher extends AbstractFetcherFactory{
    public AirPollutionFetcher(String sYear, String eYear, String country){
        super(sYear, eYear, country);
        this.indicatorID = "EN.ATM.PM25.MC.M3";
    }

    public String getLabel(){return "AirPollution";}


}
package DataFetching;


public class GdpFetcher extends AbstractFetcherFactory {
    public GdpFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorID = "NY.GDP.PCAP.CD";
    }
    public String getLabel(){return "GDP";}
}
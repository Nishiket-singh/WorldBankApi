package DataFetching;

public class PopulationFetcher extends AbstractFetcherFactory{
    public PopulationFetcher(String sYear, String eYear, String country){
        super(sYear, eYear, country);
        this.indicatorID = "SP.POP.TOTL";
    }
    public String getLabel(){return "Population";}
}


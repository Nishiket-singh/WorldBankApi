package DataFetching;

public class APICall implements APICallProxy{
    final private String country;
    final private String indicatorID;
    final private String yearFrom;
    final private String yearTo;

    public APICall(String country, String indicatorID
            , String yearFrom, String yearTo){
        this.country = country;
        this.indicatorID = indicatorID;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
    }

    public String getCountry() {
        return country;
    }

    public String getIndicatorID() {
        return indicatorID;
    }

    public String getYearFrom() {
        return yearFrom;
    }

    public String getYearTo() {
        return yearTo;
    }

}

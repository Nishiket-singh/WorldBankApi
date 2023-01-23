package Analysis;

import DataFetching.GetData;

public abstract class AbstractAnalysisFactory {
    protected String startYear;
    protected String endYear;
    protected String country;

    AbstractAnalysisFactory(String startYear, String endYear, String country){
        this.country = country;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public abstract AnalysisResult recalculate() throws GetData.ThrowException;
    public AnalysisResult recalculate(String startYear, String endYear, String country) throws GetData.ThrowException {
        setCountry(country); setStartYear(startYear); setEndYear(endYear);
        return this.recalculate();
    }
}

package Analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import DataFetching.*;

public class EducationExpenditureVsHealthExpenditure extends AbstractAnalysisFactory{

    public EducationExpenditureVsHealthExpenditure(String startYear, String endYear, String country) {
        super(startYear, endYear, country);
    }

    public AnalysisResult recalculate() throws GetData.ThrowException {
        String[] labels = new String[2];
        AbstractFetcherFactory fetcher = new EducationExpenditureFetcher(this.startYear, this.endYear, this.country);
        Map<String, Double> educationExpenditureData = fetcher.getData();
        labels[0] = fetcher.getLabel();

        fetcher = new HealthExpenditureFetcher(this.startYear, this.endYear, this.country);
        Map<String, Double> healthExpenditureData = fetcher.getData();
        labels[1] = fetcher.getLabel();

        return new AnalysisResult(new ArrayList<>(Arrays.asList(
                educationExpenditureData,
                healthExpenditureData
        )), labels);
    }
}

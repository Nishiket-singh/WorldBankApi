package Analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import DataFetching.AbstractFetcherFactory;
import DataFetching.ForestAreaFetcher;
import DataFetching.GetData;

public class AverageForestArea extends AbstractAnalysisFactory{

    public AverageForestArea(String startYear, String endYear, String country) {
        super(startYear, endYear, country);
    }

    public AnalysisResult recalculate() throws GetData.ThrowException {
        String[] labels = new String[1];
        AbstractFetcherFactory fetcher = new ForestAreaFetcher(this.startYear, this.endYear, this.country);
        Map<String, Double> forestAreaData = fetcher.getData();
        labels[0] = fetcher.getLabel();

        return new AnalysisResult(new ArrayList<>(Arrays.asList(
                forestAreaData
        )), labels);
    }
}

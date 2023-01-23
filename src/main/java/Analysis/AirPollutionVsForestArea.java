package Analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import DataFetching.AbstractFetcherFactory;
import DataFetching.AirPollutionFetcher;
import DataFetching.ForestAreaFetcher;
import DataFetching.GetData;

public class AirPollutionVsForestArea extends AbstractAnalysisFactory{

    public AirPollutionVsForestArea(String startYear, String endYear, String country) {
        super(startYear, endYear, country);
    }

    public AnalysisResult recalculate() throws GetData.ThrowException {
        String[] labels = new String[2];
        AbstractFetcherFactory fetcher = new AirPollutionFetcher(this.startYear, this.endYear, this.country);
        Map<String, Double> airPollutionData = fetcher.getData();
        labels[0] = fetcher.getLabel();


        fetcher = new ForestAreaFetcher(this.startYear, this.endYear, this.country);
        Map<String, Double> forestAreaData = fetcher.getData();
        labels[1] = fetcher.getLabel();

        return new AnalysisResult(new ArrayList<>(Arrays.asList(
                airPollutionData,
                forestAreaData
        )), labels);
    }
}

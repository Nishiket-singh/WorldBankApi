package Analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import DataFetching.*;

public class PublicSectorEmploymentShareMaleVsFemale extends AbstractAnalysisFactory {
    public PublicSectorEmploymentShareMaleVsFemale(String startYear, String endYear, String country) {
        super(startYear, endYear, country);
    }

    @Override
    public AnalysisResult recalculate() throws GetData.ThrowException {
        String[] labels = new String[2];
        AbstractFetcherFactory fetcherMale = new PublicSectorEmploymentShareMale(this.startYear, this.endYear, this.country);
        Map<String, Double> maleData = fetcherMale.getData();
        labels[0] = fetcherMale.getLabel();

        AbstractFetcherFactory fetcherFemale = new PublicSectorEmploymentShareFemale(this.startYear, this.endYear, this.country);
        Map<String, Double> femaleData = fetcherFemale.getData();
        labels[1] = fetcherFemale.getLabel();

        return new AnalysisResult(new ArrayList<>(Arrays.asList(
                maleData,
                femaleData
        )), labels);
    }
}

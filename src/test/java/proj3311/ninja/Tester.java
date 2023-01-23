package proj3311.ninja;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import java.util.HashMap;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import DataFetching.*;
import Analysis.*;
import DataFetching.GetData.ThrowException;
import LoginModule.LoginBackend;



/**
 * Unit test for simple App.
 */
public class Tester 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
	@Test
	public void Logintest1() {
		String name = "John";
		String password = "1234jayz";
		HashMap<String,String> login = new HashMap<String,String>();
		login.put(name, password);
		LoginBackend loginbackend = new LoginBackend();
		loginbackend.load();
		assertNotEquals(loginbackend.getLoginInfo(),login);
		
		
	}
	
	@Test
	public void LoginTest2() {
		LoginBackend loginbackend = new LoginBackend();
		loginbackend.load();
		assertEquals(loginbackend.getLoginInfo().get("john"),"1234");
		assertEquals(loginbackend.getLoginInfo().get("John"),null);
		
	}

	@Test
	public void LoginTest3() {
		String name = "john";
		String password = "1234";
		String name2 = "wayne";
		String pass2 = "5678";
		String name3 = "gacy";
		String pass3 = "9012";
		HashMap<String,String> login = new HashMap<String,String>();
		login.put(name, password);
		login.put(name3, pass3);
		login.put(name2, pass2);
		LoginBackend loginbackend = new LoginBackend();
		loginbackend.load();
		assertEquals(loginbackend.getLoginInfo(),login);
	}
	
	@Test
	public void LoginTest4() {
		String name = "johnathan";
		String password = "1234";
		String name2 = "wayne";
		String pass2 = "5678";
		String name3 = "gacy";
		String pass3 = "9012";
		HashMap<String,String> login = new HashMap<String,String>();
		login.put(name, password);
		login.put(name3, pass3);
		login.put(name2, pass2);
		LoginBackend loginbackend = new LoginBackend();
		loginbackend.load();
		assertNotEquals(loginbackend.getLoginInfo(),login);
	}
	
	@Test
	public void LoginTest5() {
		LoginBackend loginbackend = new LoginBackend();
		loginbackend.load();
		HashMap<String,String> login = loginbackend.getLoginInfo();
		assertTrue(login.containsKey("john"));
		assertFalse(login.containsKey("John"));
		assertFalse(login.containsKey("Username"));
	}
	
	@Test
	public void LoginTest6() {
		
	}
	
	
	@Test
	public void DataFetchTest1() throws ThrowException {
		String startYear = "2000";
        String endYear = "2002";
        String country = "usa";
		 AirPollutionFetcher airPollution = new AirPollutionFetcher(startYear, endYear, country);
	        HashMap<String, Double> map = new HashMap<String, Double>(airPollution.getData());
	        assertEquals(map.get(startYear), 9.52513800350703, 0.00001);
	        assertNull(map.get(endYear));
	}
	
	@Test
	public void DataFetchTest2() throws ThrowException{
		String startYear = "2000";
        String endYear = "2002";
        String country = "usa";
        Co2Fetcher co2 = new Co2Fetcher(startYear, endYear, country);
        HashMap<String, Double> map = new HashMap<String, Double>(co2.getData());
        assertEquals(map.get(startYear), 20.4698066603918, 0.0001);
        assertEquals(map.get(endYear), 19.4455490036168, 0.00001);
	}
	@Test
	public void DataFetchTest3() throws ThrowException{
		String startYear = "2003";
        String endYear = "2005";
        String country = "prt";
        EducationExpenditureFetcher educationExpindenture = new EducationExpenditureFetcher(startYear, endYear, country);
        HashMap<String, Double> map = new HashMap<String, Double>(educationExpindenture.getData());
        assertEquals(map.get(startYear), 11.650520324707, 0.00001);
        assertEquals(map.get(endYear), 10.8545999526978, 0.00001);
	}

	@Test
	public void DataFetchTest4() throws ThrowException{
		String startYear = "2000";
        String endYear = "2005";
        String country = "can";
		EnergyUseFetcher energyUse = new EnergyUseFetcher(startYear, endYear, country);
        HashMap<String, Double> map = new HashMap<String, Double>(energyUse.getData());
        assertEquals(map.get(startYear), 8265.07992477285, 0.0001);
        assertEquals(map.get(endYear), 8422.03430847519, 0.0001);
	}
	
	@Test
	public void DataFetchTest5() throws ThrowException{
		String startYear = "2004";
        String endYear = "2005";
        String country = "ind";
        ForestAreaFetcher forestArea = new ForestAreaFetcher(startYear, endYear, country);
        HashMap<String, Double> map = new HashMap<String, Double>(forestArea.getData());
        assertEquals(map.get(startYear), 22.9897853820307, 0.0001);
        assertEquals(map.get(endYear), 23.0538579774586, 0.0001);
	}
	
	@Test
	public void DataFetch6() throws ThrowException{
		String startYear = "2000";
        String endYear = "2001";
        String country = "chn";
        GdpFetcher gdp = new GdpFetcher(startYear, endYear, country);
        HashMap<String, Double> map = new HashMap<String, Double>(gdp.getData());
        assertEquals(map.get(startYear), 959.372483635864, 0.0001);
        assertEquals(map.get(endYear), 1053.10824300262, 0.00001);
	}
	
	@Test
	public void DataFetch7() throws ThrowException{
		String startYear = "2005";
        String endYear = "2006";
        String country = "jpn";
        HealthExpenditureFetcher healthExpenditure = new HealthExpenditureFetcher(startYear, endYear, country);
        HashMap<String, Double> map = new HashMap<String, Double>(healthExpenditure.getData());
        assertEquals(map.get(startYear), 7.65818596, 0.00001);
        assertEquals(map.get(endYear), 7.68688822, 0.00001);
	}
	
	@Test
	public void DataFetch8() throws ThrowException{
		String startYear = "2000";
        String endYear = "2001";
        String country = "ita";
        HospitalBedsFetcher hospitalBeds = new HospitalBedsFetcher(startYear, endYear, country);
        HashMap<String, Double> map = new HashMap<String, Double>(hospitalBeds.getData());
        assertEquals(map.get(startYear), 4.71, 0.001);
        assertEquals(map.get(endYear), 4.61, 0.00001);
	}
	@Test
	public void DataFetch9() throws ThrowException{
		String startYear = "2005";
        String endYear = "2006";
        String country = "arg";
        MortalityRateFetcher mortalityRate = new MortalityRateFetcher(startYear, endYear, country);
        HashMap<String, Double> map = new HashMap<String, Double>(mortalityRate.getData());
        assertEquals(map.get(startYear), 59.0, 0.00001);
        assertEquals(map.get(endYear), 57.0, 0.00001);
	}
	@Test
	public void DataFetch10() throws ThrowException{
		String startYear = "2000";
        String endYear = "2001";
        String country = "can";
        PopulationFetcher population = new PopulationFetcher(startYear, endYear, country);
        HashMap<String, Double> map = new HashMap<String, Double>(population.getData());
        assertEquals(map.get(startYear), 30685730, 0.00001);
        assertEquals(map.get(endYear), 31020902, 0.0001);
	}
	
	@Test
	public void DataFetch11() throws ThrowException{
		String startYear = "2000";
        String endYear = "2001";
        String country = "mex";
        HealthCareAccessProblemsFetcher healthCareAccessProblems = new HealthCareAccessProblemsFetcher(startYear, endYear, country);
        HashMap<String, Double> map = new HashMap<String, Double>(healthCareAccessProblems.getData());
        assertNull(map.get(startYear));
        assertNull(map.get(endYear));
	}
	
    @Test
    public void AnalysisTest1()throws ThrowException {
    	String startYear = "2003";
        String endYear = "2004";
        String country = "usa";
        AverageExpenditureOnEducation averageEduction = new AverageExpenditureOnEducation(startYear, endYear, country);
        AnalysisResult result = averageEduction.recalculate(startYear, endYear, country);
        HashMap<String, Double> year1 = new HashMap<String, Double>(result.getValues(Integer.parseInt(startYear)));
        HashMap<String, Double> year2 = new HashMap<String, Double>(result.getValues(Integer.parseInt(endYear)));
        assertEquals(result.getLabels().length, 1);
        assertEquals(result.getLabels()[0], "EducationExpenditure");
        assertNull(year1.get(result.getLabels()[0]));
        assertNull(year2.get(result.getLabels()[0]));
    }

    @Test
    public void AnalysisTest2() throws ThrowException {
    	String startYear = "2006";
        String endYear = "2007";
        String country = "ind";
        AirPollutionVsForestArea airVSForest = new AirPollutionVsForestArea(startYear, endYear, country);
        AnalysisResult result = airVSForest.recalculate(startYear, endYear, country);
        HashMap<String, Double> year1 = new HashMap<String, Double>(result.getValues(Integer.parseInt(startYear)));
        HashMap<String, Double> year2 = new HashMap<String, Double>(result.getValues(Integer.parseInt(endYear)));
        assertEquals(result.getLabels().length, 2);
        assertEquals(result.getLabels()[0], "AirPollution");
        assertEquals(result.getLabels()[1], "ForestArea");
        assertNull(year1.get(result.getLabels()[0]));
        assertEquals(year1.get(result.getLabels()[1]), 23.1179305728864, 0.00001);
        assertNull(year2.get(result.getLabels()[0]));
        assertEquals(year2.get(result.getLabels()[1]), 23.1820031683142, 0.0001);
    }
    @Test
    public void AnalysisTest3() throws ThrowException {
    	String startYear = "2000";
        String endYear = "2001";
        String country = "usa";
        Co2VsEnergyUseVsAirPollution co2VSEnergyVsAir = new Co2VsEnergyUseVsAirPollution(startYear, endYear, country);
        AnalysisResult result = co2VSEnergyVsAir.recalculate(startYear, endYear, country);
        HashMap<String, Double> year1 = new HashMap<String, Double>(result.getValues(Integer.parseInt(startYear)));
        HashMap<String, Double> year2 = new HashMap<String, Double>(result.getValues(Integer.parseInt(endYear)));
        assertEquals(result.getLabels().length, 3);
        assertEquals(result.getLabels()[0], "CO2");
        assertEquals(result.getLabels()[1], "EnergyUse");
        assertEquals(result.getLabels()[2], "AirPollution");
        assertEquals(year1.get(result.getLabels()[0]), 20.4698066603918, 0.00001);
        assertEquals(year1.get(result.getLabels()[1]), 8056.86384994775, 0.00001);
        assertEquals(year1.get(result.getLabels()[2]), 9.52513800350703, 0.00001);
        assertEquals(year2.get(result.getLabels()[0]), 20.1715306146243, 0.00001);
        assertEquals(year2.get(result.getLabels()[1]), 7827.88632537183, 0.00001);
        assertNull(year2.get(result.getLabels()[2]));
    }

    @Test
    public  void AnalysisTest4() throws ThrowException {
    	String startYear = "2000";
        String endYear = "2001";
        String country = "chn";
        AverageForestArea afa = new AverageForestArea(startYear, endYear, country);
        AnalysisResult result = afa.recalculate(startYear, endYear, country);
        HashMap<String, Double> year1 = new HashMap<String, Double>(result.getValues(Integer.parseInt(startYear)));
        HashMap<String, Double> year2 = new HashMap<String, Double>(result.getValues(Integer.parseInt(endYear)));
        assertEquals(result.getLabels().length, 1);
        assertEquals("ForestArea", result.getLabels()[0]);
        assertEquals(year1.get(result.getLabels()[0]), 18.7804969919467, 0.00001);
        assertEquals(year2.get(result.getLabels()[0]), 19.031006736957, 0.00001);
    }

    @Test
    public void AnalysisTest5() throws ThrowException {
    	PublicSectorEmploymentShareMaleVsFemale publicSectorEmploymentShare = new PublicSectorEmploymentShareMaleVsFemale("2000", "2000", "MEX");
        AnalysisResult result = publicSectorEmploymentShare.recalculate("2000", "2000", "MEX");
        HashMap<String, Double> year1 = new HashMap<String, Double>(result.getValues(Integer.parseInt("2000")));
        assertEquals(result.getLabels().length, 2);
        assertEquals("Public Sector Employment Share Of Total Employment In Males", result.getLabels()[0]);
        assertEquals("Public Sector Employment Share Of Total Employment In Females", result.getLabels()[1]);
        assertEquals(0.0936650335788727, year1.get(result.getLabels()[0]), 0.00001);
        assertEquals(0.145692750811577, year1.get(result.getLabels()[1]), 0.00001);
    }

    @Test
    public void AnalysisTest6() throws ThrowException {
    	String startYear = "2007";
        String endYear = "2008";
        String country = "ind";
        EducationExpenditureVsHealthExpenditure educationExpenditureVsHealthExpenditure = new EducationExpenditureVsHealthExpenditure(startYear, endYear, country);
        AnalysisResult result = educationExpenditureVsHealthExpenditure.recalculate(startYear, endYear, country);
        HashMap<String, Double> year1 = new HashMap<String, Double>(result.getValues(Integer.parseInt(startYear)));
        HashMap<String, Double> year2 = new HashMap<String, Double>(result.getValues(Integer.parseInt(endYear)));
        assertEquals(result.getLabels().length, 2);
        assertEquals("EducationExpenditure", result.getLabels()[0]);
        assertEquals("HealthExpenditure", result.getLabels()[1]);
        assertNull(year1.get(result.getLabels()[0]));
        assertEquals(year1.get(result.getLabels()[1]),3.51754165, 0.0001);
        assertNull(year2.get(result.getLabels()[0]));
        assertEquals(year2.get(result.getLabels()[1]),3.51468062, 0.00001);
    }
   
    }

	
	
	
	



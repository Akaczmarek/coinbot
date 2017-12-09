package fr.afjg.coinbot.entity.datatprocessing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CurrencyNotes {
	
	private CurrencyTrend currencyTrend;
	private volatile List<CurrencyNote> currencyNotes;
	
	
	public CurrencyNotes(CurrencyTrend currencyTrend) {
		this.setCurrencyTrend(currencyTrend);
		listOfOperations();
		
	}

	// getters & setters---------------------------------------------------------------
	
	public CurrencyTrend getCurrencyTrend() {
		return currencyTrend;
	}

	public void setCurrencyTrend(CurrencyTrend currencyTrend) {
		this.currencyTrend = currencyTrend;
	}

	public List<CurrencyNote> getCurrencyNotes() {
		return currencyNotes;
	}

	public void setCurrencyNotes(List<CurrencyNote> currencyNotes) {
		this.currencyNotes = currencyNotes;
	}
	
	//methods------------------------------------------------------------
	
	public void listOfOperations() {
		
		// stage 1 :recovery the list of calculation
		List<TrendCalculation> tcs=new ArrayList<>(this.getCurrencyTrend().getTrendCalculs());
		
		Iterator<TrendCalculation> ite = tcs.iterator();
		
		while (ite.hasNext()) {
			TrendCalculation tc = ite.next();
			
			
			//preparation and recovery informations behind calculation note
			
			//stage 3 : treatment line Equation
			
			//stage 3.1 : recovery the list of equation
			List<LineEquationTrend> lets = tc.getLinesEquationsTrends();
			
			Iterator<LineEquationTrend> iteLETS= lets.iterator();
			
			//stage 3.2 :data storage specific to bid or ask into two list line equation
			List<LineEquationTrend> letsBid = new ArrayList<>();
			List<LineEquationTrend> letsAsk = new ArrayList<>();
			
			
			
			
			while (iteLETS.hasNext()) {
				LineEquationTrend let = iteLETS.next();
				
				// note for type of trend (bid => value to sell or ask=> value to buy)
				if("bid".equals(let.getTypeBidOrAsk())) {
					letsBid.add(let);
					
				}else if ("ask".equals(let.getTypeBidOrAsk())) {
					letsAsk.add(let);
				}
				
			}
			
			//stage 4 : treatment last trend
			
			//stage 3.1 : recovery the list of last trend
			List<LastTrend> lts = tc.getLastTrends();
			
			Iterator<LastTrend> iteLTS= lts.iterator();
			
			// Stage  4.2 :data storage specific to bid or ask into two list last Trend
			List<LastTrend> ltsBid = new ArrayList<>();
			List<LastTrend> ltsAsk = new ArrayList<>();
			
			
			while (iteLTS.hasNext()) {
				LastTrend lt = iteLTS.next();
				
				// note for type of trend (bid => value to sell or ask=> value to buy)
				if("bid".equals(lt.getTypeBidOrAsk())) {
					ltsBid.add(lt);
					
				}else if ("ask".equals(lt.getTypeBidOrAsk())) {
					ltsAsk.add(lt);
				}
				
			}
			
			//stage 5 : treatment last point
			
			
			
			
		}
		
	}


	

}

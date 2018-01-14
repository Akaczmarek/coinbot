package fr.afgj.coinbot.calculation.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.entity.CurrencyTrend;
import fr.afgj.coinbot.rule.impl.TrendRule;
import fr.afgj.coinbot.rule.impl.TrendRulesBot;

/*
 * class used as a data update object the "currency trend" class;
 * it updates the lists and distributes them to update the calculations.
 */
public class OperationsOnCurrencyTrend implements Runnable {

	private Logger log = Logger.getLogger(this.getClass());

	private List<CurrencyRate> comparisonCurrencyRates; // list containing the elements added between the old list and
														// the new list to update
	private List<CurrencyRate> newCurrencyRates;
	private List<CurrencyRate> oldCurrencyRates;
	private List<TrendPointXY> pointsXYOfBid;
	private List<TrendPointXY> pointsXYOfAsk;
	private List<TrendNoteToBuy> TrendNotesToBuy;
	private List<TrendNoteToSell> TrendNotesToSell;
	private TrendRule trendRule;
	private CurrencyTrend currencyTrend;

	{
		pointsXYOfBid = new ArrayList<>();
		pointsXYOfAsk = new ArrayList<>();
		TrendNotesToBuy = new ArrayList<>();
		TrendNotesToSell = new ArrayList<>();
	}

	public OperationsOnCurrencyTrend(CurrencyTrend currencyTrend) {
		super();
		this.currencyTrend = currencyTrend;
	}

	public List<CurrencyRate> getComparisonCurrencyRates() {
		return comparisonCurrencyRates;
	}

	public void setComparisonCurrencyRates(List<CurrencyRate> comparisonCurrencyRates) {
		this.comparisonCurrencyRates = comparisonCurrencyRates;
	}

	public List<CurrencyRate> getNewCurrencyRates() {
		return newCurrencyRates;
	}

	public void setNewCurrencyRates(List<CurrencyRate> newCurrencyRates) {
		this.newCurrencyRates = newCurrencyRates;
	}

	public List<CurrencyRate> getOldCurrencyRates() {
		return oldCurrencyRates;
	}

	public void setOldCurrencyRates(List<CurrencyRate> oldCurrencyRates) {
		this.oldCurrencyRates = oldCurrencyRates;
	}

	public CurrencyTrend getCurrencyTrend() {
		return currencyTrend;
	}

	public void setCurrencyTrend(CurrencyTrend currencyTrend) {
		this.currencyTrend = currencyTrend;
	}

	public TrendRule getTrendRule() {
		return trendRule;
	}

	public void setTrendRule(TrendRule trendRule) {
		this.trendRule = trendRule;
	}

	public List<TrendNoteToBuy> getTrendNotesToBuy() {
		return TrendNotesToBuy;
	}

	public void setTrendNotesToBuy(List<TrendNoteToBuy> trendNotesToBuy) {
		TrendNotesToBuy = trendNotesToBuy;
	}

	public List<TrendNoteToSell> getTrendNotesToSell() {
		return TrendNotesToSell;
	}

	public void setTrendNotesToSell(List<TrendNoteToSell> trendNotesToSell) {
		TrendNotesToSell = trendNotesToSell;
	}

	public List<TrendPointXY> getPointsXYOfBid() {
		return pointsXYOfBid;
	}

	public void setPointsXYOfBid(List<TrendPointXY> pointsXYOfBid) {
		this.pointsXYOfBid = pointsXYOfBid;
	}

	public List<TrendPointXY> getPointsXYOfAsk() {
		return pointsXYOfAsk;
	}

	public void setPointsXYOfAsk(List<TrendPointXY> pointsXYOfAsk) {
		this.pointsXYOfAsk = pointsXYOfAsk;
	}

	@Override
	public void run() {

		// Stage 0 : update lists
		// Stage 0.1 : comparison between new and old list
		this.comparisonCurrencyRatesList();

		// Stage 0.2 : update points list
		this.updatePointsXY();

		// stage 1 : check if the calculation is possible and transmit list of points to Trend Note
		
		this.checkAndTransmitForCalculation();
		
		// Stage 2 : wait result Note
		
		boolean checkFinish = this.waitResultNote();
		
		// stage 3 : sum calculation  of notes

		//********************************************************************************
		//definition note to buy or to sell : 
		//********************************************************************************
		if (checkFinish) {
			
			this.treatmentCompilationNotationtoBuy();
			this.treatmentCompilationNotationtoSell();
		
		}else {
			System.out.println("erreur OOCT : avant de faire calcul des notes ; opérations pas terminées, le calcul est abandonné");
		}
	}

	private void treatmentCompilationNotationtoSell() {
		double note = 0.0;
		CurrencyTrend ct = this.currencyTrend;
		
		if (this.getTrendNotesToSell()!= null) {
			Iterator<TrendNoteToSell> ite = this.getTrendNotesToSell().iterator();
			
			while(ite.hasNext()) {
				TrendNoteToSell tntb = ite.next();

				note =  note + tntb.getNote();
			}
			
			// save result in currency trend
			ct.setNotetosell(note);

		}
	}

	private void treatmentCompilationNotationtoBuy() {

		double note = 0.0;
		CurrencyTrend ct = this.currencyTrend;
		
		if (this.getTrendNotesToBuy()!= null) {
			Iterator<TrendNoteToBuy> ite = this.getTrendNotesToBuy().iterator();
			
			while(ite.hasNext()) {
				TrendNoteToBuy tntb = ite.next();

				note =  note + tntb.getNote();
			}
			
			// save result in currency trend
			ct.setNotetobuy(note);
			
		}
	}

	private void checkAndTransmitForCalculation() {
		// TODO Auto-generated method stub
		if (this.getNewCurrencyRates() != null && this.getNewCurrencyRates().size() >= 2) {

			List<TrendPointXY> ptsBid = new ArrayList<>(this.getPointsXYOfBid());
			List<TrendPointXY> ptsAsk = new ArrayList<>(this.getPointsXYOfAsk());

			// Stage 2 : Sorting the list of currency Rate (the youngest is first)
			Collections.sort(ptsBid, TrendPointXY.ptComparatorByDate);
			Collections.sort(ptsAsk, TrendPointXY.ptComparatorByDate);

			// Stage 3 : scroll through the rule list and start the note calculation process according
			// to each rule.

			for (TrendRule tr : this.getTrendRule().getTrendRules()) {

				Date startDateRule = tr.updateDefinitionStartDate();
				Date endDateRule = tr.updateDefinitioneEndDate();

				List<TrendPointXY> ptsBidTransmit = new ArrayList<>(ptsBid);
				List<TrendPointXY> ptsAskTransmit = new ArrayList<>(ptsAsk);

				ptsBidTransmit.removeIf(p -> p.getX() < startDateRule.getTime());
				ptsAskTransmit.removeIf(p -> p.getX() < startDateRule.getTime());
				ptsBidTransmit.removeIf(p -> p.getX() > endDateRule.getTime()); //pour éliminer les valeurs mocké trop dans le futur
				ptsAskTransmit.removeIf(p -> p.getX() > endDateRule.getTime()); //pour éliminer les valeurs mocké trop dans le futur
				
				
				//Transmission for calculation
				
				if (ptsBidTransmit.size()>2 && ptsAskTransmit.size()>2) {
				
				// new calcul of note to sell
				TrendNoteToSell tnts = new TrendNoteToSell(ptsBidTransmit, tr, this);
				Thread t0 = new Thread(tnts);
				t0.start();
				
				
				TrendNoteToBuy tntb = new TrendNoteToBuy(ptsAskTransmit, tr, this);
				Thread t1 = new Thread(tntb);
				t1.start();
				
				}else {
					System.out.println("erreur OOCT: pas assez de données, ne peut pas faire l'objet de calcul");
				}
				
				
			}

		} else {
			this.log.warn("error : le calcul ne peut pas être fait il n'y a pas assez de données ou liste null" + this.toString());
		}
		
	}

	private boolean waitResultNote() {
		
		int i = 0;
		
		while (true) {
			
			int nbOfnotesToBuy = this.getTrendNotesToBuy().size();
			int nbOfnotesToSell = this.getTrendNotesToSell().size();
			int nbOftrendRules = this.getTrendRule().getTrendRules().size(); 

			if (nbOfnotesToBuy == nbOftrendRules && nbOfnotesToSell == nbOftrendRules) {

				return true;
			}
			
			if (i > 50) {
				//time is exceeded
				return false;
			}
			i++;
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void comparisonCurrencyRatesList() {
		// TODO Auto-generated method stub
		if (this.getNewCurrencyRates() != null && this.getOldCurrencyRates() != null) {

			List<CurrencyRate> added = new ArrayList<CurrencyRate>(this.getNewCurrencyRates());
			added.removeAll(this.getOldCurrencyRates());

			// update comparison currency rate list
			this.setComparisonCurrencyRates(added);
			// update old currency rate list
			this.setOldCurrencyRates(this.getNewCurrencyRates());

		} else if (this.getNewCurrencyRates() != null && this.getOldCurrencyRates() == null) {

			// update comparison currency rate list
			this.setComparisonCurrencyRates(this.getNewCurrencyRates());
			// update old currency rate list
			this.setOldCurrencyRates(this.getNewCurrencyRates());

		} else {
			log.warn("erreur lors la comparaison des currency rate list");
		}

	}

	private void updatePointsXY() {
		// TODO Auto-generated method stub

		if (this.getComparisonCurrencyRates() != null) {
			List<CurrencyRate> add = new ArrayList<CurrencyRate>(this.getComparisonCurrencyRates());

			Iterator<CurrencyRate> ite = add.iterator();

			while (ite.hasNext()) {
				CurrencyRate cr = ite.next();
				TrendPointXY ptBid = new TrendPointXY();
				TrendPointXY ptAsk = new TrendPointXY();

				ptBid.setX(cr.getTimerecord().getTime());
				ptAsk.setX(cr.getTimerecord().getTime());
				ptBid.setY(cr.getBidbtc());
				ptAsk.setY(cr.getAskbtc());

				this.getPointsXYOfBid().add(ptBid);
				this.getPointsXYOfAsk().add(ptAsk);
			}
		}else {
			log.warn("pas d'update liste des points");
		}

	}

	public static void main(String[] args) {

		TrendRulesBot tr = new TrendRulesBot();

		tr.loadTrendRulesBotEnum();

		for (TrendRule trb : tr.getTrendRules()) {
			System.out.println(trb.getName() + ", date départ " + trb.updateDefinitionStartDate() + ", date fin"
					+ trb.updateDefinitioneEndDate());
		}

		CurrencyRate cr1 = new CurrencyRate();
		cr1.setTimerecord(new Date(1514305547000L));
		CurrencyRate cr2 = new CurrencyRate();
		cr2.setTimerecord(new Date(1514287547000L));
		CurrencyRate cr3 = new CurrencyRate();
		cr3.setTimerecord(new Date(1514114747000L));
		CurrencyRate cr4 = new CurrencyRate();
		cr4.setTimerecord(new Date(1513164347000L));

		Date startDateRule = new Date(1514291147000L);
		List<CurrencyRate> crsTransmit = new ArrayList<>();

		crsTransmit.add(cr1);
		crsTransmit.add(cr2);
		crsTransmit.add(cr3);
		crsTransmit.add(cr4);

		crsTransmit.removeIf(p -> p.getTimerecord().getTime() < startDateRule.getTime());
		System.out.println("----------------------");
		for (CurrencyRate currencyRate : crsTransmit) {
			System.out.println(currencyRate.getTimerecord());
		}

	}

}

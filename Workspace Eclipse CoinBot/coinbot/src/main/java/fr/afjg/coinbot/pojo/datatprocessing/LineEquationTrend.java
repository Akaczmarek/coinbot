package fr.afjg.coinbot.pojo.datatprocessing;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class LineEquationTrend implements Runnable {

	private double leadingDirect;
	private double ordOrigin;
	
	private PointXY averagePt1;
	private PointXY averagePt2;
	private String typeBidOrAsk;	//"bid" or "ask"
	private String typeLine;		//"average" or "support" or "ceiling"
	private TrendCalculation trendCalculation;
	private List<PointXY> ptList;
	
	public LineEquationTrend() {
		
	}
	
	public LineEquationTrend(TrendCalculation trendCalculation,String typeBidOrAsk,String typeLine, PointXY averagePt1,PointXY averagePt2,List<PointXY> ptList) {
		this.setTrendCalculation(trendCalculation);
		this.setTypeBidOrAsk(typeBidOrAsk);
		this.setTypeLine(typeLine);
		this.setAveragePt1(averagePt1);
		this.setAveragePt2(averagePt2);
		this.setPtList(ptList);
	}

	public double getLeadingDirect() {
		return leadingDirect;
	}

	public void setLeadingDirect(double leadingDirect) {
		this.leadingDirect = leadingDirect;
	}

	public double getOrdOrigin() {
		return ordOrigin;
	}

	public void setOrdOrigin(double ordOrigin) {
		this.ordOrigin = ordOrigin;
	}
	

	public PointXY getAveragePt1() {
		return averagePt1;
	}

	public void setAveragePt1(PointXY averagePt1) {
		this.averagePt1 = averagePt1;
	}

	public PointXY getAveragePt2() {
		return averagePt2;
	}

	public void setAveragePt2(PointXY averagePt2) {
		this.averagePt2 = averagePt2;
	}

	public String getTypeBidOrAsk() {
		return typeBidOrAsk;
	}

	public void setTypeBidOrAsk(String typeBidOrAsk) {
		this.typeBidOrAsk = typeBidOrAsk;
	}

	public String getTypeLine() {
		return typeLine;
	}

	public void setTypeLine(String typeLine) {
		this.typeLine = typeLine;
	}

	public TrendCalculation getTrendCalculation() {
		return trendCalculation;
	}

	public void setTrendCalculation(TrendCalculation trendCalculation) {
		this.trendCalculation = trendCalculation;
	}
	

	
	public List<PointXY> getPtList() {
		return ptList;
	}

	public void setPtList(List<PointXY> ptList) {
		this.ptList = ptList;
	}

	


	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("calcul équation lancé-----------------------------------------");
		
		//Stage 0 : variable initializing 
		double pt1X = this.getAveragePt1().getX();
		double pt1Y = this.getAveragePt1().getY();
		double pt2X = this.getAveragePt2().getX();
		double pt2Y = this.getAveragePt2().getY();
		
		
		//Stage 1 : calculation main equation line
		this.setOrdOrigin((pt1X * pt2Y - pt1Y * pt2X) / (pt1X - pt2X));
		
		double b = this.getOrdOrigin();
		
		this.setLeadingDirect((pt1Y - b) / pt1X);
		
		double a = this.getLeadingDirect();
		
		
		
		//Stage 2 : sort point list (the last point is highest point in relation to the line, the first point is the lowest point...) 
		List<PointXY> ptList = this.getPtList();
		Map<Double, PointXY> comparisonList = new TreeMap<>();	//comparison between line and point
		Iterator<PointXY> ite = ptList.iterator();
		
		while(ite.hasNext()) {
			PointXY pt;
			double resultComparison;
			double y;
			long x;
			
			pt = ite.next();
			x = pt.getX();
			y = pt.getY();
			
			resultComparison = y - a * x + b;
			
			comparisonList.put(resultComparison, pt);
		}
		
		//result :
		PointXY lowPt = comparisonList.get( ((TreeMap<Double, PointXY>) comparisonList).firstKey());
		PointXY highPt = comparisonList.get( ((TreeMap<Double, PointXY>) comparisonList).lastKey());

		
		
		//Stage 3 :correction equation for ceiling and support : change ordOrigin
		if ("ceiling".equals(this.getTypeLine())) {
			double yHighPt = highPt.getY();
			long xHighPt = highPt.getX();
			
			b = yHighPt - a * xHighPt;
			this.setOrdOrigin(b);
			
			
		}else if ("support".equals(this.getTypeLine())) {
			
			double yLowPt = lowPt.getY();
			long xLowPt = lowPt.getX();
			
			b = yLowPt - a * xLowPt;
			this.setOrdOrigin(b);
			
		}
		

		
		//Stage 3 :Save in list lineEquationTrend of trendCalculation
		
		this.getTrendCalculation().getLinesEquationsTrends().add(this);
		
		//Stage 4 : prevent it's finished
		
		this.getTrendCalculation().finishActionsChecked();
		
		System.out.println("calcul équation terminé ///////////////////////////////////////////");
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		Map<Double, Double> comparisonList = new TreeMap<>();
		
		comparisonList.put(1.0,10.0);
		comparisonList.put(8.0,2.0);
		comparisonList.put(3.0,1.0);
		comparisonList.put(4.0,1.0);
		comparisonList.put(6.0,1.0);
		comparisonList.put(5.0,1.0);
		comparisonList.put(7.0,1.0);
		comparisonList.put(2.0,3.0);
		System.out.println("First key is: "+ ((TreeMap<Double, Double>) comparisonList).firstKey() + ", value : " + comparisonList.get(((TreeMap<Double, Double>) comparisonList).firstKey()));
		
	      Set<Entry<Double, Double>> set = comparisonList.entrySet();
	      
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
	         System.out.println(mentry.getValue());
	      }
		
		
		
	}

	
	
	
	
	
	
}

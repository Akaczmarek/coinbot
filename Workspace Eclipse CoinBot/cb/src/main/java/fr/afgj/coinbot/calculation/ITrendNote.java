package fr.afgj.coinbot.calculation;

import java.util.List;

import fr.afgj.coinbot.calculation.impl.TrendPointXYAverage;
import fr.afgj.coinbot.entity.CurrencyRate;

public interface ITrendNote {

	TrendPointXYAverage calculationAveragePt1(String type);

	TrendPointXYAverage calculationAveragePt2(String type);

	TrendPointXYAverage calculationAveragePt(List<CurrencyRate> partOfCurrencyRate, String type);

}
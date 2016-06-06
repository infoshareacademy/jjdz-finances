package com.infoshareacademy.finances.web;

import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.repository.DailyValuesRepository;
import com.infoshareacademy.finances.service.MonthlyTrendsService;

@WebServlet("/drawChart")
public class DrawServlet extends HttpServlet {
	private static final Logger LOGGER = LoggerFactory.getLogger(DrawServlet.class);
	private static final long serialVersionUID = -7756691594094618687L;

	@EJB
	MonthlyTrendsService monthlyTrendsService;

	@EJB
	DailyValuesRepository dailyValuesRepository;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocalDate dateFrom = LocalDate.now().withMonth(9).withYear(2014).withDayOfMonth(1);
		int interval = dateFrom.lengthOfMonth();
		LocalDate dateTo = dateFrom.withDayOfMonth(interval);

		List<DailyValue> dailyValues = dailyValuesRepository.findDailyValuesByRange("OPE033", dateFrom, dateTo);
		TimeSeriesCollection dataSet = new TimeSeriesCollection();

		TimeSeries monthlyValues = new TimeSeries("Daily Values");
		dailyValues.forEach(a -> {
			LocalDate date = a.getDate();
			monthlyValues.add(new Day(date.getDayOfMonth(), date.getMonth().getValue(), date.getYear()),
					a.getCloseValue().doubleValue());
		});
		dataSet.addSeries(monthlyValues);

		List<DailyValue> dailyValuesTemp = monthlyTrendsService.calculateMonthlyTrend(dailyValues);
		List<DailyValue> dailyValuesTrend = monthlyTrendsService.calculateMonthlyTrend(dailyValuesTemp);

		TimeSeries trendValues = new TimeSeries("Trend Line");
		dailyValuesTrend.forEach(a -> {
			LocalDate date = a.getDate();
			trendValues.add(new Day(date.getDayOfMonth(), date.getMonth().getValue(), date.getYear()),
					a.getCloseValue().doubleValue());
		});
		dataSet.addSeries(trendValues);

		JFreeChart chart = ChartFactory.createTimeSeriesChart("", "Days", "Close Values", dataSet, true, true, false);
		chart.setBackgroundPaint(Color.cyan);

		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(new Color(213, 206, 215));

		//CUSTOMIZE DOMAIN AXIS
		ValueAxis domainAxis = plot.getDomainAxis();
		//customize domain label position
		domainAxis.setVerticalTickLabels(true);

		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("dd-MM-yyyy"));

		//CUSTOMIZE THE RENDERER
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
		//set lines color
		renderer.setSeriesPaint(0, Color.BLUE);
		renderer.setSeriesPaint(1, Color.RED);
		//show points
		renderer.setBaseShapesFilled(true);
		renderer.setBaseShapesVisible(true);

		try {
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());

			ServletOutputStream out = resp.getOutputStream();
			ChartUtilities.writeChartAsPNG(out, chart, 900, 400, info);
		} catch (Exception e) {
			LOGGER.info("Write chart as PNG failed: {}", e);
			throw e;
		}

	}
}

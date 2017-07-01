package com.github.drbookings.ui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public abstract class AbstractBinningChart<T> {

	public final static int DEFAULT_BIN_SIZE = 1;
	protected final List<T> bin = new ArrayList<>();
	private final DoubleProperty binSize = new SimpleDoubleProperty(DEFAULT_BIN_SIZE);
	protected final Set<String> categories = new LinkedHashSet<>();

	private XYChart<String, Number> chart;

	public XYChart<String, Number> getChart() {
		return chart;
	}

	public void setChart(final XYChart<String, Number> chart) {
		this.chart = chart;
	}

	public CategoryAxis getxAxis() {
		return xAxis;
	}

	public void setxAxis(final CategoryAxis xAxis) {
		this.xAxis = xAxis;
	}

	Map<String, Series<String, Number>> mapSeries = new HashMap<>();

	private CategoryAxis xAxis;

	public final DoubleProperty binSizeProperty() {
		return this.binSize;
	}

	protected abstract void flushBin();

	public final int getBinSize() {
		return (int) this.binSizeProperty().get();
	}

	public final void setBinSize(final int binSize) {
		this.binSizeProperty().set(binSize);
	}
}

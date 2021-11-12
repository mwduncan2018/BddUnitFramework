package com.bddunitframework.grid;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.bddunitframework.config.ConfigProps;
import com.bddunitframework.grid.model.GridApiHubRoot;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GridScheduler {
	private static long timeout = 1800000; // 30 minutes
	private static Boolean firstAttempt = true;
	private static Integer delay = 3000; // 3 seconds
	private long startTime;
	private long endTime;

	public GridScheduler() {
		startTime = System.currentTimeMillis();
		endTime = startTime + timeout;
	}

	public void waitForAvailableNode() {
		while (System.currentTimeMillis() < endTime) {
			if (gridHasAvailableNode()) {
				return;
			}
		}
	}

	public static synchronized Boolean gridHasAvailableNode() {
		// Wait between sending tests to the Selenium Grid to prevent timeouts.
		if (firstAttempt)
			firstAttempt = false;
		else
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				return false;
			}

		// Connect to the Grid Hub API.
		HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) new URL(getGridIp()).openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			conn.connect();

			Integer numberOfFreeNodes = new ObjectMapper()
					.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
					.readValue(conn.getInputStream(), GridApiHubRoot.class).getSlotCounts().getFree();

			System.out.println("Nodes Available (" + numberOfFreeNodes + ")");
			
			// If the Grid has an available node, return true.
			if (numberOfFreeNodes > 0)
				return true;
			else
				return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private static String getGridIp() {
		String url = System.getenv("GRID_IP");
		if (url == null)
			url = ConfigProps.getGridIp();
		System.out.println("*****************************************");
		System.out.println("*****************************************");
		System.out.println(url);
		System.out.println("*****************************************");
		System.out.println("*****************************************");
		return url + "/grid/api/hub";
	}
}

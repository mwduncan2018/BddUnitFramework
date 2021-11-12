package com.bddunitframework.grid.model;

public class GridApiHubRoot {
	private Integer browserTimeout;
	private String capabilityMatcher;
	private Integer cleanUpCycle;
	private Custom custom;
	private Boolean debug;
	private String host;
	private Integer jettyMaxThreads;
	private Integer newSessionRequestCount;
	private Integer newSessionWaitTimeout;
	private String port;
	private String registry;
	private String role;
	private Servlets[] servlets;
	private SlotCounts slotCounts;
	private Boolean success;
	private Boolean throwOnCapabilityNotPresent;
	private Integer timeout;
	private WithoutServlets[] withoutServlets;

	public Integer getBrowserTimeout() {
		return browserTimeout;
	}

	public void setBrowserTimeout(Integer browserTimeout) {
		this.browserTimeout = browserTimeout;
	}

	public String getCapabilityMatcher() {
		return capabilityMatcher;
	}

	public void setCapabilityMatcher(String capabilityMatcher) {
		this.capabilityMatcher = capabilityMatcher;
	}

	public Integer getCleanUpCycle() {
		return cleanUpCycle;
	}

	public void setCleanUpCycle(Integer cleanUpCycle) {
		this.cleanUpCycle = cleanUpCycle;
	}

	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public Boolean getDebug() {
		return debug;
	}

	public void setDebug(Boolean debug) {
		this.debug = debug;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getJettyMaxThreads() {
		return jettyMaxThreads;
	}

	public void setJettyMaxThreads(Integer jettyMaxThreads) {
		this.jettyMaxThreads = jettyMaxThreads;
	}

	public Integer getNewSessionRequestCount() {
		return newSessionRequestCount;
	}

	public void setNewSessionRequestCount(Integer newSessionRequestCount) {
		this.newSessionRequestCount = newSessionRequestCount;
	}

	public Integer getNewSessionWaitTimeout() {
		return newSessionWaitTimeout;
	}

	public void setNewSessionWaitTimeout(Integer newSessionWaitTimeout) {
		this.newSessionWaitTimeout = newSessionWaitTimeout;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getRegistry() {
		return registry;
	}

	public void setRegistry(String registry) {
		this.registry = registry;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Servlets[] getServlets() {
		return servlets;
	}

	public void setServlets(Servlets[] servlets) {
		this.servlets = servlets;
	}

	public SlotCounts getSlotCounts() {
		return slotCounts;
	}

	public void setSlotCounts(SlotCounts slotCounts) {
		this.slotCounts = slotCounts;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Boolean getThrowOnCapabilityNotPresent() {
		return throwOnCapabilityNotPresent;
	}

	public void setThrowOnCapabilityNotPresent(Boolean throwOnCapabilityNotPresent) {
		this.throwOnCapabilityNotPresent = throwOnCapabilityNotPresent;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public WithoutServlets[] getWithoutServlets() {
		return withoutServlets;
	}

	public void setWithoutServlets(WithoutServlets[] withoutServlets) {
		this.withoutServlets = withoutServlets;
	}
}

package com.sldd.dbinitializer;

public class ConnectionProperties{

	private String dbClusterIdentifier;
	private String password;
	private String dbname;
	private String engine;
	private int port;
	private String host;
	private String username;

	public String getUrl() {
		return "jdbc:postgresql://" + host + ":" + port;
	}

	public String getDbClusterIdentifier() {
		return dbClusterIdentifier;
	}

	public void setDbClusterIdentifier(String dbClusterIdentifier) {
		this.dbClusterIdentifier = dbClusterIdentifier;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "ConnectionProperties{" +
				"dbClusterIdentifier='" + dbClusterIdentifier + '\'' +
				", dbname='" + dbname + '\'' +
				", engine='" + engine + '\'' +
				", port=" + port +
				", host='" + host + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}

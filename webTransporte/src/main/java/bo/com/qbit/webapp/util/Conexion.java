package bo.com.qbit.webapp.util;

import java.io.Serializable;

public class Conexion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2579990640927344648L;
	static String datasourse = "java:jboss/datasources/ConsultoraDS";

	public String getDatasourse() {
		return datasourse;
	}

	public void setDatasourse(String datasourse) {
		this.datasourse = datasourse;
	}

}

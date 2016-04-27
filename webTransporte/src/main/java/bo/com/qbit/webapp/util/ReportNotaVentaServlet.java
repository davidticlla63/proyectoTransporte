package bo.com.qbit.webapp.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.log4j.Logger;
import org.jfree.util.Log;

import bo.com.qbit.webapp.model.Factura;
import bo.com.qbit.webapp.model.NotaVenta;

@WebServlet("/ReportNotaVenta")
public class ReportNotaVentaServlet extends HttpServlet {

	@Inject
	private EntityManager em;

	@Inject
	private FacesContext facesContext;

	Logger log = Logger.getLogger(ReportNotaVentaServlet.class);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletOutputStream servletOutputStream = response.getOutputStream();
		Connection conn = null;
		JasperReport jasperReport;
		JasperPrint jasperPrint;

		Statement stmt = null;
		ResultSet rs = null;

		try {

			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(Conexion.datasourse);

			conn = ds.getConnection();

			if (conn != null) {
				System.out.println("Conexion Exitosa JDBC com.edb.Driver...");
			} else {
				System.out.println("Error Conexion JDBC com.edb.Driver...");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al conectar JDBC: " + e.getMessage());
		}

		try {

			try {

				String idFactura = request.getParameter("pIdNotaVenta");
				String pais = request.getParameter("pPais");
				String logo = request.getParameter("pLogo");
				String pTamano = request.getParameter("pTamano");
				NotaVenta notaVenta = em.find(NotaVenta.class, new Integer(
						idFactura));

				if (notaVenta != null) {

					System.out.println("Conexion em: " + em.isOpen());

					String realPath = request.getRealPath("/");
					System.out.println("Real Path: " + realPath);

					// load JasperDesign from XML and compile it into
					// JasperReport
					System.out.println("Context getServletContext: "
							+ request.getServletContext().getContextPath());
					System.out.println("Context getServletPath: "
							+ request.getServletPath());
					System.out
							.println("Context getSession().getServletContext(): "
									+ request.getSession().getServletContext()
											.getRealPath("/"));

					String urlPath = request.getRequestURL().toString();
					urlPath = urlPath.substring(0, urlPath.length()
							- request.getRequestURI().length())
							+ request.getContextPath() + "/";
					System.out.println("URL ::::: " + urlPath);

					// create a map of parameters to pass to the report.
					Map parameters = new HashMap();
					parameters.put("id", new Integer(idFactura));
					parameters.put("pais", pais);
					parameters.put("logo", logo);
					parameters.put("REPORT_LOCALE", new Locale("en", "US"));

					String rutaReporte = "";
					String tamano = pTamano;
					log.info("tamano : " + tamano);
					switch (tamano) {
					case "LEGAL":
						rutaReporte = urlPath
								+ "resources/report/Venta/reportNotaVenta.jasper";
						break;
					case "LETTER":
						rutaReporte = urlPath
								+ "resources/report/Venta/reportNotaVenta.jasper";
						break;
					case "MINI":
						rutaReporte = urlPath
								+ "resources/report/Facturacion/notaVenta.jasper";
						break;

					}

					Log.info("Parametros : " + parameters.toString());

					log.info("rutaReporte: " + rutaReporte);

					// find file .jasper
					jasperReport = (JasperReport) JRLoader.loadObject(new URL(
							rutaReporte));

					// fill JasperPrint using fillReport() method
					jasperPrint = JasperFillManager.fillReport(jasperReport,
							parameters, conn);

					// save report to path
					JasperExportManager.exportReportToPdfFile(
							jasperPrint,
							"/facturas/NotaVenta-NRO-"
									+ notaVenta.getNumeroFactura() + "-NIT-"
									+ notaVenta.getNitCi() + tamano + ".pdf");
					response.setContentType("application/pdf");
					response.setCharacterEncoding("UTF-8");
					JasperExportManager.exportReportToPdfStream(jasperPrint,
							servletOutputStream);

					servletOutputStream.flush();
					servletOutputStream.close();

				} else {
					log.info("Factura no encontrada x ID: " + idFactura);
				}

			} catch (Exception e) {
				// display stack trace in the browser
				e.printStackTrace();
				log.error("Error al ingresar JasperReportServlet: "
						+ e.getMessage());
				StringWriter stringWriter = new StringWriter();
				PrintWriter printWriter = new PrintWriter(stringWriter);
				e.printStackTrace(printWriter);
				response.setContentType("text/plain");
				response.getOutputStream().print(stringWriter.toString());

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

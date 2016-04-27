package bo.com.qbit.webapp.util;

import java.io.FileInputStream;
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
import java.util.Properties;

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

import bo.com.qbit.webapp.model.Factura;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;


@WebServlet("/factura2")
public class JasperReportServlet extends HttpServlet {
	
	@Inject
    private EntityManager em;
	
	@Inject
    private FacesContext facesContext;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ServletOutputStream servletOutputStream = response.getOutputStream();

		JasperReport jasperReport;
		JasperPrint jasperPrint;

		Connection conn = null;
		DataSource ds = null;
		Context ctx = null;
		try {

			try {

				ctx = new InitialContext();
				ds = (DataSource) ctx.lookup(Conexion.datasourse);

				conn = ds.getConnection();

				if (conn != null) {
					System.out
							.println("Conexion Exitosa JDBC com.edb.Driver...");
				} else {
					System.out.println("Error Conexion JDBC com.edb.Driver...");
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error al conectar JDBC: " + e.getMessage());
			}    
        	try { 
        		String idFactura = request.getParameter("idFactura");
        		
        		Factura factura = em.find(Factura.class, new Integer(idFactura));
        		
        		if(factura!=null){
        			
        			System.out.println("Conexion em: "+em.isOpen());
        			
        			String realPath = request.getRealPath("/");
        			System.out.println("Real Path: "+realPath);

        			// load JasperDesign from XML and compile it into JasperReport
        			System.out.println("Context getServletContext: "+request.getServletContext().getContextPath());
        			System.out.println("Context getServletPath: "+request.getServletPath());
        			System.out.println("Context getSession().getServletContext(): "+request.getSession().getServletContext().getRealPath("/"));
        			
        			
        			String urlPath = request.getRequestURL().toString();
        			urlPath = urlPath.substring(0, urlPath.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
        			System.out.println("URL ::::: "+urlPath);
        			
        			String urlQR = urlPath+"codeQR?qrtext="+factura.getCodigoRespuestaRapida();
        			//http://localhost:8080/MediFact/codeQR?qrtext=162264025|32|7901001300997|06/10/2014|276.0|276.0|01-0A-64-6D-89|6296719|0|0|0|0
        			
        			
        			// create a map of parameters to pass to the report.
        			Map parameters = new HashMap();
        			parameters.put("pFactura", new Integer(idFactura));
        			parameters.put("pCodeQR", urlQR);
        			parameters.put("REPORT_LOCALE", new Locale("en", "US"));
        			
        			String rutaReporte = urlPath+"resources/report/factura.jasper";
        			System.out.println("rutaReporte: "+rutaReporte);
        			
        			//find file .jasper
        			jasperReport = (JasperReport)JRLoader.loadObject (new URL(rutaReporte));

        			// fill JasperPrint using fillReport() method
        			jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, conn);
        			
        			//save report to path
        			JasperExportManager.exportReportToPdfFile(jasperPrint,"/facturas/Factura-NRO-"+factura.getNumeroFactura()+"-NIT-"+factura.getNitCi()+".pdf");
        			response.setContentType("application/pdf");
        			JasperExportManager.exportReportToPdfStream(jasperPrint,servletOutputStream);

        			servletOutputStream.flush();
        			servletOutputStream.close();
        			
        		}else{
        			System.out.println("Factura no encontrada x ID: "+idFactura);
        		}
    			
    		} catch (Exception e) {
    			// display stack trace in the browser
    			e.printStackTrace();
    			System.out.println("Error al ingresar JasperReportServlet: " + e.getMessage());
    			StringWriter stringWriter = new StringWriter();
    			PrintWriter printWriter = new PrintWriter(stringWriter);
    			e.printStackTrace(printWriter);
    			response.setContentType("text/plain");
    			response.getOutputStream().print(stringWriter.toString());
    			
    		} 
        	
        	
        } catch (Exception e) {
            e.printStackTrace();
            
            
        }finally{
			try{
				if(!conn.isClosed()){
					System.out.println("cerrando conexion...");
					conn.close();
				}
			}catch(Exception e){
				System.out.println("No se pudo cerrar la conexion, Error: "+e.getMessage());
			}
		}
		
	}
	
}

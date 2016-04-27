package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.FormatoFactura;
import bo.com.qbit.webapp.model.FormatoHoja;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class FormatoFacturaRegistration extends DataAccessService<FormatoFactura>{
	public FormatoFacturaRegistration(){
		super(FormatoFactura.class);
	}
}

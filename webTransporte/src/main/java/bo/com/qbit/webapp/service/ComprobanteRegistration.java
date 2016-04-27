package bo.com.qbit.webapp.service;


import javax.ejb.Stateless;
import bo.com.qbit.webapp.model.Comprobante;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class ComprobanteRegistration extends DataAccessService<Comprobante>{
	public ComprobanteRegistration(){
		super(Comprobante.class);
	}

}


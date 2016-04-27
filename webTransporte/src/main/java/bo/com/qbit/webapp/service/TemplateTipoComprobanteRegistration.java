package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;
import bo.com.qbit.webapp.model.TemplateTipoComprobante;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class TemplateTipoComprobanteRegistration extends DataAccessService<TemplateTipoComprobante>{
	public TemplateTipoComprobanteRegistration(){
		super(TemplateTipoComprobante.class);
	}

}

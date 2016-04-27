package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.Dosificacion;
import bo.com.qbit.webapp.model.Linea;
import bo.com.qbit.webapp.model.Pais;
import bo.com.qbit.webapp.model.TamanoHoja;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class TamanoHojaRegistration extends DataAccessService<TamanoHoja>{
	public TamanoHojaRegistration(){
		super(TamanoHoja.class);
	}
}

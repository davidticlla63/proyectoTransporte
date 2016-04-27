package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.Dosificacion;
import bo.com.qbit.webapp.model.Pais;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class PaisRegistration extends DataAccessService<Pais>{
	public PaisRegistration(){
		super(Pais.class);
	}
}

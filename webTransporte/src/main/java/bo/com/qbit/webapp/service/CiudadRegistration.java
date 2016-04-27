package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.Ciudad;
import bo.com.qbit.webapp.model.Dosificacion;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class CiudadRegistration extends DataAccessService<Ciudad>{
	public CiudadRegistration(){
		super(Ciudad.class);
	}
}

package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.Dosificacion;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class DosificacionRegistration extends DataAccessService<Dosificacion>{
	public DosificacionRegistration(){
		super(Dosificacion.class);
	}
}

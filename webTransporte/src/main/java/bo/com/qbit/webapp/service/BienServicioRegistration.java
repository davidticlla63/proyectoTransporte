package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.BienServicio;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class BienServicioRegistration extends DataAccessService<BienServicio>{
	public BienServicioRegistration(){
		super(BienServicio.class);
	}

}


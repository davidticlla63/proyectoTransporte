package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.Sucursal;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class SucursalRegistration extends DataAccessService<Sucursal>{
	public SucursalRegistration(){
		super(Sucursal.class);
	}

}

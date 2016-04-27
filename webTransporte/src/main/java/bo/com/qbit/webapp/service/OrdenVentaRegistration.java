package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.OrdenVenta;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class OrdenVentaRegistration extends DataAccessService<OrdenVenta>{
	public OrdenVentaRegistration(){
		super(OrdenVenta.class);
	}
}

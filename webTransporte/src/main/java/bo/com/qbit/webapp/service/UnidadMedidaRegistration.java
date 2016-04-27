package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.UnidadMedida;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class UnidadMedidaRegistration extends DataAccessService<UnidadMedida>{
	public UnidadMedidaRegistration(){
		super(UnidadMedida.class);
	}
}

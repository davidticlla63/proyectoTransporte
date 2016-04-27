package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.DetalleGrupoImpuesto;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class DetalleGrupoImpuestoRegistration extends DataAccessService<DetalleGrupoImpuesto>{
	public DetalleGrupoImpuestoRegistration(){
		super(DetalleGrupoImpuesto.class);
	}

}


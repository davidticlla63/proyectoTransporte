package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;
import bo.com.qbit.webapp.model.PlanCuenta;

//The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class PlanCuentaRegistration  extends DataAccessService<PlanCuenta>{

	
	public PlanCuentaRegistration(){
		super(PlanCuenta.class);
	}
}

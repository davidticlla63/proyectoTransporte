package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.PlanCuentaBancaria;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class PlanCuentaBancariaRegistration extends DataAccessService<PlanCuentaBancaria>{
	public PlanCuentaBancariaRegistration(){
		super(PlanCuentaBancaria.class);
	}

}


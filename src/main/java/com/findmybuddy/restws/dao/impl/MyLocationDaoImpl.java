package com.findmybuddy.restws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.findmybuddy.restws.dao.MyLocationDao;
import com.findmybuddy.restws.domain.MyDetails;
import com.findmybuddy.restws.domain.MyLocation;

@Repository
public class MyLocationDaoImpl implements MyLocationDao {

	protected EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public String saveMyLocation(MyLocation location) {
		entityManager.merge(location);
		entityManager.flush();
		return Response.Status.OK.getReasonPhrase();
	}
	@Transactional
	@Override
	public void saveMyDetails(MyDetails myDetails) {
		entityManager.persist(myDetails);
	}
	@Override
	public MyDetails getMyDetails(String number) {
		MyDetails details = entityManager.find(MyDetails.class,number);
		return details;
	}
	@Override
	public MyLocation getMyLocation(String number) {
		MyLocation mylocation = entityManager.find(MyLocation.class,number);
		return mylocation;
	}



}

package com.finance.layer3;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finance.layer2.ApprovalTable;

@Repository
public class ApprovalRepositoryImpl implements ApprovalRepository {
	
	
	@PersistenceContext
	 EntityManager entityManager;//auto injected by spring by reading 
										//persistance.xml file
	
	@Transactional//no need of begin transaction and commit rollback
	public void addApproval(ApprovalTable aRef) {//usesA
		entityManager.persist(aRef);

	}
	
	@Transactional
	public ApprovalTable findApproval(int approvalNo) {//producesA Department obj
		System.out.println("ApprovalTable repo....NO scope of bussiness logic here...");
		return entityManager.find(ApprovalTable.class,approvalNo);
		
	}
	
	@Transactional
	public List<ApprovalTable> findAllApprovals() {
		// TODO Auto-generated method stub
		List<ApprovalTable> approvalList;
		approvalList = new ArrayList<ApprovalTable>();
		
			
			Query query = entityManager.createNativeQuery("select * from APPROVAL_TABLE",ApprovalTable.class);
			approvalList = query.getResultList();
			
		
		return approvalList;
	}

	
	@Transactional
	public void modifyApproval(ApprovalTable aRef) {
		entityManager.merge(aRef);

	}

	@Transactional
	public void removeApproval(int approvalNo) {
		ApprovalTable aTemp = entityManager.find(ApprovalTable.class,approvalNo);
		entityManager.remove(aTemp);
		
	}

	
	
	

	
	

}

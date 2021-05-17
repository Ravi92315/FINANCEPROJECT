package com.finance.layer3;

import java.util.List;

import com.finance.layer2.ApprovalTable;

public interface ApprovalRepository {
	void addApproval(ApprovalTable aRef);   //C - add/create
	ApprovalTable findApproval(int approvalNo);     //R - find/reading
	List<ApprovalTable> findAllApprovals();     //R - find all/reading all
	void modifyApproval(ApprovalTable dRef); //U - modify/update
	void removeApproval(int approvalNo); //D - remove/delete
}

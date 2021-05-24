package com.finance.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the APPROVAL_TABLE database table.
 * 
 */
@Entity
@Table(name="APPROVAL_TABLE")
@NamedQuery(name="ApprovalTable.findAll", query="SELECT a FROM ApprovalTable a")
public class ApprovalTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="APPROVAL_NO")
	private long approvalNo;

	@Column(name="APPROVAL_STATUS")
	private String approvalStatus;

	@Column(name="CARD_FEE")
	private long cardFee;

//	//bi-directional many-to-one association to RegistrationTable
//	@ManyToOne
//	@JoinColumn(name="REG_ID")
//	private RegistrationTable registrationTable1;

	//bi-directional many-to-one association to CardTable
//	@OneToMany(mappedBy="approvalTable1", fetch=FetchType.EAGER)
//	private Set<CardTable> cardTables;

	//bi-directional one-to-one association to RegistrationTable
	@OneToOne(mappedBy="approvalTable")
	private RegistrationTable registrationTable2;

	//bi-directional one-to-one association to CardTable
	@OneToOne
	@JoinColumn(name="APPROVAL_NO", referencedColumnName="APPROVAL_NO")
	private CardTable cardTable;

	public ApprovalTable() {
	}

	public long getApprovalNo() {
		return this.approvalNo;
	}

	public void setApprovalNo(long approvalNo) {
		this.approvalNo = approvalNo;
	}

	public String getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public long getCardFee() {
		return this.cardFee;
	}

	public void setCardFee(long cardFee) {
		this.cardFee = cardFee;
	}

//	public RegistrationTable getRegistrationTable1() {
//		return this.registrationTable1;
//	}
//
//	public void setRegistrationTable1(RegistrationTable registrationTable1) {
//		this.registrationTable1 = registrationTable1;
//	}

//	public Set<CardTable> getCardTables() {
//		return this.cardTables;
//	}
//
//	public void setCardTables(Set<CardTable> cardTables) {
//		this.cardTables = cardTables;
//	}

//	public CardTable addCardTable(CardTable cardTable) {
//		getCardTables().add(cardTable);
//		cardTable.setApprovalTable1(this);
//
//		return cardTable;
//	}
//
//	public CardTable removeCardTable(CardTable cardTable) {
//		getCardTables().remove(cardTable);
//		cardTable.setApprovalTable1(null);
//
//		return cardTable;
//	}

	public RegistrationTable getRegistrationTable2() {
		return this.registrationTable2;
	}

	public void setRegistrationTable2(RegistrationTable registrationTable2) {
		this.registrationTable2 = registrationTable2;
	}

//	public CardTable getCardTable() {
//		return this.cardTable;
//	}
//
//	public void setCardTable(CardTable cardTable) {
//		this.cardTable = cardTable;
//	}

}
package com.example.reimbursement.service;

import java.util.List;
import java.util.Optional;

import com.example.reimbursement.models.Reimbursement;
import com.example.reimbursement.repo.ReimbursementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Service for Reimbursement
 */
@Slf4j
@Service
public class ReimbursementService {

	private ReimbursementRepository reimbursementRepo;

	public ReimbursementService(ReimbursementRepository reimbursementRepo) {
		super();
		this.reimbursementRepo = reimbursementRepo;
	}

	/**
	 * This is to create a new reimbursement request
	 * @param reimbursement
	 * @return true
	 */
	public boolean saveReimbursement(Reimbursement reimbursement) {
		reimbursementRepo.save(reimbursement);
		return true;
	}

	/**
	 * This method is used to get the reimbursement requests of an employee
	 * @param empId
	 * @return
	 */
	public List<Reimbursement> getReimbursementById(int empId) {
		log.info("Before findByEmployeeId call");
		List<Reimbursement> myReimbursement = reimbursementRepo.findByEmployeeId(empId);
		return myReimbursement;
	}


	/**
	 * This is to update a reimbursement request to approve/deny/reassign
	 * @param id
	 * @param reimbursement
	 * @return true
	 */
	public boolean updateReimbursement(int id, Reimbursement reimbursement) {
		Reimbursement reimbursementData = reimbursementRepo.findById(id);

		log.debug("reimbursementData = "+reimbursementData);
		reimbursementData.setAmount(reimbursement.getAmount());
		reimbursementData.setDescription(reimbursement.getDescription());
		reimbursementData.setStatus(reimbursement.getStatus());
		reimbursementData.setSubmittedDate(reimbursement.getSubmittedDate());
		reimbursementData.setEmployeeId(reimbursement.getEmployeeId());
		reimbursementRepo.save(reimbursementData);
		return true;

	}

	/**
	 * To get all the reimbursement requests
	 * @return List Reimbursement
	 */
	public List<Reimbursement> getAllReimbursements(){
		log.info("Before Calling findAll in getAllReimbursements");
		return reimbursementRepo.findAll();
	}


}

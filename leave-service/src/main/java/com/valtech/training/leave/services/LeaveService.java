package com.valtech.training.leave.services;

import java.util.List;

import com.valtech.training.leave.vos.ApproveLeaveVO;
import com.valtech.training.leave.vos.EmployeeVO;
import com.valtech.training.leave.vos.LeaveMasterVO;
import com.valtech.training.leave.vos.LeaveVO;

public interface LeaveService {

	
	List<LeaveVO> getAllLeaves();

	LeaveVO getLeave(long id);

	LeaveVO saveOrUpdateLeave(LeaveVO vo);

	List<LeaveVO> getLeavesByEmployee(long emp);

	LeaveMasterVO getLeaveMaster(long employeeId);

	LeaveMasterVO saveOrUpdateLeaveMaster(LeaveMasterVO vo);

	List<LeaveMasterVO> getAllLeaveMasters();

	LeaveVO update(LeaveVO vo, long id);

	LeaveVO approveLeave(ApproveLeaveVO vo);

	LeaveVO applyLeave(LeaveVO vo);

	EmployeeVO getManager(long employeeId);

}
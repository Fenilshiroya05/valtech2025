package com.valtech.training.leave.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.leave.commons.LeaveStatus;
import com.valtech.training.leave.commons.LeaveType;
import com.valtech.training.leave.vos.ApproveLeaveVO;
import com.valtech.training.leave.vos.LeaveVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LeaveControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testApplyAndApprove() {
		String url="http://localhost:"+port+"/api/v1/leaves/";
		LeaveVO vo=restTemplate.postForObject(url, new LeaveVO(0,"08-03-1997","09-03-1997",LeaveType.SICK.name(),LeaveStatus.APPLIED.name(),
				"Having fever","",6),LeaveVO.class);
		assertTrue(vo.id() !=0);
		assertEquals(vo.leaveStatus(), LeaveStatus.APPLIED.name());
		ApproveLeaveVO avo= new ApproveLeaveVO(vo.id(), "Your leave is Approved", 5);
		vo= restTemplate.postForObject(url+"approve", avo, LeaveVO.class);
		assertEquals(vo.leaveStatus(), LeaveStatus.APPROVED.name());
	}
	
	@Test
	void test() {
		String url ="http://localhost:"+port+"/api/v1/leaves/";
		List l = restTemplate.getForObject(url, List.class);
		if(l.size()==0) {
			restTemplate.postForObject(url, new LeaveVO(0,"08-03-1997","09-03-1997",LeaveType.SICK.name(),LeaveStatus.APPLIED.name(),
					"Having fever","",6),LeaveVO.class);
			restTemplate.postForObject(url, new LeaveVO(0,"09-05-2024","13-05-2025",LeaveType.CASUAL.name(),LeaveStatus.APPLIED.name(),
					"Going to native","",5),LeaveVO.class);
			restTemplate.postForObject(url, new LeaveVO(0,"10-06-2021","15-06-2021",LeaveType.OTHERS.name(),LeaveStatus.APPLIED.name(),
					"For personal issue","",6),LeaveVO.class);
		}
	}

}

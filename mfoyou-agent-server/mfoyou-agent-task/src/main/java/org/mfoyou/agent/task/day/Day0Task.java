package org.mfoyou.agent.task.day;

import org.mfoyou.agent.utils.common.Logger;
import org.springframework.stereotype.Service;


@Service
public class Day0Task {
	
	Logger logger = Logger.getLogger(Day0Task.class);

//	@Autowired
//	private IStaffUser iStaffUser;

	public void run() {
		logger.info("begin makeMfoyouServicePriceeffect");
//		iStaffUser.makeMfoyouServicePriceeffect();
		logger.info("finsh makeMfoyouServicePriceeffect");

	}

}

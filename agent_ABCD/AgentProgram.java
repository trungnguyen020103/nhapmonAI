package agent_ABCD;

import agent_ABCD.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		// dirty
		if(p.getLocationState()==LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		}else {
			// clean 
			// Location = A
			if(p.getAgentLocation()=="A") {
				return Environment.MOVE_RIGHT;
			}else if(p.getAgentLocation()=="C") {
					return Environment.MOVE_LEFT;
			}else if(p.getAgentLocation()=="D") {
				return Environment.MOVE_BOT;
		}
			
			else {
				// Location = B
				return Environment.MOVE_TOP;
			}
		}
		

	}
}
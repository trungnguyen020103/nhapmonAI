package agent_AB;

import agent_AB.Environment.LocationState;

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
			}else {
				// Location = B
				return Environment.MOVE_LEFT;
			}
		}
		

	}
}
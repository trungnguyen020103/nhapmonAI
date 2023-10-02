package agent_ABCD;

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_TOP = new DynamicAction("TOP");
	public static final Action MOVE_BOT = new DynamicAction("BOT");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	public static final String LOCATION_C = "C";
	public static final String LOCATION_D = "D";

	public enum LocationState {
		CLEAN, DIRTY
	}

	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

	public Environment(LocationState locAState, LocationState locBState) {
		envState = new EnvironmentState(locAState, locBState);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		this.agent =agent;
		envState.setAgentLocation(location);	
				
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
		String getLocation = envState.getAgentLocation();
		if(action == Environment.SUCK_DIRT) {
			envState.setLocationState(getLocation, LocationState.CLEAN);
			System.out.println("Agent SUCKs at (" + getLocation + ")");
            System.out.println("Score: +500 points");
		
		}else if(action == Environment.MOVE_RIGHT) {
			if (getLocation.equals(LOCATION_A)) {
                envState.setAgentLocation(LOCATION_B);
            }else {
                System.out.println("Agent tries to MOVE_RIGHT but can't move.");
                System.out.println("Score: -100 points");}
		}else if(action ==Environment.MOVE_TOP) {
			if (getLocation.equals(LOCATION_B)) {
                envState.setAgentLocation(LOCATION_C);
            }else {
                System.out.println("Agent tries to MOVE_TOP but can't move.");
                System.out.println("Score: -100 points");
            }
			
		}else if(action ==Environment.MOVE_BOT) {
			 if (getLocation.equals(LOCATION_D)) {
	                envState.setAgentLocation(LOCATION_A);
	            }else {
	                System.out.println("Agent tries to MOVE_BOT but can't move.");
	                System.out.println("Score: -100 points");
	            }
	}
		else  {
			envState.setAgentLocation(LOCATION_A);
		}
		
		return envState;
	}
	
		
		
	
	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		String location = envState.getAgentLocation();
		LocationState locationState = envState.getLocationState(location);
		return new Percept(location, locationState);
				
	}

	public void step() {
	    envState.display();
	    String agentLocation = this.envState.getAgentLocation();
	    Action anAction = agent.execute(getPerceptSeenBy());
	    EnvironmentState es = executeAction(anAction);

	    System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);

	    // Kiểm tra xem tất cả các ô (A, B, C, D) đã được làm sạch
	    if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
	            && (es.getLocationState(LOCATION_B) == LocationState.CLEAN)
	            && (es.getLocationState(LOCATION_C) == LocationState.CLEAN)
	            && (es.getLocationState(LOCATION_D) == LocationState.CLEAN)) {
	        isDone = true; // Nếu tất cả các ô đều đã sạch, thì môi trường hoàn thành
	    }

	    // Hiển thị trạng thái môi trường sau khi thực hiện hành động
	    es.display();
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("-------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 0;

		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}
	
}

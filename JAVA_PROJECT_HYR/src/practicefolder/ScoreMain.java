package practicefolder;

public class ScoreMain {

	public static void main(String[] args) {
		StudentManager manager = StudentManager.getStudentManagerInstance();
		
		manager.menuStart(manager);
	
	}

}

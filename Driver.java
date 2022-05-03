
public class Driver implements DriverInterface {

	
	
	@Override
	public DoubleEndedQueue<Integer> fillDoubleEndedQueue(TestType testType) {
		// TODO Auto-generated method stub
		
		
		DoubleEndedQueue<Integer> test = new DoubleEndedQueue<Integer>();		

		if(testType == TestType.AddAllToBack) {
			for(int j = 1; j <= 1_000; j++) {
				test.addBack(j);
			}
			//test = new DoubleEndedQueue<Integer>();
		}
		if(testType == TestType.AddAllToFront){
			for(int j = 1; j<= 1_000; j++) {
				test.addFront(j);
			}
			
		}
		if(testType == TestType.AddEvenFrontOddBack ) {
			for(int j = 2; j <= 1_000; j+=2) {
				test.addFront(j);
			}
			for(int i = 1; i <= 1_000; i+=2) {
				test.addBack(i);
			}
		}
		return test;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//DoubleEndedQueue<Integer> fillDoubleEndedQueue run = new DoubleEndedQueue<Integer> fillDoubleEndedQueue();
		DoubleEndedQueue<Integer> test = new DoubleEndedQueue<Integer>();
		System.out.println("Add back " + test.peekBack() );
		
		//System.out.println(a);

	}

}

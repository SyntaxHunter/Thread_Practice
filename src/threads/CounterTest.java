package threads;

public class CounterTest {

	static int ctr = 0;
	
	public static void main(String[] args){
		Thread[] threads = new Thread[10];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new Thread(()->{
				for(int j = 0; j < 100; j++){
					ctr++;
				}
			});
		}
		
		for(Thread t : threads){
			t.start();
		}
		
		for(Thread t : threads){
			try{
				t.join();
			} catch(Exception e){
				System.out.println("Exception Caught");
			}
		}
		
		System.out.println("Ctr = " + ctr);
		
	}
	
}

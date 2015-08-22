package top.duyt.test;

import org.junit.Test;

public class CommonTest {
	

	
	@Test
	public void test01(){
		Target t1 = new Target();
		Target t2 = new Target();
		
		t1.val = 10;
		t2.val = 20;
		
		System.out.println("t1:"+ t1.val + " t2:"+t2.val);
		
		t1 = t2;

		System.out.println("t1:"+ t1.val + " t2:"+t2.val);
		
		t2.val = 999;
		System.out.println("t1:"+ t1.val + " t2:"+t2.val);
	}

	private class Target{
		int val;
	}

	
}



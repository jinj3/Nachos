package nachos.vm;

import java.util.ArrayList;

import nachos.machine.*;
import nachos.threads.*;
import nachos.userprog.*;
import nachos.vm.*;

/**
 * A kernel that can support multiple demand-paging user processes.
 */
public class VMKernel extends UserKernel {
	/**
	 * Allocate a new VM kernel.
	 */
	public VMKernel() {
		super();
		for (int i = 0; i < iPageTable.length; i++)
		{
			iPageTable[i] = null;
		}
	}

	/**
	 * Initialize this kernel.
	 */
	public void initialize(String[] args) {
		
		pinLock = new Lock();
		
		super.initialize(args);
	}

//	public static class MetaData {
//		// virtual page number
//		int vpn;
//		
//		// 
//	}

	/**
	 * Test this kernel.
	 */
	public void selfTest() {
		super.selfTest();
	}

	/**
	 * Start running user programs.
	 */
	public void run() {
		super.run();
	}

	/**
	 * Terminate this kernel. Never returns.
	 */
	public void terminate() {
		super.terminate();
	}
	
	
	
	public void pinPage(Integer i){
        pinLock.acquire();
        pinnedPages.add(i);
        pinLock.release();
    }
	
	public void unPinPage(Integer i){
        pinLock.acquire();
        pinnedPages.remove(i);
        pinLock.release();
    }
	
	protected ArrayList<Integer> pinnedPages;
	private Lock pinLock;
	
	public static VMProcess[] iPageTable = new VMProcess[Machine.processor().getNumPhysPages()]; 

	// dummy variables to make javac smarter
	private static VMProcess dummy1 = null;

	private static final char dbgVM = 'v';
}

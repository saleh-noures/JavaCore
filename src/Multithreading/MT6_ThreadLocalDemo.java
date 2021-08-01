package Multithreading;/*
 * 1- A value stored in a ThreadLocal instance is specific (local) to the current running thread and any other code logic running on the same
 *    thread will see the same value, but not the values set on the same instance by other threads. (There are exceptions, like InheritableThreadLocal, which inherits its parent threads values by default.)
 * 2- ThreadLocal can be considered as a scope of access, like a request scope or session scope. It's a thread scope
 * 3- One possible (and common) use is when you have an object that is not thread-safe, but you want to avoid synchronizing access to that object.
 *    Instead, give each thread its own instance of the object.
 * 4- The value object put into the ThreadLocal would not purge itself (garbage collected) if there are no more strong references to it
 *    and Java garbage collection would clean up the ThreadLocal map if the thread itself is not strongly referenced elsewhere.
 *    So now the question is: when would the thread object get garbage collected. The answer is: it depends, but always assume the thread is long-running.
 *    Think of The threads that handle servlet requests which are usually stay alive in the container for the lifetime of the server instance.
 * */


/*     Case Study
 *  We can point out one use case where I used thread local. Consider you have a Servlet which calls some business methods. You have a requirement to generate a unique transaction id
 *  for each and every request this servlet process and you need to pass this transaction id to the business methods, for logging purpose.
 *  One solution would be passing this transaction id as a parameter to all the business methods. But this is not a good solution as the code is redundant and unnecessary.
 *  To solve that, you can use Thread Local. You can generate a transaction id (either in the servlet or better still in a filter) and set it in the Thread Local.
 *  After this, what ever the business method, that this servlet calls, can access the transaction id from the thread local.
 *  This servlet might be servicing more than one request at a time. Since each request is processed in separate thread, the transaction id will be unique to each
 *  thread (local) and will be accessible from all over the threads execution (global).
 * */

class Context{

	// All data related to a thread can be stored here
	Long transId;

	public Long getTransId()
	{
		return transId;
	}

	public void setTransId(Long transId)
	{
		this.transId = transId;
	}
}

class ThreadLocalContextManager{

	private  static final  ThreadLocal<Context> threadLocalCtxt = new ThreadLocal<>();

	public static Context getThreadLocalContext()
	{
		return threadLocalCtxt.get();
	}

	public static void setThreadLocalContext(Context threadLocalContext)
	{
		threadLocalCtxt.set(threadLocalContext);
	}

    public static void removeThreadLocalContext()
	{
		threadLocalCtxt.remove();
	}

}

public class MT6_ThreadLocalDemo {

	public static void main(String[] args)
	{
		TransactionRunnable tr = new TransactionRunnable();
		Thread t1 = new Thread(tr, "t1");
		Thread t2 = new Thread(tr, "t2");
		Thread t3 = new Thread(tr, "t3");

		t1.start();
		t2.start();
		t3.start();
	}

}

class TransactionRunnable implements Runnable{

	public void run()
	{
		Context context = new Context();
		context.setTransId(getTransactionID());
		ThreadLocalContextManager.setThreadLocalContext(context);

		TransactionService ts = new TransactionService();
		ts.CommitTrans();
		ts.RollbackTrans();
		
		ThreadLocalContextManager.removeThreadLocalContext();

	}

	private Long getTransactionID()
	{
		Long TransId = (Long) Math.round((Math.random() * 100));
		System.out.println(Thread.currentThread().getName() + " Has TransID " + TransId);
		return TransId;
	}
}

class TransactionService{

	public void CommitTrans()
	{
        System.out.println( Thread.currentThread().getName() + " ,TransID: "+ ThreadLocalContextManager.getThreadLocalContext().getTransId() +" Has Been Committed");
	}

	public void RollbackTrans()
	{
		System.out.println( Thread.currentThread().getName() + " ,TransID: "+ ThreadLocalContextManager.getThreadLocalContext().getTransId() +" Has Been RolledBack");
	}

}

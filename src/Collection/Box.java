package Collection;

public class Box<S  extends Comparable<S>, T> implements Comparable<Box<S,T>> {  //A Generic Types (classes & interfaces)

	private S Index;
	private T desc;


	public S getIndex() {
		return Index;
	}

	public void setIndex(S index) {
		Index = index;
	}


	public T getDesc() {
		return desc;
	}

	public void setDesc(T descP) {
		desc = descP;
	}


	public Box(S IndP,T DescP)
	{
		Index = IndP;
		desc = DescP;
	}

	public <V> String printMe(V user)  //A Generic Method
	{
		return "The main executed by: "+ user;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Box))
		      return false;
		if (o == this)
		      return true;
		@SuppressWarnings("unchecked")
		Box<S,T> b = (Box<S,T>)o;
		return getDesc().toString().equalsIgnoreCase(b.getDesc().toString()) && getIndex() == b.getIndex();
	}

	/*
	 * Why always override hashcode() if overriding equals()?

	In Java, every object has access to the equals() method because it is inherited from the Object class.
	However, this default implementation just simply compares the memory addresses of the objects. You can override the default implementation of the equals() method defined in java.lang.Object.
	If you override the equals(), you MUST also override hashCode(). Otherwise a violation of the general contract for Object.hashCode will occur,  which can have unexpected repercussions
	when your class is in conjunction with all hash-based collections.

	Here is the contract, copied from the java.lang.Object specialization:

	public int hashCode()
	Returns a hash code value for the object. This method is supported for the benefit of hashtables such as those provided by java.util.Hashtable.

	The general contract of hashCode is:

	1- Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer, provided no
	   information used in equals comparisons on the object is modified. This integer need not remain consistent from one execution of an application to another execution of the same application.
	2- If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.
	3- It is not required that if two objects are unequal according to the equals(java.lang.Object) method, then calling the hashCode method on each of the two objects must produce distinct
	   integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hashtables.

	*  From : http://www.xyzws.com/javafaq/why-always-override-hashcode-if-overriding-equals/20
	*/

	public int hashCode() {
		return  ((Integer) getIndex()).intValue();
		}

	@Override
	public int compareTo(Box<S, T> o) {
			return this.getIndex().compareTo(o.getIndex());
	}

}


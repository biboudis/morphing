package testcases;

import java.util.*;

public class SynchronizeMe<interface T> implements T {
    final T me;
    final Object mutex;

    public SynchronizeMe (T t) {
	me = t;
	mutex = this;
    }


    <R,A*>[m] for ( !final R m (A) : T.methods) 
    public R m (A args) {
	return me.m(args);
    }

    /*
    <R>[m] for ( !final R m () : T.methods )
    public R m () {
	return me.m();
    }
    */

    public static void main (String[] argv) {
	List myList = new ArrayList();
	SynchronizeMe<List> synchronizedList = 
	    new SynchronizeMe<List>(myList);
	myList.add("a");
	myList.add("b");
	System.out.println("size:" + synchronizedList.size());

	List sublist = synchronizedList.subList(0,1);
	System.out.println("sublist size: " + sublist.size());
    }
}

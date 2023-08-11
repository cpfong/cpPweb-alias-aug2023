/***************************************************
Simple Counter class that increments or decrements
the internal value

@author Scott Grissom
@version Septemeber 3, 2002
*****************************************************/
public class Counter {

   /** current total */
   private int total;

   /** maximum value the counter can store */
   final private int MAX = 5;

   /** minimum value the counter can store */
   final private int MIN = 0;


/***********************************************************
Default constructor initializes the total
***********************************************************/
public Counter(){
   total = MIN;
}


/***********************************************************
Get Counter

@return the current total
***********************************************************/
public int getCount(){
   return total;
}


/***********************************************************
Increment the total by one but do not exceed MAX

@return void
***********************************************************/
public void increment(){
   total++;
   if (total > MAX)
      total = MAX;
}


/***********************************************************
Decrement the total by one but do not go below MIN

@return void
***********************************************************/
public void decrement(){
   total--;
   if (total < MIN)
      total = MIN;
}



/***********************************************************
Test whether the total is currently at MAX

@return true if total is currently at MAX
***********************************************************/
public boolean atMax(){
   if (total == MAX)
      return true;
   else
      return false;
}


/***********************************************************
Test whether the total is currently at MIN

@return true if total is currently at MIN
***********************************************************/
public boolean atMin(){
   if (total == MIN)
      return true;
   else
      return false;
}

/***********************************************************
Reset the total to MIN

@return void
***********************************************************/
public void reset(){
   total = MIN;
}


} // end of Counter class

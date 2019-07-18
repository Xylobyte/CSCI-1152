/*
Lab3_dgriego125: finds the fastest and second fastest time along with name in an array.
Donovan Griego
*/

class Lab3_dgriego125 {
    public static void main (String[] arguments){
      String[] names ={
        "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
        "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
        "Aaron", "Kate"
  };
  
      int[] times ={
        341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
        343, 317, 265
      };
  
      int i1 = fastestIndex(times);
      int i2 = secondFastestIndex(times);
      System.out.println("Name           Time (minutes)");
      System.out.println("------------------------------");
      System.out.println(names[i1] + "           " + times[i1] + " (fastest time)");
      System.out.println(names[i2] + "           " + times[i2] + " (second fastest time)");
    }
    
    public static int fastestIndex(int[] numbers){    //fastestindex: takes numbers array in, finds the smallest number, and returns the index of that number
		int minValue = numbers[0], index = 1;
		for(int i=1;i<numbers.length;i++){
			if(numbers[i] < minValue){
                minValue = numbers[i];
                index = i;
			}
		}
		return index;
	}

    public static int secondFastestIndex(int[] numbers) {    //secondfastestindex: takes numbers array in, finds the second smallest number, and returns the index of that number
        int min = numbers[0], index = 1, second_min= 100000000;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]==min){
              second_min=min;
            } else if (numbers[i] < min) {
                second_min = min;
                min = numbers[i];
            } else if (numbers[i] < second_min) {
                second_min = numbers[i];
                index = i;
            }
    
        }
        return index;
    }
}
  
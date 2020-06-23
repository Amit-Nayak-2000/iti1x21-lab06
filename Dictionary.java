public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
        elems = new Pair[INITIAL_CAPACITY];
        count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        if(count < getCapacity()){
            elems[count] = new Pair(key, value);
            count++;
        }
        else{
            increaseCapacity();
            elems[count] = new Pair(key,value);
            count++;
        }
    }

    private void increaseCapacity() {
       Pair[] newelems = new Pair[getCapacity() + INCREMENT];

       for(int i = 0; i < getCapacity(); i++){
           newelems[i] = elems[i];
       }

       elems = newelems;
    }

    @Override
    public boolean contains(String key) {
        boolean result = false;

        for(int i = 0; i < getCount(); i++){
            if(elems[i].getKey() == key){
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public Integer get(String key) {
        int i = getCount() - 1;
        boolean found = false;
        while(found == false && i>=0){
            if(elems[i].getKey().equals(key)){
                found = true;
            }
            else{
                i--;
            }
        }

        return elems[i].getValue();
    }

    @Override
    public void replace(String key, Integer value) {
        int i = getCount() - 1;
        boolean found = false;
        while(found == false && i>=0){
            if(elems[i].getKey().equals(key)){
                found = true;
            }
            else{
                i--;
            }
        }

        elems[i].setValue(value);
    }

    @Override
    public Integer remove(String key) {
        int i = getCount() - 1;
        boolean found = false;
        while(found == false && i>=0){
            if(elems[i].getKey().equals(key)){
                found = true;
            }
            else{
                i--;
            }
        }

        Integer result =  elems[i].getValue();

        while(i < getCount() - 1){
            elems[i] = elems[i+1];
            i++;
        }

        count--;
        elems[count] = null;

        return result;
    }

    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }

}

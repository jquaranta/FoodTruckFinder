import java.util.Comparator;

public class FoodTruck {
    //vars
    private String _name;
    private String _address;

    //constructors
    FoodTruck(String name, String address)
    {
        this._name = name;
        this._address = address;
    }

    //properties
    public String getName()
    {
        return this._name;
    }
    public String getAddress()
    {
        return this._address;
    }
    public void setName( String name ) {
        this._name = name;
    }
    public void setAddress( String address ) {
        this._address = address;
    }

    //comparators
    public static Comparator<FoodTruck> FoodTruckComparator = new Comparator<FoodTruck>() {

        public int compare(FoodTruck ft1, FoodTruck ft2) {
            String FoodTruckName1 = ft1.getName().toUpperCase();
            String FoodTruckName2 = ft2.getName().toUpperCase();

            //ascending order, swap for descending
            return FoodTruckName1.compareTo(FoodTruckName2);
        }};
}

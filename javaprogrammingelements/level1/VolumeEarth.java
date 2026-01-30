/*
Write a Program to compute the volume of Earth in km^3 and miles^3
Hint => Volume of a Sphere is (4/3) * pi * r^3 and radius of earth is 6378 km
O/P => The volume of earth in cubic kilometers is ____ and cubic miles is ____
*/
class VolumeEarth {
    public static void main(String[] args) {

        // Radius of the Earth in kilometers
        int radius = 6378;

        // Convert radius from kilometers to miles
        double radiusMile = 6378 * 1.6;

        // Value of pi
        double pi = 3.14;
        
        // Calculate volume of Earth in cubic kilometers
        double volumeRadius = (4 / 3) * pi * radius * radius * radius;

        // Calculate volume of Earth in cubic miles
        double volumeMile = (4 / 3) * pi * radiusMile * radiusMile * radiusMile;
        
        // Display volumes in cubic kilometers and cubic miles
        System.out.println(
            "The volume of earth in cubic kilometers is " + volumeRadius +
            "and cubic miles is " + volumeMile
        );
    }
}


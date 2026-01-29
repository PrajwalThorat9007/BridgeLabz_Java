/*
Write a Program to compute the volume of Earth in km^3 and miles^3
Hint => Volume of a Sphere is (4/3) * pi * r^3 and radius of earth is 6378 km
O/P => The volume of earth in cubic kilometers is ____ and cubic miles is ____
*/
class VolumeEarth{
    public static void main(String[] args){
        int radius=6378;
        double radiusMile=6378*1.6;
        double pi=3.14;
        
        double volumeRadius=(4/3)*pi*radius*radius*radius;
        double volumeMile=(4/3)*pi*radiusMile*radiusMile*radiusMile;
        
        System.out.println("The volume of earth in cubic kilometers is "+volumeRadius+"and cubic miles is "+volumeMile);
    }
}

package com.example.saifkhan.distancetimeandfairofaroot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tDistance = (TextView) findViewById(R.id.set_distance);
        TextView tTime = (TextView) findViewById(R.id.set_time);
        TextView tFair = (TextView) findViewById(R.id.set_fair);

        point r1 = new point("Saif's Home",24.385905, 88.612416);
        point r2 = new point("BGB Turn",24.385305, 88.612131);
        point r3 = new point("BGB Canteen",24.385402, 88.611661);
        point r4 = new point("BGB Gate",24.385377, 88.611569);
        point r5 = new point("Professorpara Mosque",24.384322, 88.610727);
        point r6 = new point("Woodmill",24.383986, 88.610301);
        point r7 = new point("p",24.383917, 88.610271);
        point r8 = new point("p",24.383826, 88.610278);
        point r9 = new point("Powerhouse",24.383133, 88.609893);
        point r10 = new point("p",24.383062, 88.609671);
        point r11 = new point("p",24.382874, 88.609419);
        point r12 = new point("Shalbagan Mor",24.383023, 88.608135);

        ArrayList<point> Route1 = new ArrayList<>();
        Route1.add(r1);
        Route1.add(r2);
        Route1.add(r3);
        Route1.add(r4);
        Route1.add(r5);
        Route1.add(r6);
        Route1.add(r7);
        Route1.add(r8);
        Route1.add(r9);
        Route1.add(r10);
        Route1.add(r11);
        Route1.add(r12);

        Double distance = routedistance("Saif's Home","Shalbagan Mor", Route1);

        Double time =  (distance*60/25);
        tDistance.setText(distance+" KM");
        tTime.setText(time + " m");
        tFair.setText((40+distance*10+time*10)+" Tk");

    }
    static Double routedistance(String StartRoutename,String EndRoutename, ArrayList<point> array) {
        int f=0;
        Double sum =0.0;
        for(int i =0; i<array.size()-1;i++) {
            point p = array.get(i);
            point p1 = array.get(i+1);
            if(EndRoutename==p.Name) {
                break;
            }
            if(StartRoutename==p.Name) {
                f=1;
            }
            if(f==1) {

                sum =Distance(p,p1)+sum;
            }
        }
        return sum;
    }

    static Double Distance (point obj1, point obj2) {
        final int R = 6371; // Radious of the earth
        Double lat1 = obj1.getlatitude();
        Double lon1 = obj1.getlongitude() ;
        Double lat2 = obj2.getlatitude() ;
        Double lon2 = obj2.getlongitude() ;
        Double latDistance = toRad(lat2-lat1);
        Double lonDistance = toRad(lon2-lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;
        return distance;
    }

    private static Double toRad(Double value) {

        return value * Math.PI / 180;
    }
}

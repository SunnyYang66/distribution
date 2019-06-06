package org.mfoyou.agent.utils.common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GisUtils {
    public static String  BLANK             = "";
    public static String  ZERO              = "0";
    private static double EARTH_RADIUS      = 6378.137;
    /** 
     * VincentyConstants 
     * Constants for Vincenty functions. 
     */
    public static double  vincentyConstantA = 6378137;
    public static double  vincentyConstantB = 6356752.3142;
    public static double  vincentyConstantF = 1 / 298.257223563;

    public static void writeTextFile(String content, String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        bw.write(content);
        bw.flush();
        bw.close();
        System.out.println("文件生成成功,生成目录:" + path);
    }

    public static String getASType(String javaType) {
        if (javaType.equals("List")) {
            return "ArrayCollection";
        }
        if (javaType.equals("boolean")) {
            return "Boolean";
        }
        return javaType;
    }

    public static String lowerCaseFirstChar(String str) {
        char[] c = str.toCharArray();
        if (c[0] >= 'A' && c[0] <= 'Z') {
            c[0] = (char) (c[0] + ('a' - 'A'));
            str = new String(c);
        }
        return str;
    }

    public static String upperCaseFirstChar(String str) {
        char[] c = str.toCharArray();
        if (c[0] >= 'a' && c[0] <= 'z') {
            c[0] = (char) (c[0] + ('A' - 'a'));
            str = new String(c);
        }
        return str;
    }

    public static String getServiceName(String methodName) {
        if (methodName.startsWith("get")) {
            return methodName.substring(3);
        } else if (methodName.startsWith("adminGet")) {
            return "Admin" + methodName.substring(8);
        } else {
            return null;
        }
    }

    public static Integer GetDistance(Double lng1, Double lat1, Double lng2, Double lat2) {
        if (lng1 == null || lat1 == null || lng2 == null || lat2 == null) {
            return null;
        }
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return (int) s;
    }

    //根据两个点坐标计算它们之间的距离（按照圆球体计算，粗略计算）  
    public static double getDistance(double y1, double x1, double y2, double x2) {
        double rady1 = rad(y1);
        double rady2 = rad(y2);
        double a = rady1 - rady2;
        double b = rad(x1) - rad(x2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(rady1) * Math.cos(rady2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = (double) (Math.round(s * 10000) / 10000);
        return s;
    }

    //转换弧度  
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /** 
     * Given two objects representing points with geographic coordinates, this 
     *     calculates the distance between those points on the surface of an 
     *     ellipsoid. 按照椭球体计算，精确计算 
     * 
     * Returns: 
     * The distance (in km) between the two input points as measured on an 
     *     ellipsoid.  Note that the input point objects must be in geographic 
     *     coordinates (decimal degrees) and the return distance is in kilometers. 
     */
    public static double distVincenty(double y1, double x1, double y2, double x2) {
        double a = vincentyConstantA;
        double b = vincentyConstantB;
        double f = vincentyConstantF;

        double L = degtoRad(x2 - x1);
        double U1 = Math.atan((1 - f) * Math.tan(degtoRad(y1)));
        double U2 = Math.atan((1 - f) * Math.tan(degtoRad(y2)));
        double sinU1 = Math.sin(U1);
        double cosU1 = Math.cos(U1);
        double sinU2 = Math.sin(U2);
        double cosU2 = Math.cos(U2);
        double lambda = L;
        double lambdaP = 2 * Math.PI;
        double iterLimit = 20;

        double sinLambda = 0.0d;
        double cosLambda = 0.0d;
        double sinSigma = 0.0d;
        double cosSigma = 0.0d;
        double sigma = 0.0d;
        double alpha = 0.0d;
        double cosSqAlpha = 0.0d;
        double cos2SigmaM = 0.0d;
        double C = 0.0d;

        while (Math.abs(lambda - lambdaP) > 1e-12 && --iterLimit > 0) {
            sinLambda = Math.sin(lambda);
            cosLambda = Math.cos(lambda);
            sinSigma = Math.sqrt((cosU2 * sinLambda) * (cosU2 * sinLambda) + (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda) * (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda));
            if (sinSigma == 0) {
                return 0; // co-incident points  
            }
            cosSigma = sinU1 * sinU2 + cosU1 * cosU2 * cosLambda;
            sigma = Math.atan2(sinSigma, cosSigma);
            alpha = Math.asin(cosU1 * cosU2 * sinLambda / sinSigma);
            cosSqAlpha = Math.cos(alpha) * Math.cos(alpha);
            cos2SigmaM = cosSigma - 2 * sinU1 * sinU2 / cosSqAlpha;
            C = f / 16 * cosSqAlpha * (4 + f * (4 - 3 * cosSqAlpha));
            lambdaP = lambda;
            lambda = L + (1 - C) * f * Math.sin(alpha) * (sigma + C * sinSigma * (cos2SigmaM + C * cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM)));
        }
        if (iterLimit == 0) {
            return 0.0; // formula failed to converge  
        }
        double uSq = cosSqAlpha * (a * a - b * b) / (b * b);
        double A = 1 + uSq / 16384 * (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
        double B = uSq / 1024 * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));
        double deltaSigma = B * sinSigma
                            * (cos2SigmaM + B / 4 * (cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM) - B / 6 * cos2SigmaM * (-3 + 4 * sinSigma * sinSigma) * (-3 + 4 * cos2SigmaM * cos2SigmaM)));
        double s = b * A * (sigma - deltaSigma);
        //      double d = Number(s.toFixed(3))/1000; // round to 1mm precision  
        double d = s / 1000; // round to 1mm precision  
        return d;
    }

    /** 
     * Convert degrees to radian 
     * 
     * @param val Value to convert  
     */
    public static double degtoRad(double val) {
        return val * Math.PI / 180;
    }
}
